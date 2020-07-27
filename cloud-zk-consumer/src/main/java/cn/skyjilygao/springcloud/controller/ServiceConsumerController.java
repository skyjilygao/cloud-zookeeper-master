package cn.skyjilygao.springcloud.controller;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 消费者
 * @author skyjilygao
 * @date 20200727
 */
@RestController
public class ServiceConsumerController {

    private final Logger log = LoggerFactory.getLogger(ServiceConsumerController.class);
    @Autowired
    private RestTemplate restTemplate;
 
    /**
     *
     * @return
     */
    @RequestMapping("test")
    public String test(){
         String result = restTemplate.getForObject("http://zk-provider/test", String.class);
        log.info("result={}", result);
        return result;
     }

    @GetMapping("hello")
    public String hello(String name){
        Map<String, Object> p = new HashMap<>();
        p.put("name", name);
        String result = restTemplate.getForObject("http://zk-provider/hello?name={name}", String.class, p);
        log.info("result={}", result);
        return result;
    }

    @PostMapping("hello")
    public String hello(@RequestBody JSONObject json){
        String result = restTemplate.postForObject("http://zk-provider/hello", json, String.class);
        log.info("result={}", result);
        return result;
    }

}