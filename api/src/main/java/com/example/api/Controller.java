package com.example.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class Controller {
    @Autowired
    Dao dao;

    @PostMapping("getDepts")
    public ArrayList<JSONObject> getDepts(){
       return dao.getDepts();
    }

    @PostMapping("getResult")
    public ArrayList<JSONObject> getResult(@RequestBody JSONObject jsonObject){
       return dao.getResult(jsonObject.getIntValue("dept_id"));
    }

}
