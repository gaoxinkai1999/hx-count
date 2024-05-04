package com.example.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class ApiApplicationTests {
@Autowired
Dao dao;
	@Test
	void contextLoads() {
		ArrayList<JSONObject> result = dao.getResult(3);

		System.out.println(result);
	}

}
