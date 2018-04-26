package scu.edu.cn.service;

import scu.edu.cn.dao.entity.YysEvaluation;
import scu.edu.cn.dao.entity.YysEvaluationKey;
import scu.edu.cn.util.Error;

import java.util.List;

public interface YysEvaluationService {
    /**
     * 插入一条结算与评价记录
     *
     * @param yysEvaluation 结算与评价记录
     * @return Error对象
     */
    Error insertYysEvaluation(YysEvaluation yysEvaluation);

    /**
     * 更新一条结算与评价记录
     *
     * @param yysEvaluation 结算与评价记录
     * @return Error对象
     */
    Error updateYysEvaluation(YysEvaluation yysEvaluation);

    /**
     * 删除一条结算与评价记录
     *
     * @param yysEvaluationKey 结算与评价记录的主键
     * @return Error对象
     */
    Error deleteYysEvaluation(YysEvaluationKey yysEvaluationKey);

    /**
     * 列出结算与评价记录
     *
     * @return 结算与评价记录列表
     */
    public List<YysEvaluation> selectAllYysEvaluation();
}
