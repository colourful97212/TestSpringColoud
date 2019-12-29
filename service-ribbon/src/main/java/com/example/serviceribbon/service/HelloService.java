package com.example.serviceribbon.service;

import com.collourful.api.entity.Dept;
import com.example.servicehi.util.JsonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HelloService {

    private static final String REST_URL_PREFIX = "http://SERVICE-HI";

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public JsonResult add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,JsonResult.class);
    }

    public JsonResult get( Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,JsonResult.class);
    }

    public JsonResult list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",JsonResult.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
