package scu.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.StaffInfo;
import scu.edu.cn.service.StaffInfoService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class StaffInfoController {
    @Autowired
    StaffInfoService service;

    /**
     * 获取所有员工信息
     *
     * @return List<StaffInfo>对象
     */
    @ResponseBody
    @RequestMapping("api/staffList")
    public List<StaffInfo> getStaffList(){
        List<StaffInfo> list = service.selectAllStaff();
        return list;
    }

    /**
     *获取员工信息
     *
     * @return 员工页面
     */
    @RequestMapping("staffList")
    public String getStaffInfo(){
        return "staffList.html";

    }

    /**
     *删除员工
     *
     * @param staffId
     * @return error对象
     */
    @RequestMapping(value = "api/deleteStaff",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteStaff(@RequestParam("staffId") Integer staffId){

        Error error = service.deleteStaffById(staffId);
        return error;
    }

    /**
     *新增员工
     *
     * @param info
     * @return error对象
     */
    @RequestMapping(value = "api/addStaff",method = RequestMethod.POST)
    @ResponseBody
    public Error addStaff(@RequestBody StaffInfo info){

        Error error = service.insertStaff(info);
        return error;
    }

    /**
     *编辑员工
     *
     * @param info
     * @return error对象
     */
    @RequestMapping(value = "api/updateStaff",method = RequestMethod.POST)
    @ResponseBody
    public Error updateStaff(@RequestBody StaffInfo info){

        Error error = service.updateStaff(info);
        return error;
    }
}
