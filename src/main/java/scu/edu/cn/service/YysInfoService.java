package scu.edu.cn.service;

import scu.edu.cn.dao.entity.YysInfo;
import scu.edu.cn.util.Error;

import java.util.List;

public interface YysInfoService {
    /**
     * 插入一条育婴师信息
     *
     * @param yysInfo 育婴师信息记录
     * @return Error对象
     */
    Error insertYysInfo(YysInfo yysInfo);

    /**
     * 更新一条育婴师信息
     *
     * @param yysInfo 育婴师信息记录
     * @return Error对象
     */
    Error updateYysInfo(YysInfo yysInfo);

    /**
     * 删除一条育婴师信息
     *
     * @param yysId 育婴师信息记录的主键
     * @return Error对象
     */
    Error deleteYysInfo(Integer yysId);


    /**
     * 育婴师信息列表
     *
     * @return List<YysInfo>育婴师信息列表
     */
    List<YysInfo> selectAllYysInfo();


}
