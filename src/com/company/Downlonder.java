package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downlonder extends Thread{
    private CountDownLatch uploader;
    private CountDownLatch downlonder;
    private Semaphore semaphore;// продавцы-кассиры

    public Downlonder(String name, CountDownLatch uploader, CountDownLatch downlonder, Semaphore semaphore) {
        super(name);
        this.uploader = uploader;
        this.downlonder = downlonder;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            uploader.await();
            semaphore.acquire();//начало обязанностей кассира
            System.out.println(getName() + "начинает скачивать");
            sleep(2000);
            System.out.println(getName()+"скачал файл");
            downlonder.countDown();
            semaphore.release(); //конец обязанностей кассира

        } catch (Exception e) {}
    }
}
