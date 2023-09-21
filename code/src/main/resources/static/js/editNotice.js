let idd = '';
let p_file;
let p_fileName
let p_type
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

function clean(){
    idd = ''
    $('#uname').val('');
    $('#uid').val('');
    $('#address').val('');
    $('#uinfo').val('');
    $('#lei').val('');
    $('#fdate').val('');
    $('#detail').val('');
}

$(function () {
    getNotice();

    $('#check1').click(function () {
        var uname = $('#input1').val();

        $ajax({
            type: 'post',
            url: '/notice/checkNoticeByname',
            data: {
                uname:uname,
            },
        }, false, '', function (res) {
            console.log(res)
            if (res != "") {
                setTable(res);
            }
        })
    });

    $('#addnotice').click(function () {
        if(idd==""){
            var uname = $('#uname').val();
            var uid = $('#uid').val();
            var address = $('#address').val();
            var uinfo = $('#uinfo').val();
            var picture = $('#picture').val();
            var lei = $('#lei').val();
            var fdate = $('#fdate').val();
            var detail = $('#detail').val();
            // var oFReader = new FileReader();
            // oFReader.readAsDataURL(this_file);
            // oFReader.onloadend = function (oFRevent) {
            //     this_file = oFRevent.target.result;
            //     fileName_num = fileName_num + 1
            //     obj = {
            //         // "otherId":otherId,
            //         // "type":'原料商品',
            //         "fileName": fileName_list[fileName_num],
            //         "files": this_file,
            //     }
            // }
            //
            $ajax({
                type: 'post',
                url: '/notice/addNotice',
                data:{
                    uname:uname,
                    uid:uid,
                    address:address,
                    uinfo:uinfo,
                    picture:picture,
                    lei:lei,
                    fdate:fdate,
                    detail:detail,
                },
                dataType: 'json',
            }, false, '', function (res) {
                if (res > 0) {
                    document.location.href = 'editNotice.html'
                }
            })
        }else {

            var uname = $('#uname').val();
            var uid = $('#uid').val();
            var address = $('#address').val();
            var uinfo = $('#uinfo').val();
            var picture = $('#picture').val();
            var lei = $('#lei').val();
            var fdate = $('#fdate').val();
            var detail = $('#detail').val();


            $ajax({
                type: 'post',
                url: '/notice/updateNotice',
                data:{
                    id:idd,
                    uname:uname,
                    uid:uid,
                    address:address,
                    uinfo:uinfo,
                    lei:lei,
                    fdate:fdate,
                    detail:detail,
                },
                dataType: 'json',
            }, false, '', function (res) {
                if (res > 0) {
                    alert("修改成功！")
                    document.location.href = 'editNotice.html'
                }
            })

        }
    });


    $('#file').change(function () {
        var file = document.getElementById("file").files;
        var oFReader = new FileReader();
        var this_file = file[0];
        var fileName = file[0].name;
        var obj = [];
        oFReader.readAsDataURL(this_file);
        oFReader.onloadend = function (oFRevent) {
            this_file = oFRevent.target.result;
            if(p_type == 'picture'){
                obj = {
                    "id": idd,
                    "pictureName": fileName,
                    "picture": this_file,
                };
            }else{
                obj = {
                    "id": idd,
                    "videoName": fileName,
                    "video": this_file,
                };
            }

            $ajax({
                type: 'post',
                url: '/notice/updFile',
                data: JSON.stringify({
                    addInfo: obj
                }),
                dataType: 'json',
                contentType: 'application/json;charset=utf-8',
                async: false,
            }, false, '', function (res) {
                if (res.code == 200) {
                    alert(res.msg)
                } else {
                    alert(res.msg)
                }
                var fileInput = document.getElementById('file');
                fileInput.outerHTML = fileInput.outerHTML;
            })
        };
    });


});



function delNotice(id){
    //点击删除按钮

        var msg = confirm("确认要删除吗？")
        if (msg) {
            let row =id
            console.log(row)
            $ajax({
                type: 'post',
                url: '/notice/delNotice',
                data:{
                    id:row,
                },
                dataType: 'json',
            }, false, '', function (res) {
                if (res > 0) {
                    getNotice();
                }
            })
        }

}



function pass(id) {

        $ajax({
        type: 'post',
        url: '/notice/checkNotice',
            data:{
            id:id,
            }
    }, false, '', function (res) {
        if (res != "" ){
            idd=id
            $('#uname').val(res.uname);
            $('#uid').val(res.uid);
            $('#address').val(res.address);
            $('#uinfo').val(res.uinfo);
            $('#picture').val(res.picture);
            $('#lei').val(res.lei);
            $('#fdate').val(res.fdate);
            $('#detail').val(res.detail);
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
            alert('请先上传文件！')
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
            alert('请先上传文件！')
        }
    })
}

function fileUp1(id) {
    idd = id
    p_type = 'picture'
    $('#file').trigger('click');
}

function fileUp2(id) {
    idd = id
    p_type = 'picture'
    $('#file').trigger('click');
}

// function pass2(id) {
//     $.session.set('id', id)
//     $.session.set('type', "删除")
//     document.location.href = 'randomText.html'
// }

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
                    return '<button onclick="javascript:fileShow1(' + row.id + ')" class="btn-sm btn-default">下载</button>' + '<button onclick="javascript:fileUp1(' + row.id + ')" class="btn-sm btn-default">上传</button>'
                }

            },{
                field: 'video',
                title: '视频',
                align: 'center',
                sortable: true,
                width: 100,
                formatter: function (value, row, index) {
                    return '<button onclick="javascript:fileShow2(' + row.id + ')" class="btn-sm btn-default">下载</button>' + '<button onclick="javascript:fileUp2(' + row.id + ')" class="btn-sm btn-default">上传</button>'
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
                field: 'detail',
                title: '详情',
                align: 'center',
                sortable: true,
                width: 100,
                },
            {
                field: '',
                title: '操作',
                align: 'center',
                sortable: true,
                width: 100,
                formatter: function (value, row, index) {
                    return '<button onclick="javascript:pass(' + row.id + ')" class="btn-sm btn-default" data-toggle="modal" data-target="#myModal">\n' +
                        ' 修改\n' +
                        '</button> <button onclick="javascript:delNotice(' + row.id + ')" class="btn-sm btn-default">删除</button>'            }
            },
        ],

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


