package com.hz.ssm.mapper;

import com.hz.ssm.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询  与UserMapper关联 在UserMapper中写sql语句
     * @return
     */
    List<User> queryAllUser();
}