package com.example.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface Dao {

    @Select("SELECT\n" +
            "    user.name,\n" +
            "    COUNT(IF((F = 5 OR F = 6 OR M = 5 OR M = 6), 1, NULL)) AS '10块',\n" +
            "    COUNT(IF(GREATEST(F, M) = 4, 1, NULL)) AS '5块',\n" +
            "    COUNT(IF(GREATEST(F, M) = 3, 1, NULL)) AS '3块',\n" +
            "    COUNT(IF(GREATEST(F, M) = 2, 1, NULL)) AS '1块'\n" +
            "FROM\n" +
            "    vip\n" +
            "        JOIN\n" +
            "    user ON vip.维护人id = user.id\n" +
            "WHERE\n" +
            "    所属部门id = #{dept_id}\n" +
            "   and R<=3\n" +
            "GROUP BY\n" +
            "    user.name;")
    ArrayList<JSONObject> getResult(int dept_id);

    @Select("select * from dept")
    ArrayList<JSONObject> getDepts();
}
