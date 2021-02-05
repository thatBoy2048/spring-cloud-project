package com.zjmy.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

    private static class Padding {
        public volatile long p1, p2, p3, p4, p5, p6, p7; //
    }

    private static class T extends Padding {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    /**
     * 缓存行对
     * @throws InterruptedException
     */
    @Test
    void contextLoads() throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(()->{
            for (long i = 0; i < 1000_0000L; i++) {
                arr[1].x = i;
            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start)/100_0000);
    }

    private static int x = 0, y = 0;
    private static int a = 0, b =0;

    /**
     * 指令重排序
     * @throws InterruptedException
     */
    @Test
    void test2() throws InterruptedException {
        int  i = 0;
        for(;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread one = new Thread(new Runnable() {
                public void run() {
                    //由于线程one先启动，下面这句话让它等一等线程two. 读着可根据自己电脑的实际性能适当调整等待时间.
                    //shortWait(100000);
                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();other.start();
            one.join();other.join();
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
               // System.out.println(result);
            }
        }
    }

    private static volatile User USER_TEST;

    /**
     * 单列模式
     * @return
     */
    @Test
    static User getUser(){
        System.out.println(Thread.currentThread().getName());
        if(USER_TEST == null){
            synchronized(User.class){
                if(USER_TEST == null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    USER_TEST = new User();
                }
            }
        }
        return USER_TEST;
    }

    /**
     * 本地线程变量
     * @param args
     */
    public static void main(String[] args) {
        ThreadLocal<User> local = new ThreadLocal<>();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(local.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            local.set(new User());
            System.out.println(Thread.currentThread().getName()+local.get());
        },"我是2号线程").start();
    }

}
