package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private CaiJiUserService caiJiUserService;

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
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/M/d");
            if (system.equals("云合未来进销存系统")) {
                YhJinxiaocunUser yhJinxiaocunUser = new YhJinxiaocunUser();
                yhJinxiaocunUser.set_id(sdf.format(date));
                yhJinxiaocunUser.setName(username);
                yhJinxiaocunUser.setPassword(password);
                yhJinxiaocunUser.setBtype("正常");
                yhJinxiaocunUser.setAdminis("true");
                yhJinxiaocunUser.setGongsi(company);
                yhJinxiaocunUserService.add(yhJinxiaocunUser);
                List<ControlSoftTime> jiami = controlSoftTimeService.selectCompany("进销存",company);
                if(jiami.size() == 0){
                    ControlSoftTime this_jiami = new ControlSoftTime();
                    List<ControlSoftTime2> maxId = controlSoftTimeService.selectId();
                    this_jiami.setId(Integer.parseInt(maxId.get(0).getMaxid())+1);
                    this_jiami.setName(company);
                    this_jiami.setStarttime(sdf2.format(date));
                    this_jiami.setEndtime("2060/1/1");
                    this_jiami.setSoftName("进销存");
                    this_jiami.setMark1("");
                    this_jiami.setMark2("2030/12/31");
                    this_jiami.setMark4("1048576");
                    controlSoftTimeService.add(this_jiami);
                }
            } else if (system.equals("云合未来财务系统")) {
                FinanceUser financeUser = new FinanceUser();
                FinancePower financePower = new FinancePower();

                financeUser.setName(username);
                financeUser.setPwd(password);
                financeUser.set_do(password);
                financeUser.setCompany(company);
                financeUser.setBianhao(sdf.format(date));
                financeUserService.add(financeUser);

                List<ControlSoftTime> jiami = controlSoftTimeService.selectCompany("财务",company);
                if(jiami.size() == 0){
                    ControlSoftTime this_jiami = new ControlSoftTime();
                    List<ControlSoftTime2> maxId = controlSoftTimeService.selectId();
                    this_jiami.setId(Integer.parseInt(maxId.get(0).getMaxid())+1);
                    this_jiami.setName(company);
                    this_jiami.setStarttime(sdf2.format(date));
                    this_jiami.setEndtime("2060/1/1");
                    this_jiami.setSoftName("财务");
                    this_jiami.setMark1("");
                    this_jiami.setMark2("2030/12/31");
                    this_jiami.setMark4("1048576");
                    controlSoftTimeService.add(this_jiami);
                }

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

                List<ControlSoftTime> jiami = controlSoftTimeService.selectCompany("人事",company);
                if(jiami.size() == 0){
                    ControlSoftTime this_jiami = new ControlSoftTime();
                    List<ControlSoftTime2> maxId = controlSoftTimeService.selectId();
                    this_jiami.setId(Integer.parseInt(maxId.get(0).getMaxid())+1);
                    this_jiami.setName(company);
                    this_jiami.setStarttime(sdf2.format(date));
                    this_jiami.setEndtime("2060/1/1");
                    this_jiami.setSoftName("人事");
                    this_jiami.setMark1("");
                    this_jiami.setMark2("2030/12/31");
                    this_jiami.setMark4("1048576");
                    controlSoftTimeService.add(this_jiami);
                }

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

                List<ControlSoftTime> jiami = controlSoftTimeService.selectCompany("排产",company);
                if(jiami.size() == 0){
                    ControlSoftTime this_jiami = new ControlSoftTime();
                    List<ControlSoftTime2> maxId = controlSoftTimeService.selectId();
                    this_jiami.setId(Integer.parseInt(maxId.get(0).getMaxid())+1);
                    this_jiami.setName(company);
                    this_jiami.setStarttime(sdf2.format(date));
                    this_jiami.setEndtime("2060/1/1");
                    this_jiami.setSoftName("排产");
                    this_jiami.setMark1("");
                    this_jiami.setMark2("2030/12/31");
                    this_jiami.setMark4("1048576");
                    controlSoftTimeService.add(this_jiami);
                }

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

                List<ControlSoftTime> jiami = controlSoftTimeService.selectCompany("教务",company);
                if(jiami.size() == 0){
                    ControlSoftTime this_jiami = new ControlSoftTime();
                    List<ControlSoftTime2> maxId = controlSoftTimeService.selectId();
                    this_jiami.setId(Integer.parseInt(maxId.get(0).getMaxid())+1);
                    this_jiami.setName(company);
                    this_jiami.setStarttime(sdf2.format(date));
                    this_jiami.setEndtime("2060/1/1");
                    this_jiami.setSoftName("教务");
                    this_jiami.setMark1("");
                    this_jiami.setMark2("2030/12/31");
                    this_jiami.setMark4("1048576");
                    controlSoftTimeService.add(this_jiami);
                }

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

                List<ControlSoftTime> jiami = controlSoftTimeService.selectCompany("门店",company);
                if(jiami.size() == 0){
                    ControlSoftTime this_jiami = new ControlSoftTime();
                    List<ControlSoftTime2> maxId = controlSoftTimeService.selectId();
                    this_jiami.setId(Integer.parseInt(maxId.get(0).getMaxid())+1);
                    this_jiami.setName(company);
                    this_jiami.setStarttime(sdf2.format(date));
                    this_jiami.setEndtime("2060/1/1");
                    this_jiami.setSoftName("门店");
                    this_jiami.setMark1("");
                    this_jiami.setMark2("2030/12/31");
                    this_jiami.setMark4("1048576");
                    controlSoftTimeService.add(this_jiami);
                }

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

                List<ControlSoftTime> jiami = controlSoftTimeService.selectCompany("分权",company);
                if(jiami.size() == 0){
                    ControlSoftTime this_jiami = new ControlSoftTime();
                    List<ControlSoftTime2> maxId = controlSoftTimeService.selectId();
                    this_jiami.setId(Integer.parseInt(maxId.get(0).getMaxid())+1);
                    this_jiami.setName(company);
                    this_jiami.setStarttime(sdf2.format(date));
                    this_jiami.setEndtime("2060/1/1");
                    this_jiami.setSoftName("分权");
                    this_jiami.setMark1("");
                    this_jiami.setMark2("2030/12/31");
                    this_jiami.setMark4("1048576");
                    controlSoftTimeService.add(this_jiami);
                }

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
            }else if (system.equals("云合信息采集系统")) {
                CaiJiUser caiJiUser = new CaiJiUser();
                caiJiUser.setName("");
                caiJiUser.setUsername(username);
                caiJiUser.setPassword(password);
                caiJiUser.setCompany(company);
                caiJiUser.setPower("管理员");
                caiJiUserService.add(caiJiUser);

                List<ControlSoftTime> jiami = controlSoftTimeService.selectCompany("采集",company);
                if(jiami.size() == 0){
                    ControlSoftTime this_jiami = new ControlSoftTime();
                    List<ControlSoftTime2> maxId = controlSoftTimeService.selectId();
                    this_jiami.setId(Integer.parseInt(maxId.get(0).getMaxid()) + 1);
                    this_jiami.setName(company);
                    this_jiami.setStarttime(sdf2.format(date));
                    this_jiami.setEndtime("2060/1/1");
                    this_jiami.setSoftName("采集");
                    this_jiami.setMark1("");
                    this_jiami.setMark2("2030/12/31");
                    this_jiami.setMark4("1048576");
                    controlSoftTimeService.add(this_jiami);
                }
            }

            return ResultInfo.success("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("添加失败：{}", e.getMessage());
            return ResultInfo.error("添加失败");
        }
    }


    @RequestMapping("/insertJiami")
    public ResultInfo insertJiami(@RequestBody String menuSettingsJson, HttpSession session){
        ControlSoftTime controlSoftTime = null;
        try{
            controlSoftTime = DecodeUtil.decodeToJson(menuSettingsJson, ControlSoftTime.class);
            controlSoftTime = controlSoftTimeService.add(controlSoftTime);
            if (StringUtils.isNotNull(controlSoftTime)) {
                return ResultInfo.success("提交成功", controlSoftTime);
            } else {
                return ResultInfo.success("提交失败", null);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("添加失败：{}", e.getMessage());
            return ResultInfo.error("添加失败");
        }
    }

    /*
     *修改
     * */
    @RequestMapping(value = "/updateJiami", method = RequestMethod.POST)
    public ResultInfo updateJiami(@RequestBody String menuSettingsJson ,HttpSession session){
        ControlSoftTime controlSoftTime = null;
        try{
            controlSoftTime = DecodeUtil.decodeToJson(menuSettingsJson, ControlSoftTime.class);
            if (controlSoftTimeService.update(controlSoftTime)) {
                return ResultInfo.success("修改成功", controlSoftTime);
            } else {
                return ResultInfo.success("修改失败", controlSoftTime);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("修改失败：{}", e.getMessage());
            return ResultInfo.error("修改失败");
        }
    }

    /*
     *删除
     * */
    @RequestMapping("/deleteJiami")
    public ResultInfo delete(@RequestBody HashMap map, HttpSession session){
        try{
            GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
            List<Integer> idList = GsonUtil.toList(gsonUtil.get("idList"), Integer.class);
            if (controlSoftTimeService.delete(idList)) {
                return ResultInfo.success("删除成功", idList);
            } else {
                return ResultInfo.success("删除失败", idList);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("删除失败：{}", e.getMessage());
            return ResultInfo.error("删除失败");
        }
    }

    //管理员表单查询
    @RequestMapping("/getListJiami")
    public ResultInfo getListJiami(HttpSession session) {
        try {
            List<ControlSoftTime> select_list = null;
            select_list = controlSoftTimeService.getList();
            return ResultInfo.success("获取成功", select_list);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误!");
        }
    }

    //管理员表单查询
    @RequestMapping("/queryListJiami")
    public ResultInfo queryListJiami(String query,HttpSession session) {
        try {
            List<ControlSoftTime> select_list = null;
            select_list = controlSoftTimeService.queryList(query);
            return ResultInfo.success("获取成功", select_list);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误!");
        }
    }


}
