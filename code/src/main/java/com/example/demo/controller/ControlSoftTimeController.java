package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.util.GsonUtil;
import com.example.demo.util.ResultInfo;
import com.example.demo.util.SessionUtil;
import com.example.demo.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hui
 * @date 2022/11/16 14:19
 */
@Slf4j
@RestController
@RequestMapping("/control")
public class ControlSoftTimeController {
    @Autowired
    private ControlSoftTimeService controlSoftTimeService;
    @Autowired
    private YhJinxiaocunUserService yhJinxiaocunUserService;
    @Autowired
    private FinanceUserService financeUserService;
    @Autowired
    private FinancePowerService financePowerService;
    @Autowired
    private GongziUserService gongziUserService;
    @Autowired
    private GongziPowerService gongziPowerService;
    @Autowired
    private SchedulingUserService schedulingUserService;
    @Autowired
    private SchedulingPowerService schedulingPowerService;
    @Autowired
    private JiaowuUserService jiaowuUserService;
    @Autowired
    private JiaowuPowerService jiaowuPowerService;
    @Autowired
    private KaUserService kaUserService;
    @Autowired
    private KaPowerService kaPowerService;
    @Autowired
    private FenquanUserService fenquanUserService;
    @Autowired
    private FenquanPower1Service fenquanPower1Service;
    @Autowired
    private FenquanPower2Service fenquanPower2Service;
    @Autowired
    private FenquanPower3Service fenquanPower3Service;
    @Autowired
    private FenquanPower4Service fenquanPower4Service;


    @RequestMapping("/login")
    public ResultInfo login(HttpSession session, String name, String password) {
        try {
            //获取user
            Map<String, Object> map = controlSoftTimeService.login(name, password);

            //为Null则查询不到
            if (StringUtils.isEmpty(map)) {
                SessionUtil.remove(session, "token");
                return ResultInfo.error(-1, "用户名密码错误");
            } else {
                SessionUtil.setToken(session, map.get("token").toString());
                return ResultInfo.success("登陆成功", null);
            }
        } catch (Exception e) {
            log.error("登陆失败：{}", e.getMessage());
            log.error("参数：{}", name);
            log.error("参数：{}", password);
            return ResultInfo.error("错误!");
        }
    }

    /**
     * 添加
     */
    @RequestMapping("/insert")
    public ResultInfo insert(String username, String password, String company, String system) {
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
            if (system.equals("云合未来进销存系统")) {
                YhJinxiaocunUser yhJinxiaocunUser = new YhJinxiaocunUser();
                yhJinxiaocunUser.set_id(sdf.format(date));
                yhJinxiaocunUser.setName(username);
                yhJinxiaocunUser.setPassword(password);
                yhJinxiaocunUser.setBtype("正常");
                yhJinxiaocunUser.setAdminis("true");
                yhJinxiaocunUser.setGongsi(company);
                yhJinxiaocunUserService.add(yhJinxiaocunUser);
            } else if (system.equals("云合未来财务系统")) {
                FinanceUser financeUser = new FinanceUser();
                FinancePower financePower = new FinancePower();

                financeUser.setName(username);
                financeUser.setPwd(password);
                financeUser.set_do(password);
                financeUser.setCompany(company);
                financeUser.setBianhao(sdf.format(date));
                financeUserService.add(financeUser);

                financePower.setBianhao(sdf.format(date));
                financePower.setBmsz_add("是");
                financePower.setBmsz_delete("是");
                financePower.setBmsz_update("是");
                financePower.setBmsz_select("是");
                financePower.setJjtz_add("是");
                financePower.setJjtz_delete("是");
                financePower.setJjtz_update("是");
                financePower.setJjtz_select("是");
                financePower.setJjzz_add("是");
                financePower.setJjzz_delete("是");
                financePower.setJjzz_update("是");
                financePower.setJjzz_select("是");
                financePower.setKmzz_add("是");
                financePower.setKmzz_delete("是");
                financePower.setKmzz_update("是");
                financePower.setKmzz_select("是");
                financePower.setKzxm_add("是");
                financePower.setKzxm_delete("是");
                financePower.setKzxm_update("是");
                financePower.setKzxm_select("是");
                financePower.setLysy_select("是");
                financePower.setPzhz_add("是");
                financePower.setPzhz_delete("是");
                financePower.setPzhz_update("是");
                financePower.setPzhz_select("是");
                financePower.setXjll_select("是");
                financePower.setZcfz_select("是");
                financePower.setZnkb_select("是");
                financePower.setZhgl_add("是");
                financePower.setZhgl_delete("是");
                financePower.setZhgl_update("是");
                financePower.setZhgl_select("是");
                financePowerService.add(financePower);
            } else if (system.equals("云合人事管理系统")) {
                GongziUser gongziUser = new GongziUser();

                gongziUser.setB("管理员");
                gongziUser.setI(username);
                gongziUser.setJ(password);
                gongziUser.setL(company);
                gongziUserService.add(gongziUser);

                List<GongziUser> list = gongziUserService.getId();
                for (int i = 1; i <= 12; i++) {
                    GongziPower gongziPower = new GongziPower();
                    gongziPower.setViewId(i + "");
                    gongziPower.setRId(list.get(0).getId());
                    gongziPower.setAdd("1");
                    gongziPower.setDel("1");
                    gongziPower.setUpd("1");
                    gongziPower.setSel("1");
                    gongziPower.setLook("1");
                    gongziPowerService.add(gongziPower);
                }
            } else if (system.equals("云合排产管理系统")) {
                SchedulingUser schedulingUser = new SchedulingUser();
                schedulingUser.setUserCode(username);
                schedulingUser.setPassword(password);
                schedulingUser.setDepartmentName("默认部门");
                schedulingUser.setCompany(company);
                schedulingUser.setState("正常");
                schedulingUserService.add(schedulingUser);

                for (int i = 1; i <= 12; i++) {
                    SchedulingPower schedulingPower = new SchedulingPower();
                    if (i == 1) {
                        schedulingPower.setViewName("订单");
                    } else if (i == 2) {
                        schedulingPower.setViewName("排产");
                    } else if (i == 3) {
                        schedulingPower.setViewName("工作时间及休息日");
                    } else if (i == 4) {
                        schedulingPower.setViewName("模块单位");
                    } else if (i == 5) {
                        schedulingPower.setViewName("BOM");
                    } else if (i == 6) {
                        schedulingPower.setViewName("排班");
                    } else if (i == 7) {
                        schedulingPower.setViewName("账号管理");
                    } else if (i == 8) {
                        schedulingPower.setViewName("排班明细");
                    } else if (i == 9) {
                        schedulingPower.setViewName("排产核对");
                    } else if (i == 10) {
                        schedulingPower.setViewName("汇总");
                    } else if (i == 11) {
                        schedulingPower.setViewName("部门");
                    } else {
                        schedulingPower.setViewName("人员信息");
                    }
                    schedulingPower.setDepartmentName("默认部门");
                    schedulingPower.setCompany(company);
                    schedulingPower.setAdd("是");
                    schedulingPower.setDel("是");
                    schedulingPower.setUpd("是");
                    schedulingPower.setSel("是");
                    schedulingPowerService.add(schedulingPower);
                }
            } else if (system.equals("云合未来教务系统")) {
                JiaowuUser jiaowuUser = new JiaowuUser();
                jiaowuUser.setUsername(username);
                jiaowuUser.setPassword(password);
                jiaowuUser.setCompany(company);
                jiaowuUser.setState("正常");
                jiaowuUserService.add(jiaowuUser);

                List<JiaowuUser> list = jiaowuUserService.getId();

                for (int i = 1; i <= 13; i++) {
                    JiaowuPower jiaowuPower = new JiaowuPower();
                    if (i == 1) {
                        jiaowuPower.setViewName("学生信息");
                    } else if (i == 2) {
                        jiaowuPower.setViewName("教师信息");
                    } else if (i == 3) {
                        jiaowuPower.setViewName("权限管理");
                    } else if (i == 4) {
                        jiaowuPower.setViewName("用户管理");
                    } else if (i == 5) {
                        jiaowuPower.setViewName("缴费记录");
                    } else if (i == 6) {
                        jiaowuPower.setViewName("课时统计");
                    } else if (i == 7) {
                        jiaowuPower.setViewName("收支明细");
                    } else if (i == 8) {
                        jiaowuPower.setViewName("欠费学员");
                    } else if (i == 9) {
                        jiaowuPower.setViewName("教师工资");
                    } else if (i == 10) {
                        jiaowuPower.setViewName("教师课时统计");
                    } else if (i == 11) {
                        jiaowuPower.setViewName("考勤表");
                    } else if (i == 12) {
                        jiaowuPower.setViewName("教师课表");
                    } else {
                        jiaowuPower.setViewName("设置");
                    }
                    jiaowuPower.setTId(list.get(0).getId());
                    jiaowuPower.setCompany(company);
                    jiaowuPower.setAdd("√");
                    jiaowuPower.setDel("√");
                    jiaowuPower.setUpd("√");
                    jiaowuPower.setSel("√");
                    jiaowuPowerService.add(jiaowuPower);
                }
            } else if (system.equals("云合卡管理系统")) {
                KaUser kaUser = new KaUser();
                kaUser.setAccount(username);
                kaUser.setPassword(password);
                kaUser.setCompany(company);
                kaUserService.add(kaUser);

                List<KaUser> list = kaUserService.getId();

                for (int i = 1; i <= 5; i++) {
                    KaPower kaPower = new KaPower();
                    kaPower.setUid(list.get(0).getId());
                    kaPower.setTable(i + "");
                    kaPower.setAdd("1");
                    kaPower.setDel("1");
                    kaPower.setUpd("1");
                    kaPower.setSel("1");
                    kaPowerService.add(kaPower);
                }

            } else if (system.equals("云合分权编辑系统")) {
                FenquanUser fenquanUser = new FenquanUser();
                fenquanUser.setBumen("默认部门");
                fenquanUser.setB(company);
                fenquanUser.setD(username);
                fenquanUser.setE(password);
                fenquanUser.setRenyuanId(sdf.format(date));
                fenquanUser.setZhuangtai("正常");
                fenquanUserService.add(fenquanUser);

                FenquanPower3 fenquanPower3 = new FenquanPower3();
                fenquanPower3.setCompany(company);
                fenquanPower3Service.add(fenquanPower3);

                FenquanPower4 fenquanPower4 = new FenquanPower4();
                fenquanPower4.setB(company);
                fenquanPower4Service.add(fenquanPower4);

                for (int i = 0; i < 2; i++) {
                    FenquanPower1 fenquanPower1 = new FenquanPower1();
                    fenquanPower1.setRenyuanId(sdf.format(date));
                    fenquanPower1.setQuanxian(company);
                    fenquanPower1.setB(username);
                    if (i == 0) {
                        fenquanPower1.setChashanquanxian("查询");
                    } else {
                        fenquanPower1.setChashanquanxian("修改");
                    }
                    fenquanPower1Service.add(fenquanPower1);
                }
                for (int i = 1; i <= 8; i++) {
                    FenquanPower2 fenquanPower2 = new FenquanPower2();
                    fenquanPower2.setCompany(company);
                    fenquanPower2.setDepartmentName("默认部门");
                    fenquanPower2.setIns("是");
                    fenquanPower2.setDel("是");
                    fenquanPower2.setUpd("是");
                    fenquanPower2.setSel("是");
                    if (i == 1) {
                        fenquanPower2.setViewName("工作台");
                    } else if (i == 2) {
                        fenquanPower2.setViewName("工作台权限设置");
                    } else if (i == 3) {
                        fenquanPower2.setViewName("部门权限设置");
                    } else if (i == 4) {
                        fenquanPower2.setViewName("公司数据分析");
                    } else if (i == 5) {
                        fenquanPower2.setViewName("人员管理");
                    } else if (i == 6) {
                        fenquanPower2.setViewName("人员权限设置");
                    } else if (i == 7) {
                        fenquanPower2.setViewName("人员数据分析");
                    } else {
                        fenquanPower2.setViewName("工作台使用状态");
                    }

                    fenquanPower2Service.add(fenquanPower2);
                }
            }

            return ResultInfo.success("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("添加失败：{}", e.getMessage());
            return ResultInfo.error("添加失败");
        }
    }


}
