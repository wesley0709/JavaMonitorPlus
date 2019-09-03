package com.wesley.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());

    }



}

