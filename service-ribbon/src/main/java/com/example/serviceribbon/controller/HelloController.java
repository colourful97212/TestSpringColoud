package com.example.serviceribbon.controller;

import com.collourful.api.entity.Dept;
import com.example.servicehi.util.JsonResult;
import com.example.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }


    private static final String REST_URL_PREFIX = "http://SERVICE-HI";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,JsonResult.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult get(@PathVariable(value = "id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,JsonResult.class);
    }

    @RequestMapping(value = "/consumer/dept/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",JsonResult.class);
    }
/*    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult add(Dept dept){
        return helloService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult get(@PathVariable(value = "id") Long id){
        return helloService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult list(){
        return helloService.list();
    }*/



}
