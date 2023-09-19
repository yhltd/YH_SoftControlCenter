let idd = '';

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
                    picture:picture,
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
                // formatter: function (value, row, index) {
                //     return '<img decoding="async" src="' + img/111.phg + '" class="img-rounded">'   }

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