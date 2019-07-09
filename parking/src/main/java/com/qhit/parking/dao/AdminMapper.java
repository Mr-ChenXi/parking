package com.qhit.parking.dao;

import com.qhit.parking.entity.Admin;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAll();

    List<Admin> findAdminByName(Admin admin);

    int updateByPrimaryKey(Admin record);

    int updateNameAndPwd(Admin record);

    Admin getUserByNameAndPwd(Admin admin);

    int updateStop(Integer id);

    int updateStart(Integer id);
}