package com.bishe.demo.common.util.tool;

import java.util.Calendar;
import java.util.Date;

public class Time {

    /**
     * @param separator 系统文件分割符
     * @return 生成 /2019/6/29 这样的文件路径
     */
    public static String getDir(String separator) {
        Date currentTime = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + separator + month + separator + day + separator;
    }

}
