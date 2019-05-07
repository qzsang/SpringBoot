package com.qzs.sboot.service;


import com.qzs.sboot.domain.City;
import com.qzs.sboot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;


    public City select(String state) {
       return cityMapper.findByState(state);
    }


}
