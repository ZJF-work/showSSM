package com.hz.ssm.service;

import com.hz.ssm.model.User;
import com.hz.ssm.req.UserAddReq;
import com.hz.ssm.req.UserDeleteReq;
import com.hz.ssm.req.UserUpdateReq;

import java.util.List;

/**
 * 用户操作接口
 */
public interface UserService {

    /**
     * 查询所有用户
     */
    public List<User> queryAllUser();

    /**
     * 添加用户
     */

    public Boolean addUser(UserAddReq userAddReq);

    /**
     * 编辑用户
     */
    public Boolean updateUser(UserUpdateReq userUpdateReq);

//    /**
//     * 删除用户
//     */
//    public Boolean deleteUser(int id);

    /**
     *删除用户
     */
    public Boolean deleteUser(UserDeleteReq userDeleteReq);
}
