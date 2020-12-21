package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread{
    private CountDownLatch uploader;

    public Uploader(CountDownLatch uploader) {
        this.uploader = uploader;
    }

    @Override
    public void run() {
        try {
            System.out.println("Файл скачивается с сервера");
            sleep(2000);
            System.out.println("Файл скачан с сервера");
            uploader.countDown();

        } catch (Exception e) {}
    }
}
