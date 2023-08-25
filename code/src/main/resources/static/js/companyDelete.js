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