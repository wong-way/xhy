package scu.edu.cn.service;

import scu.edu.cn.dao.entity.StaffInfo;
import scu.edu.cn.util.Error;

import java.util.List;

public interface StaffInfoService {

    /**
     * 插入一条员工信息
     *
     * @param info 员工信息
     * @return Error对象
     */
    Error insertStaff(StaffInfo info);

    /**
     * 更新员工信息
     *
     * @param info 员工信息
     * @return Error对象
     */
    Error updateStaff(StaffInfo info);

    /**
     * 根据员工Id删除用户
     *
     * @param staffId 员工Id
     * @return Error对象
     */
    Error deleteStaffById(Integer staffId);

    /**
     * 获取所有员工信息列表
     *
     * @return 员工信息列表
     */
    List<StaffInfo> selectAllStaff();

    /**
     * 根据员工Id获取用户
     *
     * @param staffId 员工Id
     * @return 对应员工Id的员工对象
     */
    StaffInfo selectStaffById(Integer staffId);

    /**
     * 选取上岗职工
     * @return
     */
    List<StaffInfo> selectOnDutyStaff();

}
