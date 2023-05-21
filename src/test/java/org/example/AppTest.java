package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Calendar;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(Runtime.getRuntime().availableProcessors());
        assertTrue( true );
        getDay("1990 9 20");
    }

    public int getDay(String day){
        String[] split = day.split(" ");

        Calendar calendar = Calendar.getInstance();

        // 设置指定的日期
        calendar.set(Integer.parseInt(split[0]), Integer.parseInt(split[1])-1, Integer.parseInt(split[2]));
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        // // 获取当前年份的一月一日
        // calendar.set(Calendar.DAY_OF_YEAR, 1);
        //
        // // 计算该天是本年的第几天
        // int dayOfYear = (int) ((calendar.getTimeInMillis() - calendar.getTimeZone().getOffset(calendar.getTimeInMillis())) / (24 * 60 * 60 * 1000));
        // int currentDayOfYear = (int) ((System.currentTimeMillis() - calendar.getTimeZone().getOffset(System.currentTimeMillis())) / (24 * 60 * 60 * 1000));
        // dayOfYear = currentDayOfYear - dayOfYear + 1;

        System.out.println("该天是本年的第 " + dayOfYear + " 天");
        return dayOfYear;
    }

}
