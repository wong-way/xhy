package scu.edu.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.StaffInfo;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})

public class StaffInfoServiceTest {

    @Autowired
    StaffInfoService service;

    @Autowired
    StaffInfo staffInfo;

    private Logger logger = LoggerFactory.getLogger(StaffInfoServiceTest.class);

    /**
     * 测试插入员工信息
     *
     * @throws Exception
     */
    @Test
    public void insertStaff() throws Exception {
        staffInfo.setStaffId(4);
        staffInfo.setStaffName("jesse");
        staffInfo.setStaffAge(22);
        staffInfo.setStaffPhoto("photo_path");
        staffInfo.setStaffDutyOn(true);
        staffInfo.setStaffMarriage(true);
        service.insertStaff(staffInfo);
        System.out.println(staffInfo.toString());
    }

    /**
     * 测试更新员工信息
     *
     * @throws Exception
     */
    @Test
    public void updateStaff() throws Exception {
        staffInfo.setStaffId(4);
        staffInfo.setStaffName("Tom");
        staffInfo.setStaffAge(22);
        staffInfo.setStaffPhoto("photo_path");
        staffInfo.setStaffDutyOn(true);
        staffInfo.setStaffMarriage(true);
        service.updateStaff(staffInfo);
        System.out.println(staffInfo.toString());
    }

    /**
     * 测试删除员工信息
     *
     * @throws Exception
     */
    @Test
    public void deleteStaff() throws Exception {
        service.deleteStaffById(3);
    }

    /**
     * 测试获取员工列表
     *
     * @throws Exception
     */
    @Test
    public void selectAllStaff() throws Exception {
        List<StaffInfo> list = service.selectAllStaff();
        logger.info(String.valueOf(list.size()));
    }

    /**
     * 测试获取员工信息
     *
     * @throws Exception
     */
    @Test
    public void selectStaff() throws Exception {
        staffInfo = service.selectStaffById(2);
        logger.info(staffInfo.toString());
    }

}