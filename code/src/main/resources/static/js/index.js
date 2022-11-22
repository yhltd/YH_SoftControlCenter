$(function () {
    $("#submit-btn").click(function () {
        if (checkForm('#login-form')) {
            let params = formToJson('#login-form');
            $ajax({
                type: 'post',
                url: 'control/login',
                data: {
                    name: params.name,
                    password: params.password
                }
            }, false, '', function (res) {
                if (res.code > 0) {
                    alert(res.msg);
                    setTimeout(function () {
                        window.location.href = "html/main.html";
                    }, 1500);
                } else {
                    alert(res.msg);
                }
            })
        }
    })
});