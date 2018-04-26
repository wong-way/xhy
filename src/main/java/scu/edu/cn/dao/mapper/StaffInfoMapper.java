package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.StaffInfo;

import java.util.List;
@Repository
public interface StaffInfoMapper {

    /**
     * 根据员工Id删除员工
     *
     * @param staffId
     * @return int
     */
    int deleteByPrimaryKey(Integer staffId);

    /**
     * 插入员工信息
     *
     * @param record
     * @return int
     */

    int insert(StaffInfo record);

    /**
     * 插入员工部分信息
     *
     * @param record
     * @return int
     */

    int insertSelective(StaffInfo record);

    /**
     * 根据员工Id获取员工信息
     *
     * @param staffId
     * @return StaffInfo对象
     */

    StaffInfo selectByPrimaryKey(Integer staffId);

    /**
     * 根据员工Id更新员工部分信息
     *
     * @param record
     * @return int
     */

    int updateByPrimaryKeySelective(StaffInfo record);

    /**
     * 根据员工Id更新员工信息
     *
     * @param record
     * @return int
     */

    int updateByPrimaryKey(StaffInfo record);

    /**
     * 获取所有员工
     *
     * @return 员工列表
     */

    List<StaffInfo> selectAllStaff();

    List<StaffInfo> selectOnDutyStaff();
}