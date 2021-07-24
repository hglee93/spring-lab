package com.github.springlab.completablefuture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class AsyncTestTest {

    static final Logger logger = LoggerFactory.getLogger(AsyncTestTest.class);

    @Test
    void thenApply_테스트() {
        AsyncTest asyncTest = new AsyncTest();
        CompletableFuture applyTask = asyncTest.asyncApplyTest();
        applyTask.join();
    }

    @Test
    void thenAccept_테스트() {
        AsyncTest asyncTest = new AsyncTest();
        CompletableFuture acceptTask = asyncTest.asyncThenAcceptTest();
        acceptTask.join();
    }

    @Test
    void completableExam01() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
           return "test01";
        }).thenApply(result -> {
            String ret = result + " received";
            System.out.println(ret);
            return ret;
        });

        Assertions.assertEquals("test01 received", future.get());
    }

    @Test
    void completableExam02() {
        CompletableFuture.runAsync(() -> {
            logger.info("call runAsync Comsumer function");
        });
    }
}