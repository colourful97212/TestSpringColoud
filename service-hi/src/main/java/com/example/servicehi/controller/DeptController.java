package com.example.servicehi.controller;


import com.collourful.api.entity.Dept;
import com.example.servicehi.service.DeptServiceIn;
import com.example.servicehi.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptServiceIn deptService;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult<Boolean> add(@RequestBody Dept dept){
        JsonResult<Boolean> jsonResult = new JsonResult<>();
        Boolean b = deptService.add(dept);
        jsonResult.setData(b);
        jsonResult.setStatus(200);
        jsonResult.setMessage("Success");
        return jsonResult;
    }

    @RequestMapping(value = "dept/get/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult<Dept> get(@PathVariable("id") Long id){
        JsonResult<Dept> jsonResult = new JsonResult<>();
        Dept b = deptService.get(id);
        jsonResult.setData(b);
        jsonResult.setStatus(200);
        jsonResult.setMessage("Success");
        return jsonResult;
    }

    @RequestMapping(value = "dept/list",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
    public JsonResult<List<Dept>> list(){
        JsonResult<List<Dept>> jsonResult = new JsonResult<>();
        List<Dept> list = deptService.list();
        jsonResult.setData(list);
        jsonResult.setStatus(200);
        jsonResult.setMessage("Success");
        return jsonResult;
    }
}
