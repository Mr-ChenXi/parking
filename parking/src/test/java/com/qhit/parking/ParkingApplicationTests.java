package com.qhit.parking;

import com.qhit.parking.utils.OrderCode;
import com.qhit.parking.utils.RedisUtil;
import com.qhit.parking.utils.TimeUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @Test
    public void contextLoads() throws ParseException {
        //RedisUtil redisUtil = new RedisUtil();
     //   RedisUtil.set("name","李四");
        //stringRedisTemplate.opsForValue().set("name","李四");
//            redisUtil.set("name","李四");
       // redisTemplate.opsForValue().set("name","李四");
        //redisTemplate.opsForValue().get("name");
        Date date=new Date();
        String date2 = "2019-06-1 16:50:50";
        long time = date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap map = TimeUtil.formatDuring(sdf.parse(date2),date );
        System.out.println(map.get("days") +","+map.get("hours") +","+map.get("minutes"));
    }

}
