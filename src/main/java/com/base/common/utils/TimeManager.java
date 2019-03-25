package com.base.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Schedules the specified task for repeated fixed-delay execution
 * beginning at the specified time. Subsequent executions take place at
 * approximately regular intervals, separated by the specified period
 */
public class TimeManager {
    //time interval
    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

    public TimeManager() {
        Calendar calendar = Calendar.getInstance();
        /** 定制每日4：00执行方法**/
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date date = calendar.getTime();

        if (date.before(new Date())) {
            date = this.addDay(date, 1);

        }
        Timer timer = new Timer();
        DemoTimerTask demoTimerTask = new DemoTimerTask();
        timer.schedule(demoTimerTask, date, PERIOD_DAY);


    }

    public Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.DAY_OF_MONTH, num);
        return startDT.getTime();

    }

}
