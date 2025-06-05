package org.example.haoaiagent.controller;


import lombok.extern.slf4j.Slf4j;



@Slf4j
public class test {
    public static void main(String[] args) {
        // 重构thread方法
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                System.out.println("runing...");
            }
        };
        thread1.start();
        // runnable构建
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Rruning...");
            }
        };

        Thread t1 = new Thread(r);
        t1.start();

        // lamada简化
        Runnable r1 = () -> {
            System.out.println("R1runing...");
        };

        Thread t2 = new Thread(r1);
        t2.start();
    }
}
