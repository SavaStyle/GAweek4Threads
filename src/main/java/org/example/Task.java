package org.example;

public class Task {

    public static void init() {
        Thread asyncThread = new Thread(() -> {
            while (true) {
                System.out.println("Асинхронный привет!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Асинхронный пока!");
                try {
                    Thread.sleep(5000); // ждем 5 секунд
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread mainThread = new Thread(() -> {
            while (true) {
                System.out.println("Работает основная программа");
                try {
                    Thread.sleep(1000); // ждем 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        asyncThread.start();
        mainThread.start();
    }
}
