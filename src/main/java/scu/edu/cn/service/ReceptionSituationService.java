package scu.edu.cn.service;

import scu.edu.cn.dao.entity.ReceptionSituation;
import scu.edu.cn.dto.Reception;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

/**
 * Author：韩正博
 */
public interface ReceptionSituationService {

    /**
     * 插入一条接待情况信息
     * @param receptionSituation
     * @return
     */
    public Error insertReceptionSituation(ReceptionSituation receptionSituation);

    /**
     * 更新一条接待情况信息
     * @param receptionSituation
     * @return
     */
    public Error updateReceptionSituation(ReceptionSituation receptionSituation);

    /**
     * 通过ID删除一条接待情况信息
     * @param id
     * @return
     */
    public Error deleteReceptionSituationById(int id);

    /**
     * 通过ID查找接待情况信息
     * @param id
     * @return
     */
    public Response<ReceptionSituation> selectReceptionSituationById(int id);

    /**
     * 查找所有接待情况信息
     * @return
     */
    public Response<List<ReceptionSituation>> selectAllReceptionSituation();

    /**
     * 获取前五个接待记录
     * @return 接待列表
     */
    List<Reception> selectTopFive();
}
