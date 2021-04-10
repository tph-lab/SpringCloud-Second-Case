package com.yc.piclib.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.nio.charset.Charset;
import java.util.Base64;

//自定义网关的过滤器
public class AuthorizedRequestFilter extends ZuulFilter {

    //类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;   //相当于直接返回   "pre"
    }

    //优先级
    @Override
    public int filterOrder() {   //   order值 越小，过滤器越在前面执行
        return 0;
    }


    //是否启动
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /*
        HttpHeaders headers=new HttpHeaders();
        String auth="admin:a";   //认证的原始用户名和密码
        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); //加密处理
        String authHeader="Basic "+new String(encodeAuth);
        headers.set("Authorization",authHeader);    //    Http请求头         Authorization: Base xxxxxxxxx
     */
    //需要运行的程序
    //是用来解决被代理的服务的密保权限问题
    @Override
    public Object run() throws ZuulException {
        // 获取当前请求的上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 认证的原始信息
        String auth = "admin:a";
        // 进行一个加密的处理
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII")));
        //Http请求头         Authorization: Base xxxxxxxxx
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }


}