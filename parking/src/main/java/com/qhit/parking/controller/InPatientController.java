package com.qhit.parking.controller;

import com.alibaba.fastjson.JSON;
import com.qhit.parking.entity.InPatient;
import com.qhit.parking.service.inpatien.InPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/28.
 */
@Controller
@RequestMapping("/inpatient")
public class InPatientController {

    @Autowired
    private InPatientService inPatientService;

    @RequestMapping("/inpatient-list")
    public  String inpatientList(Model model){
        List<InPatient> inPatientList = inPatientService.selectAll();
        List<InPatient> maxAmounts = inPatientService.getMaxAmount();
        Double maxAmount = maxAmounts.get(0).getMaxAmount();
        System.out.println(maxAmount);
        model.addAttribute("maxAmount",maxAmount);
        model.addAttribute("Inpatient",inPatientList);
        return "inpatient/inpatient-list";
    }

    @RequestMapping("/findInpatientByKey")
    public  String findInpatientByKey(Model model,InPatient inPatient){
        List<InPatient> inPatientList = inPatientService.findInpatientByKey(inPatient);
        model.addAttribute("Inpatient",inPatientList);
        return "inpatient/inpatient-list";
    }

    @RequestMapping("/inpatient-add")
    public String inpatientAdd(){
        return "inpatient/inpatient-add";
    }
    @RequestMapping("/getBedNum")
    @ResponseBody
    public String getBedNum(){
        List<InPatient> bedNum = inPatientService.getBedNum();
        String s = JSON.toJSONString(bedNum);
        return s;
    }
    @RequestMapping("/inpatient-save")
    @ResponseBody
    public HashMap inpatientSave(InPatient inPatient){

        HashMap map = new HashMap();
        int i = inPatientService.insert(inPatient);
        if(i!=0){
            map.put("res","0");
        }else {
            map.put("res","1");
        }
        return  map;
    }
    @RequestMapping("/hidden")
    public  String inpatienthidden(Model model){
        List<InPatient> inPatientList = inPatientService.hidden();
        model.addAttribute("Inpatient",inPatientList);
        return "inpatient/inpatient-list";
    }

    @RequestMapping("/show")
    public  String inpatientshow(Model model){
        List<InPatient> inPatientList = inPatientService.show();
        model.addAttribute("Inpatient",inPatientList);
        return "inpatient/inpatient-list";
    }
}
