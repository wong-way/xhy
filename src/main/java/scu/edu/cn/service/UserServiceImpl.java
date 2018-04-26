package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.UserInfo;
import scu.edu.cn.dao.mapper.UserInfoMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.DUPLICATE_USERNAME;
import static scu.edu.cn.util.Constant.OPERATION_ERROR;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoMapper mapper ;
    @Override
    public Error insertUser(UserInfo info) {
        Error error ;
        UserInfo user;
        try{
            user=mapper.selectByUsername(info.getUsername());
            if(user != null)
            {
                error= new Error(DUPLICATE_USERNAME,"用户名已存在");
            }else{
                mapper.insertSelective(info);
                error= new Error(OPERATION_SUCCESS,"增加成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"增加失败");
        }
        return error;
    }

    @Override
    public Error updateUser(UserInfo info) {
        Error error ;
        try{
            mapper.updateByUsernameSelective(info);
            error= new Error(OPERATION_SUCCESS,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"更新失败");
        }
        return error;


    }

    @Override
    public Error deleteUser(String username) {
        Error error ;
        try{
            mapper.deleteByUsername(username);
            error= new Error(OPERATION_SUCCESS,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"删除失败");
        }
        return error;
    }

    @Override
    public Error register(UserInfo info) {
        Error error ;
        UserInfo user;
        try{
            user=mapper.selectByUsername(info.getUsername());
            if(user != null)
            {
                error= new Error(DUPLICATE_USERNAME,"用户名已存在");
            }else{
                mapper.insertSelective(info);
                error= new Error(OPERATION_SUCCESS,"注册成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"注册失败");
        }
        return error;
    }

    @Override
    public Error deleteUsers(UserInfo[] list) {
        Error error ;
        try{
            for(int i=0;i<list.length;i++)
            {
                mapper.deleteByUsername(list[i].getUsername());
            }
            error= new Error(OPERATION_SUCCESS,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"删除失败");
        }
        return error;
    }

    @Override
    public List<UserInfo> selectAllUser() {
        List<UserInfo> list = mapper.selectAllUser();
        Response<List<UserInfo>> response = new Response<List<UserInfo>>();
        response.setData(list);
        response.setError(new Error(OPERATION_SUCCESS,"查找成功"));
        return mapper.selectAllUser();
    }

    @Override
    public UserInfo selectUserByName(String username) {
        return mapper.selectByUsername(username);
    }
}
