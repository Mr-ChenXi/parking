package com.qhit.parking.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 爸爸 on 2019/5/31.
 */
public class  OrderCode {
    public static final String PREFIX = "DD";
    //订单编号后缀（核心部分）
    private static long code;

    // 生成订单编号
    public static synchronized String getOrderCode() {
        code++;
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        long m = Long.parseLong((str)) * 10000;
        m += code;
        return PREFIX + m;
    }


}
