package com.example.demo.property.manager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyManager {

    @Value("${url1}")
    private String url1;

    @Value("${url2}")
    private String url2;


    public String getUrl1() {
        return url1;
    }

    public String getUrl2() {
        return url2;
    }
}
