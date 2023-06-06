package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * 冒泡排序
     */
    @Test
    public void bubbleShort() {
        int[] a = { 3, 4, 2, 7, 6, 89, 46, 67, 88, 90, 57, 43 };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println(Runtime.getRuntime().availableProcessors());
        assertTrue(true);
        getDay("1990 9 20");
    }

    public int getDay(String day) {
        String[] split = day.split(" ");

        Calendar calendar = Calendar.getInstance();

        // 设置指定的日期
        calendar.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]));
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        // // 获取当前年份的一月一日
        // calendar.set(Calendar.DAY_OF_YEAR, 1);
        //
        // // 计算该天是本年的第几天
        // int dayOfYear = (int) ((calendar.getTimeInMillis() -
        // calendar.getTimeZone().getOffset(calendar.getTimeInMillis())) / (24 * 60 * 60
        // * 1000));
        // int currentDayOfYear = (int) ((System.currentTimeMillis() -
        // calendar.getTimeZone().getOffset(System.currentTimeMillis())) / (24 * 60 * 60
        // * 1000));
        // dayOfYear = currentDayOfYear - dayOfYear + 1;

        System.out.println("该天是本年的第 " + dayOfYear + " 天");
        return dayOfYear;
    }

    /**
     * 计算工期的预计完成日期
     */
    @Test
    public void ProjectSchedule() {
        // 设置开始日期为 2023 年 6 月 6 日
        LocalDate startDate = LocalDate.of(2023, 6, 6);

        // 计算工期为 5 天的预计结束日期
        int workload = 5;
        LocalDate endDate = calculateEndDate(startDate, workload);

        // 输出结果
        System.out.println("开始日期：" + startDate);
        System.out.println("工期（日）：" + workload);
        System.out.println("预计结束日期：" + endDate);
    }

    /**
     * 计算工期的预计完成日期
     * 该函数接受两个参数，分别是开始日期 `startDate` 和工作量 `workload`。函数内部使用 Java 8 提供的 `LocalDate` 类型来进行日期计算。
     * 首先，根据工作量计算预计结束日期 `endDate`，计算方式为从开始日期 `startDate` 开始，加上 (工作量-1) 天。最后返回结束日期 `endDate`。
     */
    public LocalDate calculateEndDate(LocalDate startDate, int workload) {
        LocalDate endDate = startDate.plusDays(workload - 1);
        return endDate;
    }

    /**
     * 使用了 Calendar 类型进行日期计算。首先，将开始日期 startDate 复制到一个新的日期对象 endDate，
     * 然后根据工作量计算预计结束日期，计算方式为从开始日期 startDate 开始，加上 (工作量-1) 天。最后返回结束日期 endDate。
     * @param startDate 开始日期
     * @param workload 工作日
     * @return 结束日期
     */
    public Calendar calculateEndDate(Calendar startDate, int workload) {
        Calendar endDate = (Calendar) startDate.clone();
        endDate.add(Calendar.DATE, workload - 1);
        return endDate;
    }

    /**
     * 计算工期的预计完成日期
     */
    @Test
    public void ProjectSchedule2() {
        // 设置开始日期为 2023 年 6 月 6 日
        Calendar startDate = Calendar.getInstance();
        startDate.set(2023, Calendar.JUNE, 6);

        // 计算工期为 5 天的预计结束日期
        int workload = 5;        
        Calendar endDate = calculateEndDate(startDate, workload);

        // 输出结果
        System.out.println("开始日期：" + startDate.getTime());
        System.out.println("工期（日）：" + workload);
        System.out.println("预计结束日期：" + endDate.getTime());
    }

    public String calculateEndDate(String startDateStr, int workload) throws ParseException {
        // 将开始日期字符串转换为日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(sdf.parse(startDateStr));

        // 计算工期为指定天数的预计结束日期
        Calendar endDate = (Calendar) startDate.clone();
        endDate.add(Calendar.DATE, workload - 1);

        // 将结束日期格式化为字符串
        return sdf.format(endDate.getTime());
    }

    @Test
    public void ProjectSchedule3(){
        try {
            // 设置开始日期为 2023 年 6 月 6 日
            String startDateStr = "2023-06-06";

            // 计算工期为 5 天的预计结束日期
            int workload = 5;        
            String endDateStr = calculateEndDate(startDateStr, workload);

            // 输出结果
            System.out.println("开始日期：" + startDateStr);
            System.out.println("工期（日）：" + workload);
            System.out.println("预计结束日期：" + endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        int[] rest = new int[0];
        System.out.println(Arrays.toString(rest));
    }
}
