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

    $("#add-zhanghao").click(function () {
        // 直接生成月日时分秒
        var now = new Date();
        var month = (now.getMonth() + 1).toString().padStart(2, '0');
        var day = now.getDate().toString().padStart(2, '0');
        var hours = now.getHours().toString().padStart(2, '0');
        var minutes = now.getMinutes().toString().padStart(2, '0');
        var seconds = now.getSeconds().toString().padStart(2, '0');

        var dateTimeStr = month + day + hours + minutes + seconds;
        var mima = seconds +"123456"

        $('#add-username').val(dateTimeStr);
        $('#add-password').val(mima);

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

                getList()
                var info = "公司名称：" + company +
                    "\n账号：" + username +
                    "\n密码：" + password;

                prompt("添加成功！请复制基础信息：", info);

            } else {
                alert("创建账号失败！");
            }
        })

    });

});

var pushList = {};
var gg = "";

function getList() {

    $.ajax({
        type: 'GET',
        url: '/pushnews/getc',
        success: function(res) {
            pushList =  res[0];
            var status = $('input[name="status"]:checked').val();
            if (status == 1) {
                gg = "不隐藏广告"
            } else if (status == 0) {
                gg = "隐藏广告"
            } else {
                gg = "不隐藏广告"
            }

            var system = $('#add-system').val();

            if (system === "云合未来进销存系统mssql") {
                system = "云合未来进销存系统";
            } else if (system === "云合未来教务系统mssql") {
                system = "教务管理系统";
            }else if (system === "云合未来教务系统") {
                system = "教务管理系统";
            }else if (system === "云合信息采集系统") {
                system = "云合未来信息采集系统";
            }else if (system === "云合分权编辑系统") {
                system = "分权编辑系统";
            }else if (system === "云合未来财务系统") {
                system = "云合未来财务系统";
            }else if (system === "云合排产管理系统") {
                system = "云合排产管理系统";
            }else if (system === "云合人事管理系统") {
                system = "云合人事管理系统";
            }else if (system === "云合智慧门店收银系统") {
                system = "云合智慧门店收银系统";
            }

            var company = $('#add-company').val();

            var formObject = {
                beizhu1:gg,
                beizhu2:pushList.beizhu2,
                beizhu3:pushList.beizhu3,
                beizhu4:pushList.beizhu4,
                beizhu5: pushList.beizhu5,
                beizhu6: pushList.beizhu6,
                beizhu7: pushList.beizhu7,
                beizhu8:pushList.beizhu8,
                beizhu9: pushList.beizhu9,
                beizhu10: pushList.beizhu10,
                date: pushList.date,
                gsname: company,
                qidate: pushList.qidate,
                textbox: pushList.textbox,
                topgao: pushList.topgao,
                topkuan: pushList.topkuan,
                tpname1: pushList.tpname1,
                tpname2: pushList.tpname2,
                tpname3: pushList.tpname3,
                tpname4: pushList.tpname4,
                tpname5: pushList.tpname5,
                tpname6: pushList.tpname6,
                tptop1: pushList.tptop1,
                tptop2: pushList.tptop2,
                tptop3: pushList.tptop3,
                tptop4: pushList.tptop4,
                tptop5: pushList.tptop5,
                tptop6: pushList.tptop6,
                xtname: system,
                xuangao: pushList.xuangao,
                xuankuan: pushList.xuankuan,
                zhidate: pushList.zhidate,
            };

            $.ajax({
                type: 'POST',
                url: '/pushnews/add',
                contentType: 'application/json',
                data: JSON.stringify(formObject),
                success: function(response) {
                    if (response > 0) {
                    } else {
                        alert('添加推送数据失败，请手动创建推送内容！');
                    }
                },
                error: function(xhr) {
                    alert('添加推送数据失败，请手动创建推送内容！');
                }
            });


        },
        error: function(xhr, status, error) {
            console.error('获取数据失败:', error);
            alert('获模板数据失败，请手动创建推送内容！');
        }
    });
}