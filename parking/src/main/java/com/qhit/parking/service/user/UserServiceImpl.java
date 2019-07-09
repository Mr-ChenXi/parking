package com.qhit.parking.service.user;

import com.qhit.parking.dao.UserMapper;
import com.qhit.parking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateById(Integer id) {
        return userMapper.updateById(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateStop(Integer id) {
        return userMapper.updateStop(id);
    }

    @Override
    public int updateStart(Integer id) {
        return userMapper.updateStart(id);
    }

    @Override
    public User findUserByNameAndPwd(User user) {
        return userMapper.findUserByNameAndPwd(user);
    }

    @Override
    public List<User> findUserByName(User user) {
        return userMapper.findUserByName(user);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return  userMapper.selectByPrimaryKey(id);
    }
}
