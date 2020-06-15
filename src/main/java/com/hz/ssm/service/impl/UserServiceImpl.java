package com.hz.ssm.service.impl;

import com.hz.ssm.mapper.UserMapper;
import com.hz.ssm.model.User;
import com.hz.ssm.req.UserAddReq;
import com.hz.ssm.req.UserDeleteReq;
import com.hz.ssm.req.UserUpdateReq;
import com.hz.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户接口实现类
 */

@Service
public class UserServiceImpl implements UserService {
    private static final Logger loger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询接口实现
     * @return
     */
    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    /**
     * 添加接口实现
     * @param userAddReq
     * @return
     */
    @Override
    public Boolean addUser(UserAddReq userAddReq) {
        User user = new User();
        user.setUserName(userAddReq.getAccount());
        user.setPassword(userAddReq.getPassword());
        user.setTrueName(userAddReq.getName());
        user.setMsg(userAddReq.getInfo());

        int rlt = userMapper.insert(user);
        if (rlt > 0) {
            return true;
        } else {
            return  false;
        }
    }


    /**
     * 编辑接口实现
     */
    @Override
    public Boolean updateUser(UserUpdateReq userUpdateReq) {
        User user = new User();
        user.setId(userUpdateReq.getId());
        user.setUserName(userUpdateReq.getAccount());
        user.setPassword(userUpdateReq.getPassword());
        user.setTrueName(userUpdateReq.getName());
        user.setMsg(userUpdateReq.getInfo());

        int rlt = userMapper.updateByPrimaryKey(user);
        if (rlt > 0) {
            return true;
        } else {
            return  false;
        }
    }

    /**
     * 删除接口实现
     */
//    @Override
//    public Boolean deleteUser( int id) {
//
//        int rlt = userMapper.deleteByPrimaryKey(id);
//        if (rlt > 0) {
//            return true;
//        } else {
//            return  false;
//        }
//    }

    /**
     * 删除接口实现
     */
    @Override
    public Boolean deleteUser(UserDeleteReq userDeleteReq) {

        int rlt = userMapper.deleteByPrimaryKey(userDeleteReq.getId());
        if (rlt > 0) {
            return true;
        } else {
            return  false;
        }
    }
}
