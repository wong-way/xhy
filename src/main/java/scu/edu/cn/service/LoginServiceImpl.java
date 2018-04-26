package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.UserInfo;
import scu.edu.cn.dao.mapper.UserInfoMapper;
import scu.edu.cn.util.Error;

import static scu.edu.cn.util.Constant.*;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserInfoMapper mapper;
    @Override
    public Error login(UserInfo info){
        Error error;
        UserInfo user = mapper.selectByUsername(info.getUsername());
        if(user == null){
            error = new Error(NOT_EXIST, "用户不存在");
        }
        else{
            try{
                if(user.getIsAdmin()==false)
                {
                    error = new Error(NOT_EXIST, "非管理员帐号");
                }else{
                    if(user.getPassword().equals(info.getPassword())) {
                        mapper.updateByUsernameSelective(info);
                        error=new Error(LOGIN_SUCCESS, "登录成功");
                    }else{
                        error = new Error(WRONG_PASSWORD, "账号或者密码错误");
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
                error = new Error(LOGIN_ERROR, "登录失败请稍后重试");
            }
        }
        return error;
    }

    @Override
    public int logout(UserInfo info) {
        mapper.updateByUsernameSelective(info);
        return 0;
    }

}
