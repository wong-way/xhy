package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.YysExperience;

import java.util.List;

@Repository
public interface YysExperienceMapper {
    int deleteByPrimaryKey(Integer yysExperienceId);

    int insert(YysExperience record);

    int insertSelective(YysExperience record);

    YysExperience selectByPrimaryKey(Integer yysExperienceId);

    int updateByPrimaryKeySelective(YysExperience record);

    int updateByPrimaryKeyWithBLOBs(YysExperience record);

    int updateByPrimaryKey(YysExperience record);

    List<YysExperience> selectAllYysExperience();
}