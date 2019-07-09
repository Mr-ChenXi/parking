package com.qhit.parking.service.admin;

import com.qhit.parking.entity.Admin;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/26.
 */
public interface AdminService {
    Admin getUserByNameAndPwd(Admin admin);

    List<Admin> selectAll();

    int updateStop(Integer id);

    int updateStart(Integer id);

    int insert(Admin record);

    int deleteByPrimaryKey(Integer id);

    Admin selectByPrimaryKey(Integer id);

    int updateNameAndPwd(Admin record);

    List<Admin> findAdminByName(Admin admin);
}
