package com.qhit.parking.service.inpatien;

import com.qhit.parking.dao.InPatientMapper;
import com.qhit.parking.entity.InPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/28.
 */
@Service
public class InPatientServiceImpl implements InPatientService {

    @Autowired
    private InPatientMapper inPatientMapper;

    @Override
    public List<InPatient> selectAll() {
        return inPatientMapper.selectAll();
    }

    @Override
    public List<InPatient> findInpatientByKey(InPatient inPatient) {
        return inPatientMapper.findInpatientByKey(inPatient);
    }

    @Override
    public List<InPatient> getBedNum() {
        return inPatientMapper.getBedNum();
    }

    @Override
    public int insert(InPatient record) {
        return inPatientMapper.insert(record);
    }

    @Override
    public List<InPatient> hidden() {
        return inPatientMapper.hidden();
    }

    @Override
    public List<InPatient> show() {
        return inPatientMapper.show();
    }

    @Override
    public List<InPatient> getMaxAmount() {
        return inPatientMapper.getMaxAmount();
    }
}
