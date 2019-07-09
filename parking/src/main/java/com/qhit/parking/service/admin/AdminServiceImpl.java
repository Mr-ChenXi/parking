package com.qhit.parking.service.admin;

import com.qhit.parking.dao.AdminMapper;
import com.qhit.parking.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/26.
 */
@Service
public class AdminServiceImpl implements  AdminService{

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin getUserByNameAndPwd(Admin admin) {
        return adminMapper.getUserByNameAndPwd(admin);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public int updateStop(Integer id) {
        return adminMapper.updateStop(id);
    }

    @Override
    public int updateStart(Integer id) {
        return adminMapper.updateStart(id);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateNameAndPwd(Admin record) {
        return adminMapper.updateNameAndPwd(record);
    }

    @Override
    public List<Admin> findAdminByName(Admin admin) {
        return adminMapper.findAdminByName(admin);
    }
}
