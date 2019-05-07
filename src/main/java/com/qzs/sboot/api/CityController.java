package com.qzs.sboot.api;

import com.qzs.sboot.domain.City;
import com.qzs.sboot.mapper.CityMapper;
import com.qzs.sboot.service.CityService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@RestController
public class CityController {


    @Autowired
    private CityService cityService;

    @RequestMapping("/login")
    public String login(String name, String pwd) {
//        cityMapper.findByState("CA")
//        HttpMessageConverter d;
        System.out.println("body:"  + ",name: " + name + ",pwd:" + pwd);


        return "name:" + name;
    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Example.class, args);
//    }


    @RequestMapping("/body")
    String body(HttpServletRequest request) throws IOException {


        String result = "";
        BufferedReader reader = request.getReader();
        String line = null;
        while ((line = reader.readLine()) != null) {
            result += line + "\n";
            System.out.println(line);
        }


        return result;
    }

    public static void main(String[] strings) {


        String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";
        ObjectMapper mapper = new ObjectMapper();
        //unmarshalling (reading JSON)
        try {
            Map a = mapper.readValue(json, Map.class);
            for (Object key : a.keySet()) {

                System.out.println(key.toString() + "=" + a.get(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
