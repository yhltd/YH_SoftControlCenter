package com.example.demo.controller;

import com.example.demo.entity.PushNews;
import com.example.demo.service.PushNewsService;
import com.example.demo.util.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pushnews")
public class PushNewsController {

    @Autowired
    PushNewsService pushNewsService;

    @RequestMapping("/getnews")
    public List<PushNews> getnews() {
            List<PushNews> select_list = pushNewsService.getList();
            return select_list;
    }

    @RequestMapping("/getc")
    public List<PushNews> getC() {
        List<PushNews> select_list = pushNewsService.getC();
        return select_list;
    }

    @RequestMapping("/getlittle")
    public List<PushNews> getLittle(String system,String company) {
        List<PushNews> select_list = pushNewsService.getLittle(system,company);
        return select_list;
    }

    @RequestMapping("/add")
    public int insertPushNews(@RequestBody PushNews pushNews) {
        log.info("Received PushNews: {}", pushNews);
        return pushNewsService.insertPushNews(pushNews);
    }

    @RequestMapping("/update")
    public int updatePushNews(@RequestBody PushNews pushNews) {
        log.info("Updating PushNews: {}", pushNews);
        return pushNewsService.updatePushNews(pushNews);
    }

    @RequestMapping("/getById")
    public PushNews getById(@RequestParam Integer id) {
        return pushNewsService.getById(id);
    }

    @RequestMapping("/delete")
    public int deleteById(@RequestParam Integer id) {
        return pushNewsService.deleteById(id);
    }

    @RequestMapping("/deleteCompany")
    public ResultInfo deleteCompany(String company, String system, HttpSession session) {
        try {
            pushNewsService.deleteCompany(company,system);
            return ResultInfo.success("成功", company);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("失败：{}", e.getMessage());
            log.error("参数：{}", company);
            return ResultInfo.error("失败");
        }
    }

}