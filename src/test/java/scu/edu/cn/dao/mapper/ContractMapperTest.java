package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.Contract;
import scu.edu.cn.dto.DetailContract;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml", "classpath:spring-mvc.xml"})
/**
 * @author 黄伟
 * 测试合同DAO层接口
 */
public class ContractMapperTest {


    @Autowired
    ContractMapper mapper;
    private Logger logger = LoggerFactory.getLogger(RecordMapperTest.class);

    /**
     * 根据主键删除
     * @throws Exception
     */
    @Test
    public void deleteByPrimaryKey() throws Exception {
        mapper.deleteByPrimaryKey(1);

    }

    /**
     * 查询最近数据
     * @throws Exception
     */
    @Test
    public void selectRecent() throws Exception {
        logger.info(mapper.selectRecent().size()+"");
    }
    /**
     * 获取所有数据
     * @throws Exception
     */
    @Test
    public void selectAll() throws Exception {
        logger.info(mapper.selectAll().toString());
    }

    /**
     * 插入数据
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        Date date = new Date();
        Contract contract = new Contract();
        contract.setContractAmount(120.00);
        contract.setContractCollectionTime(new java.sql.Date(date.getTime()));
        contract.setContractId(1);
        contract.setContractServiceContent("一年时间育婴");
        contract.setCustomerId(1);
        mapper.insert(contract);
    }

    /**
     * 插入数据
     * @throws Exception
     */
    @Test
    public void insertSelective() throws Exception {
        Date date = new Date();
        Contract contract = new Contract();
        contract.setContractAmount(120.00);
        contract.setContractCollectionTime(new java.sql.Date(date.getTime()));
        contract.setContractServiceContent("一年时间育婴");
        mapper.insert(contract);
    }

    /**
     * 根据主键选择数据
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.info(mapper.selectByPrimaryKey(1).toString());

    }

    /**
     * 更新数据
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Date date = new Date();
        Contract contract = new Contract();
        contract.setContractId(1);
        contract.setContractAmount(254.0);
        contract.setContractCollectionTime(new java.sql.Date(date.getTime()));
        contract.setContractServiceContent("一年时间育婴");
        mapper.updateByPrimaryKeySelective(contract);
    }

    /**
     * 跟新数据
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
        Date date = new Date();
        Contract contract = new Contract();
        contract.setContractId(1);
        contract.setContractAmount(120.00);
        contract.setContractCollectionTime(new java.sql.Date(date.getTime()));
        contract.setContractServiceContent("一年时间育婴号很后悔红红火火时");
        mapper.updateByPrimaryKeySelective(contract);
    }

    /**
     * 根据主键更新数据
     * @throws Exception
     */
    @Test
    public void updateByPrimaryKey() throws Exception {
        Date date = new Date();
        Contract contract = new Contract();
        contract.setContractAmount(120.00);
        contract.setContractCollectionTime(new java.sql.Date(date.getTime()));
        contract.setContractId(1);
        contract.setContractServiceContent("一年时间育婴啊啊啊啊");
        mapper.updateByPrimaryKeySelective(contract);
    }
    @Test
    public void selectRecentDetail() throws Exception {
        List<DetailContract> list = mapper.getEachDayDetail();
        for (DetailContract item:list) {
            logger.info("数量{}，时间{}",item.getAmount(),item.getDate());
        }
    }


}