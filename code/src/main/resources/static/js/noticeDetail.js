function checkNotice() {
    console.log($.session.get('id'))
    $ajax({
        type: 'post',
        url: '/notice/checkNotice',
        data:{
            id:$.session.get('id')
        },
        async: false
    }, false, '', function (res) {
        if (res != "" ){
            var obj=res;
            console.log(res)
            $('#uname').html(obj.uname)
            $('#detail').html(obj.detail)
            $('#fdate').html(obj.fdate)


        }
    })

}

$(function () {
    checkNotice()


    $('#select-btn').click(function () {


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

    $('#body_insert').click(function () {
        $('#pic_file').trigger('click');
        fileType = "body"
    });

    $('#pic_file').change(function () {
        var file = document.getElementById("pic_file").files;
        var oFReader = new FileReader();
        var this_file = file[0];
        var fileName = file[0].name;
        oFReader.readAsDataURL(this_file);
        oFReader.onloadend = function (oFRevent) {
            this_file = oFRevent.target.result;
            console.log(fileType)
            console.log(this_file)

            body_pic = this_file
            $('body').css('background','url(' + this_file + ') no-repeat')
            $('body').css('background-size','cover')

            $('#pic_file').val('')
        };
    });

});

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

