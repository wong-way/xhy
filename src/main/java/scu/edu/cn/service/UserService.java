package scu.edu.cn.service;

import scu.edu.cn.dao.entity.UserInfo;
import scu.edu.cn.util.Error;

import java.util.List;

/**
 * @author 黄伟
 * 处理用户相关业务逻辑
 */
public interface UserService {
    /**
     * 插入一条用户信息
     *
     * @param info 用户信息
     * @return Error对象
     */
    Error insertUser(UserInfo info);

    /**
     * 根据用户名更新用户信息
     *
     * @param info 用户信息
     * @return Error对象
     */
    Error updateUser(UserInfo info);

    /**
     * 根据用户名删除用户
     *
     * @param username 用户名
     * @return Error对象
     */
    Error deleteUser(String username);

    /**
     * 获取所有用户信息列表
     *
     * @return 用户信息列表
     */
    List<UserInfo> selectAllUser();

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 对应用户名的用户对象
     */
    UserInfo selectUserByName(String username);

    /**
     * 注册用户
     *
     * @param info 用户信息
     * @return Error对象
     */
    Error register(UserInfo info);

    /**
     * 批量删除用户数据
     * @param list 用户列表
     * @return
     */
    Error deleteUsers(UserInfo[] list);

}
