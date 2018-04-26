package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.YysWorkState;

import java.util.List;

@Repository
public interface YysWorkStateMapper {
    /**
     * 通过主键删除一条育婴师工作状态记录
     * @param yysId
     * @return
     */
    int deleteByPrimaryKey(Integer yysId);

    /**
     * 插入一条育婴师工作状态记录
     * @param record
     * @return
     */
    int insert(YysWorkState record);

    /**
     * 插入一条育婴师工作状态记录（空字段忽略）
     * @param record
     * @return
     */
    int insertSelective(YysWorkState record);

    /**
     * 通过主键查找一条育婴师工作状态记录
     * @param yysId
     * @return
     */
    YysWorkState selectByPrimaryKey(Integer yysId);

    /**
     * 通过主键更新一条育婴师工作状态记录（空字段忽略）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(YysWorkState record);

    /**
     * 通过主键更新一条育婴师工作状态记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(YysWorkState record);

    /**
     * 查找所有育婴师工作状态记录
     * @return
     */
    List<YysWorkState> selectAllYysWorkState();
}