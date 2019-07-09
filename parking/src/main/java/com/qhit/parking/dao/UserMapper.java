package com.qhit.parking.dao;

import com.qhit.parking.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    int updateById(Integer id);

    int updateStop(Integer id);

    int updateStart(Integer id);

    List<User> findUserByName(User user);

    User findUserByNameAndPwd(User user);


}