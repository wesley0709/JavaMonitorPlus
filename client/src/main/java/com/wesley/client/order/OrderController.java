package com.wesley.client.order;

import com.wesley.client.core.entity.JinfoEntity;
import com.wesley.client.core.entity.JpsEntity;
import com.wesley.client.core.entity.JstackEntity;
import com.wesley.client.core.entity.KVEntity;
import com.wesley.client.core.order.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by yster@foxmail.com 2018/12/30 0030 16:44
 */
@RestController
public class OrderController {

    @RequestMapping("/version")
    public String getVersion(){
        return Javav.version();
    }

    @RequestMapping("/info")
    public JinfoEntity getInfo(String id){
        return Jinfo.info(id);
    }

    @RequestMapping("/jstack")
    public JstackEntity getJstack(String id){
        return Jstack.jstack(id);
    }

    @RequestMapping("/jps")
    public Map<String, JpsEntity> getJps(){
        return Jps.jps();
    }

    @RequestMapping("/jstatclass")
    public List<KVEntity> getJstatClass(String id) throws Exception {
        return Jstat.jstatClass(id);
    }

    @RequestMapping("/jstatgc")
    public List<KVEntity> getJstatGc(String id) throws Exception {
        return Jstat.jstatGc(id);
    }

    @RequestMapping("/jstatutil")
    public List<KVEntity> getJstatUtil(String id) throws Exception {
        return Jstat.jstatUtil(id);
    }

    /**
     * 系统物理内存
     * @return
     */
    @RequestMapping("/systemInfo")
    public Map<String,Server> systemInfo() {
        try {
            HashMap<String,Server> map = new HashMap<>();
            Server server = new Server();
            server.copyTo();
            map.put("server",server);
            return map;
        } catch (Exception e) {
            return  null;
        }

    }

}
