package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.YysInfo;

import java.util.List;

@Repository
public interface YysInfoMapper {
    int deleteByPrimaryKey(Integer yysId);

    int insert(YysInfo record);

    int insertSelective(YysInfo record);

    YysInfo selectByPrimaryKey(Integer yysId);

    int updateByPrimaryKeySelective(YysInfo record);

    int updateByPrimaryKey(YysInfo record);

    int updateByYysNameSelective(YysInfo record);

    List<YysInfo> selectAllYysInfo();

}