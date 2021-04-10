package com.yc.piclib.client;


import com.yc.piclib.config.FeignClientConfig;
import com.yc.piclib.domain.PicDomain;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 通过fegin，底层使用AOP机制，动态代理自动生成实现类
 */
//在eureka上注册的服务名
@FeignClient(name = "MICROSERVICE-PROVIDER-PICLIB",
        configuration = FeignClientConfig.class
)  // 配置要按自定义的类FeignClientConfig
public interface PiclibClient {

    @RequestMapping(method = RequestMethod.GET, value = "/piclib/{id}")
    //该处的@RequestParam("id")可替换为@PathVariable("id")
    String findById(@RequestParam("id") Integer id);


    @RequestMapping(method = RequestMethod.GET, value = "/piclib/findAll",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String findAll(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize,
                   @RequestParam("description") String description);


    @RequestMapping(method = RequestMethod.POST, value = "/piclib",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String create(@RequestBody PicDomain picDomain);


    @RequestMapping(method = RequestMethod.DELETE, value = "/piclib/{id}")
    String delete(@RequestParam("id") Integer id);

}