package com.qhit.parking.service.user;

import com.qhit.parking.entity.User;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/27.
 */
public interface UserService {

    List<User> selectAll();

    int updateById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int updateStop(Integer id);

    int updateStart(Integer id);

    User findUserByNameAndPwd(User user);

    List<User> findUserByName(User user);

    User selectByPrimaryKey(Integer id);
}
