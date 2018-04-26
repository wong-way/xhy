package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.YysEvaluation;
import scu.edu.cn.dao.entity.YysEvaluationKey;

import java.util.List;

@Repository
public interface YysEvaluationMapper {
    int deleteByPrimaryKey(YysEvaluationKey key);

    int insert(YysEvaluation record);

    int insertSelective(YysEvaluation record);

    YysEvaluation selectByPrimaryKey(YysEvaluationKey key);

    int updateByPrimaryKeySelective(YysEvaluation record);

    int updateByPrimaryKey(YysEvaluation record);

    List<YysEvaluation> selectAllYysEvaluation();
}