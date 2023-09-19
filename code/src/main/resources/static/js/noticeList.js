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