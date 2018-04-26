package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.PromotionRemind;

import java.util.List;

@Repository
public interface PromotionRemindMapper {

    /**
     * 根据晋升提醒Id删除晋升提醒
     *
     * @param promotionRemindId
     * @return int
     */

    int deleteByPrimaryKey(Integer promotionRemindId);

    /**
     * 插入晋升提醒信息
     *
     * @param record
     * @return int
     */

    int insert(PromotionRemind record);

    /**
     * 插入晋升提醒部分信息
     *
     * @param record
     * @return int
     */

    int insertSelective(PromotionRemind record);

    /**
     * 根据晋升提醒Id获取晋升提醒信息
     *
     * @param promotionRemindId
     * @return PromotionRecord对象
     */

    PromotionRemind selectByPrimaryKey(Integer promotionRemindId);

    /**
     * 根据晋升提醒Id更新晋升提醒部分信息
     *
     * @param record
     * @return int
     */

    int updateByPrimaryKeySelective(PromotionRemind record);

    /**
     * 根据晋升提醒Id更新晋升提醒信息
     *
     * @param record
     * @return int
     */

    int updateByPrimaryKey(PromotionRemind record);

    /**
     * 获取所有晋升提醒
     *
     * @return 晋升提醒列表
     */

    List<PromotionRemind> selectAllPromotionRemind();
}