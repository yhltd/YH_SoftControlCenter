function getList() {
    $('#company').val("");
    $('#username').val("");
    $ajax({
        type: 'post',
        url: '/account/getList',
        data: {
            system: '',
            company: '',
            username: '',
        },
    }, false, '', function (res) {
        if (res.code == 200) {
            console.log(res.data)
            for(var i=0; i<res.data.length; i++){
                if(res.data[i].idstr != null){
                    res.data[i].id = res.data[i].idstr
                }
            }
            setTable(res.data);
        }
    })
}

$(function () {
    getList();

    //刷新
    $("#refresh-btn").click(function () {
        getList();
    });

    $('#select-btn').click(function () {
        var system = $('#system').val();
        var company = $('#company').val();
        var username = $('#username').val();

        $ajax({
            type: 'post',
            url: '/account/getList',
            data: {
                system: system,
                company: company,
                username: username,
            },
        }, false, '', function (res) {
            if (res.code == 200) {
                for(var i=0; i<res.data.length; i++){
                    if(res.data[i].idstr != null){
                        res.data[i].id = res.data[i].idstr
                    }
                }
                setTable(res.data);
            }
        })
    });

    //点击禁用按钮
    $('#jinyong-btn').click(function () {
        var msg = confirm("确认要禁用吗？");
        if (msg) {
            let rows = getTableSelection("#accountTable");
            if (rows.length == 0) {
                alert('请选择要禁用的数据！');
                return;
            }
            let idList = [];
            let systemList = [];
            $.each(rows, function (index, row) {
                idList.push(row.data.id);
                systemList.push(row.data.system);
            });
            $ajax({
                type: 'post',
                url: '/account/jinyong',
                data: JSON.stringify({
                    idList: idList,
                    systemList:systemList,
                }),
                dataType: 'json',
                contentType: 'application/json;charset=utf-8'
            }, false, '', function (res) {
                if (res.code == 200) {
                    alert(res.msg);
                    getList();
                } else {
                    alert(res.msg);
                }
            })
        }
    });

    //点击禁用按钮
    $('#jiejin-btn').click(function () {
        var msg = confirm("确认要解禁吗？");
        if (msg) {
            let rows = getTableSelection("#accountTable");
            if (rows.length == 0) {
                alert('请选择要解禁的数据！');
                return;
            }
            let idList = [];
            let systemList = [];
            $.each(rows, function (index, row) {
                idList.push(row.data.id);
                systemList.push(row.data.system);
            });
            $ajax({
                type: 'post',
                url: '/account/jiejin',
                data: JSON.stringify({
                    idList: idList,
                    systemList:systemList,
                }),
                dataType: 'json',
                contentType: 'application/json;charset=utf-8'
            }, false, '', function (res) {
                if (res.code == 200) {
                    alert(res.msg);
                    getList();
                } else {
                    alert(res.msg);
                }
            })
        }
    })

    //点击删除按钮
    $('#delete-btn').click(function () {
        var msg = confirm("确认要删除吗？")
        if (msg) {
            let rows = getTableSelection("#accountTable");
            if (rows.length == 0) {
                alert('请选择要删除的数据！')
                return;
            }
            let idList = [];
            let systemList = [];
            $.each(rows, function (index, row) {
                idList.push(row.data.id)
                systemList.push(row.data.system);
            })
            $ajax({
                type: 'post',
                url: '/account/delete',
                data: JSON.stringify({
                    idList: idList,
                    systemList:systemList,
                }),
                dataType: 'json',
                contentType: 'application/json;charset=utf-8'
            }, false, '', function (res) {
                alert(res.msg);
                if (res.code == 200) {
                    getList();
                }
            })
        }
    })

});


function setTable(data) {
    if ($('#accountTable').html != '') {
        $('#accountTable').bootstrapTable('load', data);
    }

    $('#accountTable').bootstrapTable({
        data: data,
        sortStable: true,
        classes: 'table table-hover text-nowrap table table-bordered',
        idField: 'id',
        pagination: true,
        pageSize: 20,//单页记录数
        clickToSelect: true,
        locale: 'zh-CN',
        toolbar: '#table-toolbar',
        toolbarAlign: 'left',
        theadClasses: "thead-light",//这里设置表头样式
        style: 'table-layout:fixed',
        height: document.body.clientHeight * 0.85,
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
                field: 'system',
                title: '系统名称',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'company',
                title: '公司名称',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'username',
                title: '用户名',
                align: 'center',
                sortable: true,
                width: 150,
            }, {
                field: 'password',
                title: '密码',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'state',
                title: '状态',
                align: 'center',
                sortable: true,
                width: 100,
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