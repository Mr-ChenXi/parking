package com.qhit.parking.controller;

import com.qhit.parking.entity.Admin;
import com.qhit.parking.service.admin.AdminService;
import com.qhit.parking.utils.RedisUtil;
import com.qhit.parking.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by 爸爸 on 2019/5/24.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/login")
    public String test(){
        return "admin/login";
    }
    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request, Model model) {
        String localAddr = request.getLocalAddr();    //取得服务器IP
        int localPort = request.getLocalPort();    //取得服务器端口
        String localName = request.getLocalName();    //取得服务器名称
        String serverName = request.getServerName(); //服务器域名
        Properties props=System.getProperties(); //系统属性
        String javaVersion = props.getProperty("java.version");//操作系统的版本
        String osName = props.getProperty("os.name");//操作系统的名称
        model.addAttribute("localAddr",localAddr);
        model.addAttribute("localPort",localPort);
        model.addAttribute("localName",localName);
        model.addAttribute("serverName",serverName);
        model.addAttribute("osName",osName);
        model.addAttribute("javaVersion",javaVersion);
        return "admin/welcome";
    }

    @RequestMapping("/log")
    public String login(Admin admin, Model model,HttpSession session,@RequestParam("ver")String ver){

        if(session.getAttribute("verCode").toString().equalsIgnoreCase(ver)){
            Admin user = adminService.getUserByNameAndPwd(admin);
            if (user != null){
                session.setAttribute("LogAdmin",user);
                redisUtil.set("LogAdminUser:"+user.getId(),session.getId());
                System.out.println(session.getId());
                return "admin/index";
            }else {
                model.addAttribute("error","用户名或者密码错误");
                return "admin/login";
            }
        }else {
            model.addAttribute("error","验证码错误");
            return "admin/login";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("LogAdmin");
        return "admin/login";
    }
    @RequestMapping("/change-info")
    public String changeInfo(Integer adminId,Model model){
        Admin admin = adminService.selectByPrimaryKey(adminId);
        model.addAttribute("admin",admin);
        return "admin/change-info";
    }

    @RequestMapping("/admin-add")
    public String adminAdd(){
        return  "admin/admin-add";
    }
    @RequestMapping("/admin-save")
    @ResponseBody
    public String adminSave(Admin admin)  {
        int i = adminService.insert(admin);
        String result="";
        if(i!=0){
            result="Y";
        }else {
            result="N";
        }
        return result;
    }
    @RequestMapping("/delAdmin")
    @ResponseBody
    public String delAdmin(Integer adminId)  {
        int i = adminService.deleteByPrimaryKey(adminId);
        String result="";
        if(i>0){
            result="Y";
        }else {
            result="N";
        }
        return result;

    }

    @RequestMapping("/admin-load")
    public String adminLoad(Integer adminId,Model model){
        Admin admin = adminService.selectByPrimaryKey(adminId);
        model.addAttribute("admin",admin);
        return "admin/change-edit";
    }
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public String updateAdmin(Admin admin) {
        int i = adminService.updateNameAndPwd(admin);
        String result="";
        if(i!=0){
            result="Y";
        }else {
            result="N";
        }
        return result;
    }
    @RequestMapping("/list")
    public String list(Admin admin, Model model){
        List<Admin> admins = adminService.selectAll();
        model.addAttribute("adminList",admins);
        return "admin/admin-list";
    }

    @RequestMapping("/stopAdmin")
    @ResponseBody
    public String stopAdmin(Integer adminId)  {
        int i = adminService.updateStop(adminId);
        String result="";
        if(i!=0){
            result="Y";
        }else {
            result="N";
        }
        return result;

    }
    @RequestMapping("/startAdmin")
    @ResponseBody
    public String startAdmin(Integer adminId){
        int i = adminService.updateStart(adminId);
        String result="";
        if(i>0){
            result="Y";
        }else {
            result="N";
        }
       return result;

    }

    @RequestMapping("/findAdminByName")
    public String findAdminByName(Admin admin, Model model){
        List<Admin> admins = adminService.findAdminByName(admin);
        model.addAttribute("adminList",admins);
        return "admin/admin-list";
    }

    @RequestMapping("/captcha")
    public void insert(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = 100, h = 30;

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }
}
