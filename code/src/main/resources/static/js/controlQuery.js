
function getList() {
    $('#query').val('')
    $ajax({
        type: 'post',
        url: '/control/getListJiami',
    }, false, '', function (res) {
        if (res.code == 200) {
            setTable(res.data);
        }
    })
}


$(function () {
    //刷新
    getList();

    $("#select-btn").click(function () {
        var query=$('#query').val()
        $ajax({
            type: 'post',
            url: '/control/queryListJiami',
            data:{
                query:query
            }
        }, false, '', function (res) {
            if (res.code == 200) {
                setTable(res.data);
            }
        })
    })

    $("#refresh-btn").click(function () {
        getList();
    })


    //点击修改按钮显示弹窗
    $('#update-btn').click(function () {
        let rows = getTableSelection('#accountTable')
        if (rows.length > 1 || rows.length == 0) {
            alert('请选择一条数据修改');
            return;
        }
        $('#update-modal').modal('show');
        console.log(rows[0].data)
        var this_data = rows[0].data
        console.log(this_data.name)
        this_data.name = this_data.name.trim()
        var startarr = this_data.starttime.split("/")
        var start = startarr[0]
        startarr[2] = startarr[2].trim()
        if(startarr[1].length < 2){
            start = start + "-0" + startarr[1]
        }else{
            start = start + "-" + startarr[1]
        }
        if(startarr[2].length < 2){
            start = start + "-0" + startarr[2]
        }else{
            start = start + "-" + startarr[2]
        }
        console.log(start)

        var endarr = this_data.endtime.split("/")
        var end = endarr[0]
        endarr[2] = endarr[2].trim()
        if(endarr[1].length < 2){
            end = end + "-0" + endarr[1]
        }else{
            end = end + "-" + endarr[1]
        }
        if(endarr[2].length < 2){
            end = end + "-0" + endarr[2]
        }else{
            end = end + "-" + endarr[2]
        }
        console.log(end)

        var mark2arr = this_data.mark2.split("/")
        var mark2 = mark2arr[0]
        mark2arr[2] = mark2arr[2].trim()
        if(mark2arr[1].length < 2){
            mark2 = mark2 + "-0" + mark2arr[1]
        }else{
            mark2 = mark2 + "-" + mark2arr[1]
        }
        if(mark2arr[2].length < 2){
            mark2 = mark2 + "-0" + mark2arr[2]
        }else{
            mark2 = mark2 + "-" + mark2arr[2]
        }
        console.log(mark2)

        this_data.starttime = start.trim()
        this_data.endtime = end.trim()
        this_data.softName = this_data.softName.trim()
        this_data.mark1 = this_data.mark1.trim()
        this_data.mark2 = mark2.trim()
        if(this_data.mark3 != null && this_data.mark3 != ""){
            this_data.mark3 = this_data.mark3.trim()
            this_data.mark3 = this_data.mark3.split(":")[1]
            if(this_data.mark3 != null && this_data.mark3 != ""){
                this_data.mark3 = this_data.mark3.replace("(","")
                this_data.mark3 = this_data.mark3.replace(")","")
            }
        }
        this_data.mark4 = this_data.mark4.trim()
        setForm(this_data, '#update-form');
    })

    //修改弹窗点击关闭按钮
    $('#update-close-btn').click(function () {
        $('#update-form')[0].reset();
        $('#update-modal').modal('hide');
    })

    //修改弹窗里点击提交按钮
    $('#update-submit-btn').click(function () {
        var msg = confirm("确认要修改吗？")
        if (msg) {
            let params = formToJson('#update-form');
            console.log(params)
            var starttime = params.starttime.split("-")
            var this_start = starttime[0]
            console.log(starttime[1].substr(0, 1))
            if(starttime[1].substr(0, 1) == '0'){
                this_start = this_start + '/' + starttime[1].substr(1, 1)

            }else{
                this_start = this_start + '/' + starttime[1]
            }
            if(starttime[2].substr(0, 1) == '0'){
                this_start = this_start + '/' + starttime[2].substr(1, 1)
            }else{
                this_start = this_start + '/' + starttime[2]
            }

            var endtime = params.endtime.split("-")
            var this_end = endtime[0]
            console.log(endtime[1].substr(0, 1))
            if(starttime[1].substr(0, 1) == '0'){
                this_end = this_end + '/' + endtime[1].substr(1, 1)

            }else{
                this_end = this_end + '/' + endtime[1]
            }
            if(endtime[2].substr(0, 1) == '0'){
                this_end = this_end + '/' + endtime[2].substr(1, 1)
            }else{
                this_end = this_end + '/' + endtime[2]
            }

            var mark2 = params.mark2.split("-")
            var this_mark2 = mark2[0]
            console.log(mark2[1].substr(0, 1))
            if(mark2[1].substr(0, 1) == '0'){
                this_mark2 = this_mark2 + '/' + mark2[1].substr(1, 1)

            }else{
                this_mark2 = this_mark2 + '/' + mark2[1]
            }
            if(mark2[2].substr(0, 1) == '0'){
                this_mark2 = this_mark2 + '/' + mark2[2].substr(1, 1)
            }else{
                this_mark2 = this_mark2 + '/' + mark2[2]
            }

            params.starttime = this_start
            params.endtime = this_end
            params.mark2 = this_mark2
            params.Id = params.id
            params.mark3 = "账号数量:(" + params.mark3 + ")"
            console.log(params)
            if (checkForm('#update-form')) {
                $ajax({
                    type: 'post',
                    url: '/control/updateJiami',
                    data: {
                        userInfoJson: JSON.stringify(params)
                    },
                    dataType: 'json',
                    contentType: 'application/json;charset=utf-8'
                }, false, '', function (res) {
                    alert(res.msg);
                    if (res.code == 200) {
                        $('#update-close-btn').click();
                        $('#update-modal').modal('hide');
                        getList();
                    }
                })
            }else{
                alert('信息填写不全，请检查！');
            }
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
            $.each(rows, function (index, row) {
                idList.push(row.data.id)
            })
            $ajax({
                type: 'post',
                url: '/control/deleteJiami',
                data: JSON.stringify({
                    idList: idList
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

})

function setTable(data) {
    if ($('#accountTable').html != '') {
        $('#accountTable').bootstrapTable('load', data);
    }
    var count = 0;
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
                field: 'Id',
                title: '序号',
                align: 'center',
                width: 80,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {
                field: 'name',
                title: '公司名(name)',
                align: 'center',
                sortable: true,
                width: 150,
                formatter:function(value, row , index){
                    if(value == null || value == ''){
                        value = '-'
                    }
                    return "<div title='"+value+"'; style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width: 100%;word-wrap:break-all;word-break:break-all;' href='javascript:edit(\""+row.id+"\",true)'>"+value+"</div>";
                }
            }, {
                field: 'starttime',
                title: '开始时间(starttime)',
                align: 'center',
                sortable: true,
                width: 200,
                formatter:function(value, row , index){
                    if(value == null || value == ''){
                        value = '-'
                    }
                    return "<div title='"+value+"'; style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width: 100%;word-wrap:break-all;word-break:break-all;' href='javascript:edit(\""+row.id+"\",true)'>"+value+"</div>";
                }
            }, {
                field: 'endtime',
                title: '软件到期时间(endtime)',
                align: 'center',
                sortable: true,
                width: 200,
                formatter:function(value, row , index){
                    if(value == null || value == ''){
                        value = '-'
                    }
                    return "<div title='"+value+"'; style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width: 100%;word-wrap:break-all;word-break:break-all;' href='javascript:edit(\""+row.id+"\",true)'>"+value+"</div>";
                }
            }
            ,{
                field: 'softName',
                title: '系统(soft_name)',
                align: 'center',
                sortable: true,
                width: 180,
                formatter:function(value, row , index){
                    if(value == null || value == ''){
                        value = '-'
                    }
                    return "<div title='"+value+"'; style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width: 100%;word-wrap:break-all;word-break:break-all;' href='javascript:edit(\""+row.id+"\",true)'>"+value+"</div>";
                }
            }
            ,{
                field: 'mark1',
                title: '买断(mark1)',
                align: 'center',
                sortable: true,
                width: 150,
                formatter:function(value, row , index){
                    if(value == null || value == ''){
                        value = '-'
                    }
                    return "<div title='"+value+"'; style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width: 100%;word-wrap:break-all;word-break:break-all;' href='javascript:edit(\""+row.id+"\",true)'>"+value+"</div>";
                }
            }
            ,{
                field: 'mark2',
                title: '服务器到期时间(mark2)',
                align: 'center',
                sortable: true,
                width: 200,
                formatter:function(value, row , index){
                    if(value == null || value == ''){
                        value = '-'
                    }
                    return "<div title='"+value+"'; style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width: 100%;word-wrap:break-all;word-break:break-all;' href='javascript:edit(\""+row.id+"\",true)'>"+value+"</div>";
                }
            }
            ,{
                field: 'mark3',
                title: '允许创建账号数量(mark3)',
                align: 'center',
                sortable: true,
                width: 220,
                formatter:function(value, row , index){
                    if(value == null || value == ''){
                        value = '-'
                    }
                    return "<div title='"+value+"'; style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width: 100%;word-wrap:break-all;word-break:break-all;' href='javascript:edit(\""+row.id+"\",true)'>"+value+"</div>";
                }
            }
            ,{
                field: 'mark4',
                title: '存储空间(mark4)',
                align: 'center',
                sortable: true,
                width: 180,
                formatter:function(value, row , index){
                    if(value == null || value == ''){
                        value = '-'
                    }
                    return "<div title='"+value+"'; style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width: 100%;word-wrap:break-all;word-break:break-all;' href='javascript:edit(\""+row.id+"\",true)'>"+value+"</div>";
                }
            }
        ],

        onClickRow: function (row, el) {
            let isSelect = $(el).hasClass('selected')
            if (isSelect) {
                $(el).removeClass('selected')
            } else {
                $(el).addClass('selected')
            }
        }

    })

}