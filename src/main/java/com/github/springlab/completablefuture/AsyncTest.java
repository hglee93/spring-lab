package com.github.springlab.completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class AsyncTest {
    public static final Logger log = LoggerFactory.getLogger(AsyncTest.class);

    public CompletableFuture task;

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void log(String s) {
        log.info(s);
    }

    public static void main(String[] args) {
        AsyncTest asyncTest = new AsyncTest();
        asyncTest.asyncTest();
    }

    public CompletableFuture asyncTest() {
        //TODO
        task = CompletableFuture.supplyAsync(() -> {
            log("Start");
            sleep(5000);
            log("end");
            return "OK";
        }).thenApply(result -> {
            log("apply1 : " + result);
            return "apply1 OK";
        }).thenApply(result -> {
            log("apply2 : " + result);
            return "apply2 OK";
        }).thenApply(result -> {
            log("apply3 : " + result);
            return "apply3 OK";
        });
        return task;
    }

}
