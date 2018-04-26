package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.YysVisit;
import scu.edu.cn.dao.entity.YysVisitKey;

import java.util.List;

@Repository
public interface YysVisitMapper {
    int deleteByPrimaryKey(YysVisitKey key);

    int insert(YysVisit record);

    int insertSelective(YysVisit record);

    YysVisit selectByPrimaryKey(YysVisitKey key);

    int updateByPrimaryKeySelective(YysVisit record);

    int updateByPrimaryKeyWithBLOBs(YysVisit record);

    List<YysVisit> selectAllYysVisit();
}