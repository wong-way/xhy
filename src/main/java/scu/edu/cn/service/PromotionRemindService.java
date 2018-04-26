package scu.edu.cn.service;

import scu.edu.cn.dao.entity.PromotionRemind;
import scu.edu.cn.util.Error;

import java.util.List;

public interface PromotionRemindService {

    /**
     * 插入一条晋升提醒
     *
     * @param info 晋升提醒
     * @return Error对象
     */
    Error insertPromotionRemind(PromotionRemind info);

    /**
     * 更新晋升提醒
     *
     * @param info 晋升提醒
     * @return Error对象
     */
    Error updatePromotionRemind(PromotionRemind info);

    /**
     * 根据晋升提醒Id删除晋升提醒
     *
     * @param promotionRemindId 晋升提醒Id
     * @return Error对象
     */
    Error deletePromotionRemindById(Integer promotionRemindId);

    /**
     * 获取所有晋升提醒列表
     *
     * @return 晋升提醒列表
     */
    List<PromotionRemind> selectAllPromotionRemind();

    /**
     * 根据晋升提醒Id获取晋升提醒
     *
     * @param promotionRemindId 晋升提醒Id
     * @return 对应晋升提醒Id的晋升提醒
     */
    PromotionRemind selectPromotionRemindById(Integer promotionRemindId);
}
