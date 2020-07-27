package cn.skyjilygao.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 提供者
 * @author skyjilygao
 */
@RestController
public class ServiceProviderController {
    private final Logger log = LoggerFactory.getLogger(ServiceProviderController.class);

    @Value("${server.port}")
    private String port;
    @RequestMapping("test")
    public  String test(){
        String str = "this is provier! 端口号为："+port;
        try {
            InetAddress host = InetAddress.getLocalHost();
            str += String.format(". host name: %s, host ip: %s", host.getHostName(), host.getHostAddress());
        } catch (UnknownHostException e) {
            str += " errMsg: " + e.getMessage();
        }
        return str;
    }

    @GetMapping("hello")
    public String hello(String name){
        String str = "你好："+name+"! 端口号为："+port;
        try {
            InetAddress host = InetAddress.getLocalHost();

            str += String.format(". host name: %s, host ip: %s", host.getHostName(), host.getHostAddress());
        } catch (UnknownHostException e) {
            str += " errMsg: " + e.getMessage();
        }
        return str;
    }
    @PostMapping("hello")
    public String hello(@RequestBody JSONObject json){
        String str = "json："+json+"! 端口号为："+port;
        try {
            InetAddress host = InetAddress.getLocalHost();
            str += String.format(". host name: %s, host ip: %s", host.getHostName(), host.getHostAddress());
        } catch (UnknownHostException e) {
            str += " errMsg: " + e.getMessage();
        }
        return str;
    }

}