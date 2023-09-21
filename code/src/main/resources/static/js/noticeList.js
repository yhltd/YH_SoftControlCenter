function getNotice() {
    $ajax({
        type: 'post',
        url: '/notice/getNotice',
    }, false, '', function (res) {
        if (res.length>0 ){
            console.log(res)
            setTable(res);
        }
    })

}

$(function () {
    getNotice();

    //查询
    $("#refresh-btn").click(function () {
        getList();
    });

    $('#select-btn').click(function () {
        var system = $('#system').val();
        var company = $('#company').val();
        var username = $('#username').val();

        $ajax({
            type: 'post',
            url: '/notice/getNotice',
            data: {

            },
        }, false, '', function (res) {
            if (res.code == 200) {
                setTable(res.data);
            }
        })
    });


    //点击删除按钮
    $('#delete-btn').click(function () {
        var msg = confirm("确认要删除吗？")
        if (msg) {
            let rows = getTableSelection("#noticeTable");
            if (rows.length == 0) {
                alert('请选择要删除的数据！')
                return;
            }
            let idList = [];
            let systemList = [];
            $.each(rows, function (index, row) {
                idList.push(row.data.id)
            })
            $ajax({
                type: 'post',
                url: '/notice/delNotice',
                data: JSON.stringify({
                    idList: idList,
                }),
                dataType: 'json',
                contentType: 'application/json;charset=utf-8'
            }, false, '', function (res) {
                if (res.code == 200) {
                    getNotice();
                }
            })
        }
    })

});
function pass(id) {
    $.session.set('id', id)
    $.session.set('type', "详情")
    document.location.href = 'noticeDetail.html'
}



function setTable(data) {
    if ($('#noticeTable').html != '') {
        $('#noticeTable').bootstrapTable('load', data);
    }

    $('#noticeTable').bootstrapTable({
        data: data,
        sortStable: true,
        classes: 'table table-hover text-nowrap table table-bordered',
        idField: 'id',
        pagination: true,
        pageSize: 10,//单页记录数
        clickToSelect: true,
        locale: 'zh-CN',
        toolbar: '#table-toolbar',
        toolbarAlign: 'left',
        theadClasses: "thead-light",//这里设置表头样式
        style: 'table-layout:fixed',
        // height: document.body.clientHeight * 0.85,
        columns: [
            {
                field: '',
                title: '序号',
                align: 'center',
                width: 50,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'uname',
                title: '当事人',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'uid',
                title: '身份证号',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'address',
                title: '地址',
                align: 'center',
                sortable: true,
                width: 150,
            }, {
                field: 'uinfo',
                title: '联系人信息',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'picture',
                title: '照片',
                align: 'center',
                sortable: true,
                width: 100,
                formatter: function (value, row, index) {
                    return '<button onclick="javascript:fileShow1(' + row.id + ')" class="btn-sm btn-default">下载</button>'
                }

            },{
                field: 'video',
                title: '视频',
                align: 'center',
                sortable: true,
                width: 100,
                formatter: function (value, row, index) {
                    return '<button onclick="javascript:fileShow2(' + row.id + ')" class="btn-sm btn-default">下载</button>'
                }
            },{
                field: 'lei',
                title: '公告类型',
                align: 'center',
                sortable: true,
                width: 100,
            },{
                field: 'fdate',
                title: '发布时间',
                align: 'center',
                sortable: true,
                width: 100,
            },
            {
                field: '',
                title: '详情',
                align: 'center',
                sortable: true,
                width: 100,
                formatter: function (value, row, index) {
                    return '<button onclick="javascript:pass(' + row.id + ')" class="btn-sm btn-default">详情</button>'            }
            },
        ],
        onClickRow: function (row, el) {
            let isSelect = $(el).hasClass('selected');
            if (isSelect) {
                $(el).removeClass('selected')
            } else {
                $(el).addClass('selected')
            }
        }
    })
}


function fileShow1(id) {
    idd = id
    p_type = 'picture'
    $ajax({
        type: 'post',
        url: '/notice/dowloadFile',
        data: {
            id: id,
        },
        async: false,
    }, false, '', function (res) {
        if (res.data[0].pictureName != '' && res.data[0].pictureName != null) {
            downloadFileByBase64(res.data[0].pictureName, res.data[0].picture.split(',')[1])
        } else {
            alert('未上传文件！')
        }
    })
}

function fileShow2(id) {
    idd = id
    p_type = 'video'
    $ajax({
        type: 'post',
        url: '/notice/dowloadFile',
        data: {
            id: id,
        },
        async: false,
    }, false, '', function (res) {
        if (res.data[0].videoName != '' && res.data[0].videoName != null) {
            downloadFileByBase64(res.data[0].videoName, res.data[0].video.split(',')[1])
        } else {
            alert('未上传文件！')
        }
    })
}



function dataURLtoBlob(dataurl, name) {//name:文件名
    var mime = name.substring(name.lastIndexOf('.') + 1)//后缀名
    var bstr = atob(dataurl), n = bstr.length, u8arr = new Uint8Array(n);
    while (n--) {
        u8arr[n] = bstr.charCodeAt(n);
    }
    return new Blob([u8arr], {type: mime});
}

function downloadFile(url, name = '默认文件名') {
    var a = document.createElement("a")//创建a标签触发点击下载
    a.setAttribute("href", url)//附上
    a.setAttribute("download", name);
    a.setAttribute("target", "_blank");
    let clickEvent = document.createEvent("MouseEvents");
    clickEvent.initEvent("click", true, true);
    a.dispatchEvent(clickEvent);
}

//主函数
function downloadFileByBase64(name, base64) {
    var myBlob = dataURLtoBlob(base64, name);
    var myUrl = URL.createObjectURL(myBlob);
    downloadFile(myUrl, name)
}

//获取后缀
function getType(file) {
    var filename = file;
    var index1 = filename.lastIndexOf(".");
    var index2 = filename.length;
    var type = filename.substring(index1 + 1, index2);
    return type;
}

//根据文件后缀 获取base64前缀不同
function getBase64Type(type) {
    switch (type) {
        case 'data:text/plain;base64':
            return 'txt';
        case 'data:application/msword;base64':
            return 'doc';
        case 'data:application/vnd.openxmlformats-officedocument.wordprocessingml.document;base64':
            return 'docx';
        case 'data:application/vnd.ms-excel;base64':
            return 'xls';
        case 'data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64':
            return 'xlsx';
        case 'data:application/pdf;base64':
            return 'pdf';
        case 'data:application/vnd.openxmlformats-officedocument.presentationml.presentation;base64':
            return 'pptx';
        case 'data:application/vnd.ms-powerpoint;base64':
            return 'ppt';
        case 'data:image/png;base64':
            return 'png';
        case 'data:image/jpeg;base64':
            return 'jpg';
        case 'data:image/gif;base64':
            return 'gif';
        case 'data:image/svg+xml;base64':
            return 'svg';
        case 'data:image/x-icon;base64':
            return 'ico';
        case 'data:image/bmp;base64':
            return 'bmp';
    }
}

function base64ToBlob(code) {
    code = code.replace(/[\n\r]/g, '');
    const raw = window.atob(code);
    const rawLength = raw.length;
    const uInt8Array = new Uint8Array(rawLength);
    for (let i = 0; i < rawLength; ++i) {
        uInt8Array[i] = raw.charCodeAt(i)
    }
    return new Blob([uInt8Array], {type: 'application/pdf'})
}