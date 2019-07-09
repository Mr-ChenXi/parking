package com.qhit.parking.dao;

import com.qhit.parking.entity.InPatient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InPatientMapper {
    int deleteByPrimaryKey(Integer patientId);

    int insert(InPatient record);

    InPatient selectByPrimaryKey(Integer patientId);

    List<InPatient> selectAll();

    List<InPatient> hidden();

    List<InPatient> show();

    int updateByPrimaryKey(InPatient record);

    List<InPatient> findInpatientByKey(InPatient inPatient);

    List<InPatient> getBedNum();

    List<InPatient> getMaxAmount();
}