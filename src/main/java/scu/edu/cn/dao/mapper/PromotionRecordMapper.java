package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.PromotionRecord;

import java.util.List;

@Repository
public interface PromotionRecordMapper {

    /**
     * 根据晋升记录Id删除晋升记录
     *
     * @param promotionRecordId
     * @return int
     */
    int deleteByPrimaryKey(Integer promotionRecordId);

    /**
     * 插入晋升记录信息
     *
     * @param Record
     * @return int
     */

    int insert(PromotionRecord record);

    /**
     * 插入晋升记录部分信息
     *
     * @param Record
     * @return int
     */

    int insertSelective(PromotionRecord record);

    /**
     * 根据晋升记录Id获取晋升记录信息
     *
     * @param promotionRecordId
     * @return PromotionRecord对象
     */

    PromotionRecord selectByPrimaryKey(Integer promotionRecordId);

    /**
     * 根据晋升记录Id更新晋升记录部分信息
     *
     * @param record
     * @return int
     */

    int updateByPrimaryKeySelective(PromotionRecord record);

    /**
     * 根据晋升记录Id更新晋升记录信息
     *
     * @param record
     * @return int
     */

    int updateByPrimaryKey(PromotionRecord record);

    /**
     * 获取所有晋升记录
     *
     * @return 晋升记录列表
     */

    List<PromotionRecord> selectAllPromotionRecord();
}