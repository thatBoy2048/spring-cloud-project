package com.zjmy.demo.synchronizedTest;


import org.openjdk.jol.info.ClassLayout;

/**
 * @author ZhongXiang
 * Date on 2021/1/21  9:25
 */
public class Test
{

//    public static void main(String[] args) {
//        Object o = new Object();
//
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//
//        synchronized(o){
//            System.err.println(ClassLayout.parseInstance(o).toPrintable());
//        }
//
//        ThreadLocal<Object> t = new ThreadLocal();
//
//        t.set(new Object());
//
//        t.get();
//        t.remove();
//    }

    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        new Thread(()->{
            while (flag) {
                //do sth
                System.out.println("--------------1:"+Thread.currentThread().getName());
            }
            System.out.println("end");
        },"thread-0001").start();
        Thread.sleep(1000);
        flag = false;
        System.out.println("--------------2:"+Thread.currentThread().getName());
    }


}
