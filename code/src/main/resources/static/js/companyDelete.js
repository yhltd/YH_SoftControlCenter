function getList(){
    var system = $('#add-system').val();
    $ajax({
        type: 'post',
        url: '/account/getCompany',
        data: {
            system: system,
        },
    }, false, '', function (res) {
        if (res.code == 200) {
            console.log(res.data);
            var option = ""
            for(var i=0; i<res.data.length; i++){
                option = option + "<option value=\"" + res.data[i].company + "\">" + res.data[i].company + "</option>"
            }
            $('#add-company').html(option)
        }
    })
}

$(function () {

    getList()

    $("#add-system").change(function () {
        var system = $('#add-system').val();
        $ajax({
            type: 'post',
            url: '/account/getCompany',
            data: {
                system: system,
            },
        }, false, '', function (res) {
            if (res.code == 200) {
                console.log(res.data);
                var option = ""
                for(var i=0; i<res.data.length; i++){
                    option = option + "<option value=\"" + res.data[i].company + "\">" + res.data[i].company + "</option>"
                }
                $('#add-company').html(option)
            }
        })

    })


    $("#add-submit-btn").click(function () {
        var system = $('#add-system').val();
        var company = $('#add-company').val();

        if (company == "") {
            alert("请填写公司！");
            return;
        }

        if (checkForm('#add-form')) {
            $ajax({
                type: 'post',
                url: '/account/deleteCompany',
                data: {
                    system: system,
                    company: company,
                },
            }, false, '', function (res) {
                if (res.code == 200) {
                    // alert(res.msg);
                    // $('#add-form')[0].reset();
                    // location.href="companyDelete.html"
                } else {
                    alert(res.msg);
                }
            })

            $ajax({
                type: 'post',
                url: '/pushnews/deleteCompany',
                data: {
                    system: system,
                    company: company,
                },
            }, false, '', function (res) {
                if (res.code == 200) {
                    // alert(res.msg);
                    // $('#add-form')[0].reset();
                    // location.href="companyDelete.html"
                } else {
                    alert(res.msg);
                }
            })

            if (system = "云合未来财务系统"){
                system = "财务"
            }else if (system = "云合人事管理系统"){
                system = "人事"
            }else if (system = "云合未来进销存系统"){
                system = "进销存"
            }else if (system = "云合未来进销存系统mssql"){
                system = "进销存"
            }else if (system = "云合排产管理系统"){
                system = "排产"
            }else if (system = "云合分权编辑系统"){
                system = "分权"
            }else if (system = "云合未来教务系统"){
                system = "教务"
            }else if (system = "云合未来教务系统mssql"){
                system = "教务"
            }else if (system = "云合智慧门店收银系统"){
                system = "门店"
            }else if (system = "云合信息采集系统"){
                system = "采集"
            }

            $ajax({
                type: 'post',
                url: '/control/deleteCompany',
                data: {
                    system: system,
                    company: company,
                },
            }, false, '', function (res) {
                if (res.code == 200) {
                    alert(res.msg);
                    $('#add-form')[0].reset();
                    location.href="companyDelete.html"
                } else {
                    alert(res.msg);
                }
            })
        }
    });

});