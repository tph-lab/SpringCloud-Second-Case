package com.yc.piclib.controllers;


import com.yc.piclib.future.PiclibFuture;
import com.yc.piclib.service.PiclibRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@RestController
@RequestMapping("/test")
public class TestController {


    // 异步方案
    @Autowired
    private PiclibFuture piclibFuture;

    //同步方案
    @Autowired
    private PiclibRestService piclibRestService;

    //异步
    @RequestMapping(value = "/list")
    public CompletableFuture<String> findAll() {

        //     piclibFuture.findPage(1, 2, "good").thenApply(page -> page);
        return piclibFuture.findPage(1, 2, "pic").thenApply(new Function<String, String>() {
            @Override
            public String apply(String page) {             //该参数类型，取决于piclibFuture.findPage的返回值参数类型，名字随便取
                return page;
            }
        });
    }

    @RequestMapping(value = "/list1")
    public String findAll1() {
        return piclibRestService.findAll(1, 2, "good");
    }
}