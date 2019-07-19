package com.canyapan.example.apringbootapiexceptionexampleapp.controller;

import com.canyapan.example.apringbootapiexceptionexampleapp.exceptions.MyCustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/{isError}")
    public String getHello(@PathVariable String isError) {
        if (null != isError && isError.equals("true")) { // GET -> localhost:8080/true
            throw new MyCustomException("Some details");
            /* HTTP 404 {"timestamp":"2019-07-19T13:33:48.724+0000","message":"Some details","details":"uri=/true"} */
        }

        return "Hello!!";
    }
}
