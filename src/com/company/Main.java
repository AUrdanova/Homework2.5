package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch uploaderCdl=new CountDownLatch(1);
        CountDownLatch dowlonderCdl=new CountDownLatch(10);
        Semaphore semaphore=new Semaphore(3);
        Uploader uploader = new Uploader(uploaderCdl);
        uploader.start();

        for (int i = 1; i < 11; i++) {
            new Downlonder("Человек"+i,uploaderCdl,dowlonderCdl,semaphore).start();
        }

        try {
            dowlonderCdl.await();
            System.out.println("Файл удален с сервера");
        } catch (Exception e) {

        }
    }
}
