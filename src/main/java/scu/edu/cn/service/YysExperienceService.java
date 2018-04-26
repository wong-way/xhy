package scu.edu.cn.service;

import scu.edu.cn.dao.entity.YysExperience;
import scu.edu.cn.util.Error;

import java.util.List;

public interface YysExperienceService {
    /**
     * 插入一条育婴师工作经历信息
     *
     * @param yysExperience 育婴师工作经历记录
     * @return Error对象
     */
    Error insertYysExperience(YysExperience yysExperience);

    /**
     * 更新一条育婴师工作经历信息
     *
     * @param yysExperience 育婴师工作经历记录
     * @return Error对象
     */
    Error updateYysExperience(YysExperience yysExperience);

    /**
     * 删除一条育婴师工作经历信息
     *
     * @param yysExperienceId 育婴师工作经历记录的主键
     * @return Error对象
     */
    Error deleteYysExperience(Integer yysExperienceId);


    /**
     * 育婴师工作经历信息列表
     *
     * @return List<YysExperience>育婴师工作经历信息列表
     */
    List<YysExperience> selectAllYysExperience();
}
