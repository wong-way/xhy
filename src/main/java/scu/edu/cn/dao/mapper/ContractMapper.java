package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Repository;
import scu.edu.cn.dao.entity.Contract;
import scu.edu.cn.dto.DetailContract;

import java.util.List;

@Repository
public interface ContractMapper {
    int deleteByPrimaryKey(Integer contractId);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer contractId);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKeyWithBLOBs(Contract record);

    int updateByPrimaryKey(Contract record);

    List<Contract> selectAll();

    List<Contract> selectRecent();

    List<DetailContract> getEachDayDetail();
}