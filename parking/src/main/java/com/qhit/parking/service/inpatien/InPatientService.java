package com.qhit.parking.service.inpatien;

import com.qhit.parking.entity.InPatient;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/28.
 */
public interface InPatientService {

    List<InPatient> selectAll();

    List<InPatient> findInpatientByKey(InPatient inPatient);

    List<InPatient> getBedNum();

    int insert(InPatient record);

    List<InPatient> hidden();

    List<InPatient> show();

    List<InPatient> getMaxAmount();
}
