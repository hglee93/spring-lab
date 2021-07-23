package com.github.springlab.completablefuture;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static com.github.springlab.completablefuture.AsyncTest.log;
import static com.github.springlab.completablefuture.AsyncTest.sleep;
import static org.junit.jupiter.api.Assertions.*;

class AsyncTestTest {

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
}