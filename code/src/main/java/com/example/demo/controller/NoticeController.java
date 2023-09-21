package com.example.demo.controller;

import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;
import com.example.demo.util.DecodeUtil;
import com.example.demo.util.GsonUtil;
import com.example.demo.util.ResultInfo;
import com.example.demo.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("getNotice")
    public List<Notice> getNotice() {
        return noticeService.getNotice();
    }
    @RequestMapping("checkNoticeByname")
    public List<Notice> checkNoticeByname(String uname) {
        return noticeService.checkNoticeByname(uname);
    }
    @RequestMapping("checkNotice")
    public Notice checkNotice(int id) {
        return noticeService.checkNotice(id);
    }
    @RequestMapping("addNotice")
    public int addNotice(String uname,String uid,String address,String uinfo,String lei,String fdate,String detail){
        return noticeService.addNotice( uname,uid, address, uinfo,lei, fdate,detail);
    }
    @RequestMapping("delNotice")
    public int delNotice(int id) {
        return noticeService.delNotice(id);
    }
    @RequestMapping("updateNotice")
    public  int updateNotice(int id,String uname,String uid,String address,String uinfo,String lei,String fdate,String detail) {
        return noticeService.updateNotice(id,uname,uid,address,uinfo,lei,fdate,detail);
    }


    /**
     * 上传文件
     */
    @RequestMapping("/updFile")
    public ResultInfo updFile(@RequestBody HashMap map) {
        GsonUtil gsonUtil = new GsonUtil(GsonUtil.toJson(map));
        try {
            Notice notice = GsonUtil.toEntity(gsonUtil.get("addInfo"), Notice.class);
            if (noticeService.update(notice)) {
                return ResultInfo.success("上传成功", notice);
            } else {
                return ResultInfo.success("上传失败", notice);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传失败：{}", e.getMessage());
            log.error("参数：{}", map);
            return ResultInfo.error("上传失败");
        }
    }

    /**
     * 下载文件
     */
    @RequestMapping("/dowloadFile")
    public ResultInfo dowloadFile(int id) {
        try {
            List<Notice> noticeList = noticeService.getNoticeById(id);
            return ResultInfo.success("获取成功", noticeList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传失败：{}", e.getMessage());
            log.error("参数：{}", id);
            return ResultInfo.error("上传失败");
        }
    }



}
