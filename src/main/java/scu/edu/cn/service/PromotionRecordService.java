package scu.edu.cn.service;

import scu.edu.cn.dao.entity.PromotionRecord;
import scu.edu.cn.util.Error;

import java.util.List;

public interface PromotionRecordService {

    /**
     * 插入一条晋升记录
     *
     * @param info 晋升记录
     * @return Error对象
     */
    Error insertPromotionRecord(PromotionRecord info);

    /**
     * 更新晋升记录
     *
     * @param info 晋升记录
     * @return Error对象
     */
    Error updatePromotionRecord(PromotionRecord info);

    /**
     * 根据晋升记录Id删除晋升记录
     *
     * @param promotionRecordId 晋升记录Id
     * @return Error对象
     */
    Error deletePromotionRecordById(Integer promotionRecordId);

    /**
     * 获取所有晋升记录列表
     *
     * @return 晋升记录列表
     */
    List<PromotionRecord> selectAllPromotionRecord();

    /**
     * 根据晋升记录Id获取晋升记录
     *
     * @param promotionRecordId 晋升记录Id
     * @return 对应晋升记录Id的晋升记录
     */
    PromotionRecord selectPromotionRecordById(Integer promotionRecordId);
}
