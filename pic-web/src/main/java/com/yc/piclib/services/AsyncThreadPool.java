package com.yc.piclib.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//用于文件上传的
public class AsyncThreadPool {

    private static Logger logger = LoggerFactory.getLogger(AsyncThreadPool.class);

    private static AsyncThreadPool asyncThreadPool = null;
    private static ExecutorService threadPool = null;


    private AsyncThreadPool() {
        int processors = 2;
        logger.info("初始化:" + processors + "个异步线程池");
        threadPool = Executors.newFixedThreadPool(processors);
    }

    //创建异步线程池
    public final static AsyncThreadPool getInstance() {
        if (asyncThreadPool == null) {
            asyncThreadPool = new AsyncThreadPool();
        }
        return asyncThreadPool;
    }

    public void execute(Runnable thread) {
        threadPool.execute(thread);
    }
}
