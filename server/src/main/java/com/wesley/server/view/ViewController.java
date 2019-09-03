package com.wesley.server.view;

import com.wesley.server.core.util.DateUtils;
import com.wesley.server.core.util.Md5;
import com.wesley.server.core.util.Res;
import com.wesley.server.remote.parm.AddressParm;
import com.wesley.server.remote.parm.entity.Address;
import com.wesley.server.sys.dao.SysUserMapper;
import com.wesley.server.sys.entity.SysUserEntity;
import com.wesley.server.view.service.ViewService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Create by yster@foxmail.com 2018/11/12 0012 23:29
 */
@Controller
public class ViewController {
    @Autowired
    private AddressParm addressParm;
    @Autowired
    private ViewService viewService;
    @Autowired
    private SysUserMapper sysUserMapper;

    @RequestMapping(value = "/index")
    public String index(ModelMap model) throws IOException {
        List<Map<String,Object>> list = new ArrayList<>();
        for (Address address : addressParm.getServe()) {
            list.add(viewService.getIndex(address));
        }
        model.addAttribute("list",list);
        return "index";
    }

    @RequestMapping(value = "/main")
    public String main(ModelMap model) throws IOException {
        List<JSONObject> list = new ArrayList<>();
        for (Address address : addressParm.getServe()) {
            list.add(viewService.getMain(address));
        }
        model.addAttribute("list",list);
        return "main";
    }

    @RequestMapping(value = "/monitor")
    public String monitor(){
        return "monitor";
    }

    /**
     * 登录页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/")
    public String localhost(ModelMap model){
        return "login";
    }

    /**
     * 登录页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    public String tologin(ModelMap model){
        return "login";
    }

    /**
     * 登录页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/logiout")
    public String logiout(HttpServletRequest request){
        request.getSession().removeAttribute("username");
        return "login";
    }

    /**
     * 登录检测
     * @param
     * @return
     */
    @RequestMapping("/checkLogin")
    @ResponseBody
    public Res login(String username, String password, HttpServletRequest request) {
        System.out.println("*****");
        System.out.println(username+" "+password);
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            return Res.error("账号密码不能为空");
        }
        Map<String, Object> paramMap=new HashMap<>();
        paramMap.put("username", username);
        SysUserEntity user =sysUserMapper.selectOne(new QueryWrapper(paramMap));
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(Md5.encode(password))){
            return Res.error("账号或密码不正确");
        }else{
            request.getSession().setAttribute("username", user.getName());
            return Res.ok();
        }
    }

    /**
     * 用户列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/userList")
    public String userList(ModelMap model){
        List<SysUserEntity> list=sysUserMapper.selectList(null);
        model.addAttribute("list",list);
        return "userList";
    }

    /**
     * 添加用户
     * @param name
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveUser")
    public Res saveUser(String name,String password){
        try {
            SysUserEntity u=new SysUserEntity();
            u.setName(name);
            int count=sysUserMapper.selectCount(new QueryWrapper(u));
            if(count>0){
                return Res.error("用户名已存在");
            }
            SysUserEntity user=new SysUserEntity();
            user.setName(name);
            user.setPassword(Md5.encode(password));
            user.setDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            sysUserMapper.insert(user);
            return Res.ok();
        } catch (Exception e) {
            return Res.error();
        }
    }

    /**
     * 删除
     * @param name
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/delUser")
    public Res delUser(int id,HttpServletRequest request){
        try {
            sysUserMapper.deleteById(id);
            return Res.ok();
        } catch (Exception e) {
            return Res.error();
        }
    }

}
