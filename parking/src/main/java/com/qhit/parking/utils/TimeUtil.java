package com.qhit.parking.utils;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by 爸爸 on 2019/6/3.
 */
public class TimeUtil {
        public static HashMap<String,Long> formatDuring(long mss) {
            Long days = mss / (1000 * 60 * 60 * 24);
            Long  hours = (mss % (1000 * 60  * 60 * 24)) / (1000 * 60 * 60);
            Long minutes = (mss % (1000  * 60 * 60)) / (1000  * 60);
            Long seconds = (mss % (1000 * 60)) /  1000;
            HashMap<String,Long> map = new HashMap();
            map.put("days",days);
            map.put("hours",hours);
            map.put("minutes",minutes);
            map.put("seconds",seconds);
            return map;
        }
          /**
      * @param begin 时间段的开始
      * @param end   时间段的结束
      */
        public  static HashMap<String,Long> formatDuring(Date begin, Date end) {
                return  formatDuring(end.getTime() - begin.getTime());
        }
}
