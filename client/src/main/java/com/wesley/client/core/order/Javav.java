package com.wesley.client.core.order;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Create by yster@foxmail.com 2018/11/15 0015 0:23
 */
public class Javav {

    public static String version(){
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String version = runtimeMXBean.getSystemProperties().get("java.runtime.version");
        String name = runtimeMXBean.getSystemProperties().get("java.runtime.name");
        String info = version + " " + name;
        return info;
    }

}
