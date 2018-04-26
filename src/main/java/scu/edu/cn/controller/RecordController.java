package scu.edu.cn.controller;

import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.Record;
import scu.edu.cn.service.RecordService;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import javax.servlet.http.HttpSession;

import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

import java.util.List;

/**
 * @author 黄伟
 * 处理跟进记录相关的操作
 */
@Controller
@RequestMapping("/")
public class RecordController {
    @Autowired
    RecordService service;

    /**
     * 获取跟进记录相关的列表
     *
     * @return 返回数据列表
     */
    @ResponseBody
    @RequestMapping("api/recordList")
    public List<Record> getList() {
        Response response = service.getAllRecord();
        if (response.getError().getCode() == OPERATION_SUCCESS) {
            return (List<Record>) response.getData();
        }
        return null;
    }

    /**
     * 获取列表界面
     *
     * @return 列表界面
     */
    @RequestMapping("recordList")
    public String RecordPage() {
        return "recordList.html";
    }

    /**
     * 获取编辑记录页面
     *
     * @return 编辑页面
     */
    @RequestMapping("editRecord")
    public String editRecordPage() {
        return "editRecord.html";
    }

    /**
     * 删除跟进记录的API接口
     *
     * @param recordId 欲删除的记录编号
     * @return Error对象包含错误信息和错误码
     */
    @ResponseBody
    @RequestMapping("api/deleteRecord")
    public Error deleteRecord(@RequestParam("recordId") Integer recordId) {
        Error error = service.deleteRecord(recordId);
        return error;
    }

    /**
     * 批量删除记录的API接口
     *
     * @param record 记录数组
     * @return Error对象包含错误信息和错误码
     */
    @ResponseBody
    @RequestMapping("api/deleteRecords")
    public Error deleteRecords(@RequestBody Record[] record) {
        Error error = service.deleteRecords(record);
        return error;
    }

    /**
     * 编辑跟进记录的API接口
     *
     * @param info
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("api/editRecord")
    public Error addRecord(@RequestBody String info, HttpSession session) {
        Integer recordId = (Integer) session.getAttribute("recordId");

        Record record;


        Gson gson =new Gson();
        Error error;
        record = gson.fromJson(info, Record.class);
        System.out.println(info);
        if (recordId == null)
            error = service.insertRecord(record);
        else {
            record.setRecordId(recordId);
            error = service.updateRecord(record);
        }
        System.out.println(error.getMessage());

        return error;
    }

    /**
     * 获取一条记录
     *
     * @param session 会话信息
     * @return 记录对象
     */
    @ResponseBody
    @RequestMapping("api/getRecord")
    public Record getRecord(HttpSession session) {
        Integer recordId = (Integer) session.getAttribute("recordId");
        Record record;
        Error error;
        if (recordId == null)
            return null;
        else {
            record = service.getRecordById(recordId);
        }

        return record;
    }

    /**
     * 获取更新记录的页面
     *
     * @param session  会话信息
     * @param recordId 记录编号
     * @return 编辑页面
     */
    @RequestMapping(value = "updateRecord/{id}")
    public String updateRecordPage(HttpSession session, @PathVariable("id") int recordId) {
        System.out.println(recordId);
        session.setAttribute("recordId", recordId);
        return "editRecord.html";
    }
}
