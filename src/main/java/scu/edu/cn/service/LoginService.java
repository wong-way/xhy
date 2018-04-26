package scu.edu.cn.service;

import scu.edu.cn.dao.entity.UserInfo;
import scu.edu.cn.util.Error;

/**
 * @author 黄伟
 * 处理登录相关业务逻辑
 */
public interface LoginService {
    /**
     * 用户登录
     *
     * @param info 用户实体
     * @return
     */
    Error login(UserInfo info);

    /**
     * 用户退出
     *
     * @param info 用户实体
     * @return
     */
    int logout(UserInfo info);
}
