package scu.edu.cn.service;

import scu.edu.cn.dao.entity.YysWorkState;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

/**
 * Author:韩正博
 */
public interface YysWorkStateService {

    /**
     * 插入一条育婴师工作状态记录
     * @param yysWorkState
     * @return
     */
    public Error insertYysWorkState(YysWorkState yysWorkState);

    /**
     * 通过ID查找育婴师工作状态记录
     * @param yysId
     * @return
     */
    public Response<YysWorkState> selectYysWorkStateById(int yysId);

    /**
     * 更新一条育婴师工作状态记录
     * @param yysWorkState
     * @return
     */
    public Error updateYysWorkState(YysWorkState yysWorkState);

    /**
     * 通过ID删除一条育婴师工作状态记录
     * @param yysId
     * @return
     */
    public Error deleteYysWorkStateById(int yysId);

    /**
     * 查找所有的育婴师工作状态记录
     * @return
     */
    public Response<List<YysWorkState>> selectAllYysWorkState();
}
