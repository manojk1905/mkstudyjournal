package com.mk.test.concurrency;

import java.util.concurrent.*;

public class CompletableFutureMain {

    private static ExecutorService executorService;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                return "Hello";
            }
        });
        System.out.println(future.get());
        executorService.shutdown();

        Future<String> completableFuture =  CompletableFuture.completedFuture("Hello 1");
        String result = completableFuture.get();
        System.out.println(result);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello 2");
        System.out.println(future1.get());
    }
}
