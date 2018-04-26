package scu.edu.cn.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scu.edu.cn.dao.entity.UserInfo;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml", "classpath:spring-mvc.xml"})
public class UserInfoMapperTest {
    @Autowired
    UserInfoMapper mapper;
    private Logger logger = LoggerFactory.getLogger(UserInfoMapperTest.class);

    @Test
    public void deleteByPrimaryKey() throws Exception {
        mapper.deleteByPrimaryKey(2);
    }

    @Test
    public void deleteByUsername() throws Exception {
        mapper.deleteByUsername("test2");
    }

    @Test
    public void insert() throws Exception {
        UserInfo info = new UserInfo();
        info.setUsername("test");
        info.setPassword("admin");
        info.setToken("123");
        info.setIsAdmin(true);
        info.setCustomerId(1);
        info.setUserId(2);
        mapper.insert(info);
    }

    @Test
    public void insertSelective() throws Exception {
        UserInfo info = new UserInfo();
        info.setUsername("test1");
        info.setPassword("admin");
        info.setCustomerId(1);
        info.setUserId(2);
        mapper.insert(info);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {

        UserInfo info = mapper.selectByPrimaryKey(1);
        logger.info(info.toString());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        UserInfo info = new UserInfo();
        info.setUserId(2);
        info.setUsername("test2");
        info.setPassword("admin2");
        info.setCustomerId(1);
        info.setUserId(2);
        mapper.updateByPrimaryKey(info);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        UserInfo info = new UserInfo();
        info.setUserId(2);
        info.setUsername("test2");
        info.setPassword("admin");
        info.setCustomerId(1);
        info.setUserId(2);
        mapper.updateByPrimaryKey(info);
    }

    @Test
    public void updateByUsernameSelective() throws Exception {
        UserInfo info = new UserInfo();
        info.setUserId(2);
        info.setUsername("test2");
        info.setPassword("admin");
        info.setCustomerId(2);
        info.setUserId(2);
        mapper.updateByUsernameSelective(info);
    }

    @Test
    public void selectByUsername() throws Exception {
        UserInfo info = mapper.selectByUsername("test2");
        logger.info(info.toString());
    }

    @Test
    public void selectAllUser() throws Exception {
        List<UserInfo> list = mapper.selectAllUser();
        logger.info(String.valueOf(list.size()));
    }

}