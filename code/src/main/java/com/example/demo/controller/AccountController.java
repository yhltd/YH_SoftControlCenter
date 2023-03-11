package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.util.GsonUtil;
import com.example.demo.util.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author hui
 * @date 2022/12/6 14:32
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private ControlSoftTimeService controlSoftTimeService;
    @Autowired
    private YhJinxiaocunUserService yhJinxiaocunUserService;
    @Autowired
    private FinanceUserService financeUserService;
    @Autowired
    private GongziUserService gongziUserService;
    @Autowired
    private SchedulingUserService schedulingUserService;
    @Autowired
    private JiaowuUserService jiaowuUserService;
    @Autowired
    private KaUserService kaUserService;
    @Autowired
    private FenquanUserService fenquanUserService;

    /**
     * 刷新
     *
     * @return ResultInfo
     */
    @RequestMapping("/getList")
    public ResultInfo getList(String system, String company, String username, HttpSession session) {
        List<Account> list = new ArrayList<>();
        try {
            switch (system) {
                case "": {
                    List<FenquanUser> fenquanList = fenquanUserService.getList(company, username);
                    List<FinanceUser> financeList = financeUserService.getList(company, username);
                    List<GongziUser> gongziList = gongziUserService.getList(company, username);
                    List<JiaowuUser> jiaowuList = jiaowuUserService.getList(company, username);
                    List<KaUser> kaList = kaUserService.getList(company, username);
                    List<SchedulingUser> schedulingList = schedulingUserService.getList(company, username);
                    List<YhJinxiaocunUser> jxcList = yhJinxiaocunUserService.getList(company, username);

                    if (fenquanList != null) {
                        for (FenquanUser fenquanUser : fenquanList) {
                            Account account = new Account();
                            account.setId(fenquanUser.getId());
                            account.setSystem("云合分权编辑系统");
                            account.setCompany(fenquanUser.getB());
                            account.setUsername(fenquanUser.getD());
                            account.setPassword(fenquanUser.getE());
                            account.setState(fenquanUser.getZhuangtai());
                            list.add(account);
                        }
                    }

                    if (financeList != null) {
                        for (FinanceUser financeUser : financeList) {
                            Account account = new Account();
                            account.setId(financeUser.getId());
                            account.setSystem("云合未来财务系统");
                            account.setCompany(financeUser.getCompany());
                            account.setUsername(financeUser.getName());
                            account.setPassword(financeUser.getPwd());
                            account.setState("");
                            list.add(account);
                        }
                    }

                    if (gongziList != null) {
                        for (GongziUser gongziUser : gongziList) {
                            Account account = new Account();
                            account.setId(gongziUser.getId());
                            account.setSystem("云合人事管理系统");
                            account.setCompany(gongziUser.getL());
                            account.setUsername(gongziUser.getI());
                            account.setPassword(gongziUser.getJ());
                            account.setState("");
                            list.add(account);
                        }
                    }

                    if (jiaowuList != null) {
                        for (JiaowuUser jiaowuUser : jiaowuList) {
                            Account account = new Account();
                            account.setId(jiaowuUser.getId());
                            account.setSystem("云合未来教务系统");
                            account.setCompany(jiaowuUser.getCompany());
                            account.setUsername(jiaowuUser.getUsername());
                            account.setPassword(jiaowuUser.getPassword());
                            account.setState(jiaowuUser.getState());
                            list.add(account);
                        }
                    }

                    if (kaList != null) {
                        for (KaUser kaUser : kaList) {
                            Account account = new Account();
                            account.setId(kaUser.getId());
                            account.setSystem("云合卡管理系统");
                            account.setCompany(kaUser.getCompany());
                            account.setUsername(kaUser.getAccount());
                            account.setPassword(kaUser.getPassword());
                            account.setState("");
                            list.add(account);
                        }
                    }

                    if (schedulingList != null) {
                        for (SchedulingUser schedulingUser : schedulingList) {
                            Account account = new Account();
                            account.setId(schedulingUser.getId());
                            account.setSystem("云合排产管理系统");
                            account.setCompany(schedulingUser.getCompany());
                            account.setUsername(schedulingUser.getUserCode());
                            account.setPassword(schedulingUser.getPassword());
                            account.setState(schedulingUser.getState());
                            list.add(account);
                        }
                    }

                    if (jxcList != null) {
                        for (YhJinxiaocunUser yhJinxiaocunUser : jxcList) {
                            Account account = new Account();
                            account.setId(0);
                            account.setSystem("云合未来进销存系统");
                            account.setCompany(yhJinxiaocunUser.getGongsi());
                            account.setUsername(yhJinxiaocunUser.getName());
                            account.setPassword(yhJinxiaocunUser.getPassword());
                            account.setState(yhJinxiaocunUser.getBtype());
                            list.add(account);
                        }
                    }

                    break;
                }
                case "云合分权编辑系统": {
                    List<FenquanUser> fenquanList = fenquanUserService.getList(company, username);
                    if (fenquanList != null) {
                        for (FenquanUser fenquanUser : fenquanList) {
                            Account account = new Account();
                            account.setId(fenquanUser.getId());
                            account.setSystem("云合分权编辑系统");
                            account.setCompany(fenquanUser.getB());
                            account.setUsername(fenquanUser.getD());
                            account.setPassword(fenquanUser.getE());
                            account.setState(fenquanUser.getZhuangtai());
                            list.add(account);
                        }
                    }
                    break;
                }
                case "云合未来财务系统": {
                    List<FinanceUser> financeList = financeUserService.getList(company, username);
                    if (financeList != null) {
                        for (FinanceUser financeUser : financeList) {
                            Account account = new Account();
                            account.setId(financeUser.getId());
                            account.setSystem("云合未来财务系统");
                            account.setCompany(financeUser.getCompany());
                            account.setUsername(financeUser.getName());
                            account.setPassword(financeUser.getPwd());
                            account.setState("");
                            list.add(account);
                        }
                    }
                    break;
                }
                case "云合人事管理系统": {
                    List<GongziUser> gongziList = gongziUserService.getList(company, username);
                    if (gongziList != null) {
                        for (GongziUser gongziUser : gongziList) {
                            Account account = new Account();
                            account.setId(gongziUser.getId());
                            account.setSystem("云合人事管理系统");
                            account.setCompany(gongziUser.getB());
                            account.setUsername(gongziUser.getI());
                            account.setPassword(gongziUser.getJ());
                            account.setState("");
                            list.add(account);
                        }
                    }
                    break;
                }
                case "云合未来教务系统": {
                    List<JiaowuUser> jiaowuList = jiaowuUserService.getList(company, username);
                    if (jiaowuList != null) {
                        for (JiaowuUser jiaowuUser : jiaowuList) {
                            Account account = new Account();
                            account.setId(jiaowuUser.getId());
                            account.setSystem("云合未来教务系统");
                            account.setCompany(jiaowuUser.getCompany());
                            account.setUsername(jiaowuUser.getUsername());
                            account.setPassword(jiaowuUser.getPassword());
                            account.setState(jiaowuUser.getState());
                            list.add(account);
                        }
                    }
                    break;
                }
                case "云合卡管理系统": {
                    List<KaUser> kaList = kaUserService.getList(company, username);
                    if (kaList != null) {
                        for (KaUser kaUser : kaList) {
                            Account account = new Account();
                            account.setId(kaUser.getId());
                            account.setSystem("云合卡管理系统");
                            account.setCompany(kaUser.getCompany());
                            account.setUsername(kaUser.getAccount());
                            account.setPassword(kaUser.getPassword());
                            account.setState("");
                            list.add(account);
                        }
                    }
                    break;
                }
                case "云合排产管理系统": {
                    List<SchedulingUser> schedulingList = schedulingUserService.getList(company, username);
                    if (schedulingList != null) {
                        for (SchedulingUser schedulingUser : schedulingList) {
                            Account account = new Account();
                            account.setId(schedulingUser.getId());
                            account.setSystem("云合排产管理系统");
                            account.setCompany(schedulingUser.getCompany());
                            account.setUsername(schedulingUser.getUserCode());
                            account.setPassword(schedulingUser.getPassword());
                            account.setState(schedulingUser.getState());
                            list.add(account);
                        }
                    }
                    break;
                }
                case "云合未来进销存系统": {
                    List<YhJinxiaocunUser> jxcList = yhJinxiaocunUserService.getList(company, username);
                    if (jxcList != null) {
                        for (YhJinxiaocunUser yhJinxiaocunUser : jxcList) {
                            Account account = new Account();
                            account.setId(0);
                            account.setSystem("云合未来进销存系统");
                            account.setCompany(yhJinxiaocunUser.getGongsi());
                            account.setUsername(yhJinxiaocunUser.getName());
                            account.setPassword(yhJinxiaocunUser.getPassword());
                            account.setState(yhJinxiaocunUser.getBtype());
                            list.add(account);
                        }
                    }
                    break;
                }
            }

            return ResultInfo.success("获取成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取失败：{}", e.getMessage());
            return ResultInfo.error("错误！");
        }
    }


    /**
     * 禁用
     *
     * @return ResultInfo
     */
    @RequestMapping("/jinyong")
    public ResultInfo jinyong(@RequestBody HashMap map, HttpSession session) {
        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
        List<Integer> idList = GsonUtil.toList(gsonUtil.get("idList"), Integer.class);
        List<String> systemList = GsonUtil.toList(gsonUtil.get("systemList"), String.class);
        try {

            for (int i = 0; i < idList.size(); i++) {
                switch (systemList.get(i)) {
                    case "云合分权编辑系统":
                        fenquanUserService.jinyong(idList.get(i));
                        break;
                    case "云合排产管理系统":
                        schedulingUserService.jinyong(idList.get(i));
                        break;
                    case "云合未来教务系统":
                        jiaowuUserService.jinyong(idList.get(i));
                        break;
                }
            }
            return ResultInfo.success("成功", idList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("失败：{}", e.getMessage());
            log.error("参数：{}", idList);
            return ResultInfo.error("失败");
        }
    }

    /**
     * 解禁
     *
     * @return ResultInfo
     */
    @RequestMapping("/jiejin")
    public ResultInfo jiejin(@RequestBody HashMap map, HttpSession session) {
        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
        List<Integer> idList = GsonUtil.toList(gsonUtil.get("idList"), Integer.class);
        List<String> systemList = GsonUtil.toList(gsonUtil.get("systemList"), String.class);
        try {

            for (int i = 0; i < idList.size(); i++) {
                switch (systemList.get(i)) {
                    case "云合分权编辑系统":
                        fenquanUserService.jiejin(idList.get(i));
                        break;
                    case "云合排产管理系统":
                        schedulingUserService.jiejin(idList.get(i));
                        break;
                    case "云合未来教务系统":
                        jiaowuUserService.jiejin(idList.get(i));
                        break;
                }
            }
            return ResultInfo.success("成功", idList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("失败：{}", e.getMessage());
            log.error("参数：{}", idList);
            return ResultInfo.error("失败");
        }
    }
}
