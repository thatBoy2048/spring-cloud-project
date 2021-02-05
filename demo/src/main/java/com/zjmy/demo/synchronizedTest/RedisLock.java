package com.zjmy.demo.synchronizedTest;

import redis.clients.jedis.Jedis;

/**
 * @author ZhongXiang
 * Date on 2021/1/29  9:30
 */
public class RedisLock {

    //锁的key
    private static final String key = "DistributedRedisLock";
    private static Integer count = 0;
    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //获取Redis连接
                    Jedis jedis = new Jedis("127.0.0.1", 6379);
                    try{
                        while(true){
                            //获取锁
                            if(jedis.setnx(key, Thread.currentThread().getName()) == 1){
                                try{
                                    System.out.println("线程（"+Thread.currentThread().getName()+"）获取到锁，开始执行操作");
                                    count++;
                                    System.out.println(count);
                                    break;
                                }finally{
                                    System.out.println("操作执行完成，释放锁");
                                    //操作执行完一定要释放锁，所以在finally块中执行
                                    jedis.del(key);
                                }
                            }else{
                                //返回的不是1，说明已经有某个线程获取到了锁
                                try {
                                    //等待100毫秒之后重试
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally{
                        //释放Redis连接
                        jedis.disconnect();
                    }
                }
            }).start();
        }
    }

}
