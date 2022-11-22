$(function () {
    $("#add-submit-btn").click(function () {
        var system = $('#add-system').val();
        var company = $('#add-company').val();
        var username = $('#add-username').val();
        var password = $('#add-password').val();

        if (company == "") {
            alert("请填写公司！");
            return;
        }
        if (username == "") {
            alert("请填写用户名！");
            return;
        }
        if (password == "") {
            alert("请填写用密码！");
            return;
        }

        if (checkForm('#add-form')) {
            $ajax({
                type: 'post',
                url: '/control/insert',
                data: {
                    system: system,
                    company: company,
                    username: username,
                    password: password,
                },
            }, false, '', function (res) {
                if (res.code == 200) {
                    alert(res.msg);
                    $('#add-form')[0].reset();
                } else {
                    alert(res.msg);
                }
            })
        }
    });

});