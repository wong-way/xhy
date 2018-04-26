package scu.edu.cn.dao.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.UserEntity;



/**
 * Created by Hway on 2017/7/20.
 */
@Repository
public interface UserMapper {

    UserEntity get(int id);

}
