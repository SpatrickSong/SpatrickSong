package com.beyondsoft.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

@Service //创建实例
public class AsyncServiceImpl implements AsyncService{
    private  static Random random = new Random();
    @Async //调用任务单独开启一个子线程
    @Override
    public Future<String> doTask1() throws Exception {
        System.out.println("任务1开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务1结束，耗时："+(end-start )+"毫秒");
        return new AsyncResult<>("任务1结束");
    }

    @Async
    @Override
    public Future<String> doTask2() throws Exception {
        System.out.println("任务2开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务2结束，耗时："+(end-start )+"毫秒");
        return new AsyncResult<>("任务2结束");
    }

    @Async
    @Override
    public Future<String> doTask3() throws Exception {
        System.out.println("任务3开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务3结束，耗时："+(end-start )+"毫秒");
        return new AsyncResult<>("任务3结束");
    }
}
