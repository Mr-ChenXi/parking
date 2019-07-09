package com.qhit.parking.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.qhit.parking.entity.Orders;
import com.qhit.parking.entity.Park;
import com.qhit.parking.service.park.ParkService;
import com.qhit.parking.utils.ExcelUtiles;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/27.
 */
@Controller
@RequestMapping("/park")
public class ParkController {

    @Autowired
    private ParkService parkService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Park> parks = parkService.selectAll();
        model.addAttribute("parkList",parks);
        return  "park/park-list";
    }
    @RequestMapping("/park-add")
    public String parkAdd(){
        return  "park/park-add";
    }
    @RequestMapping("/park-save")
    @ResponseBody
    public HashMap parkSave(Park park)  {
        int i = parkService.insert(park);
        HashMap map=new HashMap();
        if(i!=0){
            map.put("res","0");
        }else {
            map.put("res","1");
        }
        return map;
      }
    @RequestMapping("/importfile")
    public  String importfile(){
        return "importfile/import";
    }

    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response){
        List<Park> list=parkService.selectAll();

        ExcelUtiles.exportExcel(list,"车位列表","车位",Park.class,"车位列表.xls",response);
    }
    @RequestMapping("/exportTemplate")
    @ResponseBody
    public void exportStuInfoExcel(HttpServletResponse response){
        List<Park> list=new ArrayList();

        ExcelUtiles.exportExcel(list,"车位列表","车位",Park.class,"车位列表.xls",response);
    }

    @RequestMapping("/import")
    @ResponseBody
    public HashMap importPark(@RequestParam("file") MultipartFile file) throws Exception {

        System.out.println(file.getInputStream());
        HashMap map=new HashMap();
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<Park> list = ExcelImportUtil.importExcel(file.getInputStream(), Park.class, params);
        int i = parkService.batchInsert(list);
        if(i>0){
             map.put("res","0");
        }
        return map;
    }

    @RequestMapping("/histogram")
    public  String histogram(){
        return "graphic/histogram";
    }



    @RequestMapping("/histogram-list")
    @ResponseBody
    public List histogramList(){
        List<Park> parks = parkService.selectAll();
        return parks;
    }

    @RequestMapping("/line")
    public  String line(){
        return "graphic/line";
    }
    @RequestMapping("/line-list")
    @ResponseBody
    public List lineList(){
        List<Park> parks = parkService.selectAll();
        return parks;
    }
}
