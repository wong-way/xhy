package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.StaffInfo;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml","classpath:spring-mvc.xml"})

public class StaffInfoMapperTest {

    @Autowired
    StaffInfoMapper staffInfoMapper;

    @Autowired
    StaffInfo staffInfo;

    /**
     * 测试删除员工根据员工Id
     *
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
        assertEquals(0,staffInfoMapper.deleteByPrimaryKey(1));
    }

    /**
     * 测试插入员工信息
     *
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        staffInfo.setStaffId(1);
        staffInfo.setStaffAge(22);
        staffInfo.setStaffCertificates("CTE-4");
        staffInfo.setStaffConstellation("Capricornus");
        staffInfo.setStaffDutyOn(true);
        staffInfo.setStaffEducation("SCU");
        staffInfo.setStaffLevel("chief");
        staffInfo.setStaffMarriage(false);
        staffInfo.setStaffName("jesse");
        staffInfo.setStaffPhoto("photo_path");
        staffInfo.setStaffPosition("boss");
        staffInfoMapper.insert(staffInfo);
        System.out.println(staffInfo.toString());
    }

    /**
     * 测试插入部分员工信息
     *
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        staffInfo.setStaffId(3);
        staffInfo.setStaffName("jesse");
        staffInfo.setStaffAge(22);
        staffInfoMapper.insertSelective(staffInfo);
        System.out.println(staffInfo.toString());
    }

    /**
     * 测试获取员工信息根据员工Id
     *
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
       staffInfo = staffInfoMapper.selectByPrimaryKey(2);
        System.out.println(staffInfo.getStaffId());
        System.out.println(staffInfo.getStaffName());
    }

    /**
     * 测试更新员工部分信息
     *
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        staffInfo.setStaffId(3);
        staffInfo.setStaffAge(22);
        staffInfo.setStaffCertificates("CTE-4");
        staffInfo.setStaffConstellation("Capricornus");
        staffInfo.setStaffDutyOn(true);
        staffInfo.setStaffEducation("SCU");
        staffInfo.setStaffLevel("chief");
        staffInfo.setStaffMarriage(false);
        staffInfo.setStaffName("jesse");
        assertEquals(1,staffInfoMapper.updateByPrimaryKeySelective(staffInfo));
    }

    /**
     * 测试更新员工信息
     *
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        staffInfo = staffInfoMapper.selectByPrimaryKey(2);
        staffInfo.setStaffName("celine");
        assertEquals(1,staffInfoMapper.updateByPrimaryKey(staffInfo));
    }

}