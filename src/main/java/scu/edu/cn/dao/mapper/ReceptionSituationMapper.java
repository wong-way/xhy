package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.ReceptionSituation;

import java.util.List;

@Repository
public interface ReceptionSituationMapper {
    /**
     * 通过主键删除一条接待记录
     * @param receptionId
     * @return
     */
    int deleteByPrimaryKey(Integer receptionId);

    /**
     * 插入一条接待记录
     * @param record
     * @return
     */
    int insert(ReceptionSituation record);

    /**
     * 插入一条接待记录（空字段忽略）
     * @param record
     * @return
     */
    int insertSelective(ReceptionSituation record);

    /**
     * 通过主键查找接待记录
     * @param receptionId
     * @return
     */
    ReceptionSituation selectByPrimaryKey(Integer receptionId);

    /**
     * 通过主键更新一条接待记录（空字段忽略）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ReceptionSituation record);

    /**
     * 通过主键更新一条接待记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(ReceptionSituation record);

    /**
     * 查找所有接待记录
     * @return
     */
    List<ReceptionSituation> selectAllReceptionSituation();
}