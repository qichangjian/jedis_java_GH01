package com.qcj;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 单实例连接redis和池连接
 */
public class JedisTest {
    /**
     * 1.单实例连接redis
     */
    @Test
    public void test(){
        //获取jedis连接对象
        Jedis jedis = new Jedis("192.168.2.101",6379);
        //发送命令
        jedis.set("k2","k1内容");
        String v2 = jedis.get("k2");
        System.out.println("vs:" + v2);
        //关闭
        jedis.close();
    }

    /**
     * 2.池连接
     */
    @Test
    public void testPool(){
        //获取池
        JedisPool jedisPool = new JedisPool("192.168.2.101",6379);
        //获取每个jedis对象
        Jedis jedis = jedisPool.getResource();
        String k1 = jedis.get("k1");
        System.out.println("k1:" + k1);
        //关闭连接
        jedis.close();//关闭jedis连接
        //jedisPool.close();//关闭池
    }
}
