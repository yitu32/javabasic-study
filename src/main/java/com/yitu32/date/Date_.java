package com.yitu32.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Date_ {
    @Test
    public void test01() throws InterruptedException {
        // 得到当前时间距 1970年1月1日的时间毫秒数
        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());
        TimeUnit.SECONDS.sleep(1);
        Date date = new Date();
        Date date1 = new Date(date.getTime());
        // 比前面大一秒，然后再多一点点
        System.out.println(date1.getTime());
        System.out.println(date1.toString());
    }

    @Test
    public void test02() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        // 默认的
        System.out.println("默认的格式化：" + sdf.format(date));
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        System.out.println("定制的格式化：" + sdf2.format(date));
        try {
            // String -> Date  但是需要保证输入的格式和SimpleDateFormat里面的pattern的格式一致，
            // 否则报ParseException错误
            Date date2 = sdf2.parse("2022年05月03日 14:39:18 星期二");
            System.out.println(date2.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test03() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        // get方法：
        System.out.println("年：" + calendar.get(Calendar.YEAR));
        // 月份从0开始 12月是11
        System.out.println("月：" + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("日：" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("时：" + calendar.get(Calendar.HOUR));
        System.out.println("分：" + calendar.get(Calendar.MINUTE));
        System.out.println("秒：" + calendar.get(Calendar.SECOND));
        // 星期从周日开始是1，周六是7
        System.out.println("星期几：" + (calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
        System.out.println("今年的第几天：" + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("今年的第几周：" + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("本月的第几周：" + calendar.get(Calendar.WEEK_OF_MONTH));
        // getTime: 从一个 Calendar 对象中获取 Date 对象
        Date date = calendar.getTime();
        System.out.println("由Calender对象得到的Date对象：" + date);
        // setTime: 设置一个指定的time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date4SetTime = sdf.parse("2022-05-02 09:10:11");
        // date中的日期不会设置进去
        calendar.setTime(date4SetTime);
        System.out.println("设置时间之后：" + calendar.getTime());
        // set 设置日期
        calendar.set(Calendar.DAY_OF_MONTH, 9);
        System.out.println("把日期设置为9：" + calendar.getTime());
        // add 进行时间或日期的运算
        calendar.add(Calendar.HOUR, 23);
        System.out.println("加23小时:" + calendar.getTime());
        calendar.add(Calendar.MONTH, -11);
        System.out.println("减11个月:" + calendar.getTime());

    }

    @Test
    public void test04() {
        // LocalDate
        // 当前时间(重载的方法可以指定时区)
        LocalDate localDate01 = LocalDate.now();
        // 可以指定年月日
        LocalDate localDate02 = LocalDate.of(2022, 1, 6);
        LocalDate localDate03 = LocalDate.of(2022, Month.FEBRUARY, 6);
        System.out.println("localDate01:" + localDate01);
        System.out.println("localDate02:" + localDate02);
        System.out.println("localDate03:" + localDate03);
        // LocalTime
        LocalTime localTime01 = LocalTime.now();
        LocalTime localTime02 = LocalTime.of(22, 12, 02);
        System.out.println("localTime01:" + localTime01);
        System.out.println("localTime02:" + localTime02);
        // LocalDateTime
        LocalDateTime localDateTime01 = LocalDateTime.now();
        LocalDateTime localDateTime02 = LocalDateTime.of(2022, 05, 14, 17, 10, 20, 113);
        // 可以组合一个date和一个time
        LocalDateTime localDateTime03 = LocalDateTime.of(localDate01, localTime01);
        System.out.println("LocalDateTime01:" + localDateTime01);
        System.out.println("LocalDateTime02:" + localDateTime02);
        System.out.println("localDateTime03:" + localDateTime03);
        // getXXX 获取一个时间类型中的年月日时分秒等
        int year = localDateTime03.getYear();
        int monthValue = localDateTime03.getMonthValue();
        int dayOfMonth = localDateTime03.getDayOfMonth();
        int hour = localDateTime03.getHour();
        int minute = localDateTime03.getMinute();
        int second = localDateTime03.getSecond();
        System.out.println(year + " " + monthValue + " " + dayOfMonth + " " + hour + " " + minute + " " + second);
        // with 以某个时间为基础得到另一个时间，返回的时间不影响原来的时间
        LocalDateTime withYear2008 = localDateTime02.withYear(2008);
        LocalDateTime withHour23 = localDateTime02.withHour(23);
        System.out.println("withYear2008" + withYear2008);
        System.out.println("withHour23" + withHour23);
    }

    @Test
    public void test05() {
        // 格式化
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse("2022-05-05 12:23:34", timeFormatter);
        System.out.println("parse:" + parse);
        String format = now.format(timeFormatter);
        System.out.println("format:" + format);
    }

    @Test
    public void test06() {
        // 时间计算
        LocalDateTime now = LocalDateTime.now();
        // plusXXX 增加时间，minusXXX 减少时间
        LocalDateTime plus2Days = now.plusDays(2);
        LocalDateTime minus3Hours = now.minusHours(3);
        // 减正数 = 加负数
        LocalDateTime plus_3Hours = now.plusHours(-3);
        // 可以直接调用plus/minus 指定单位即可
        LocalDateTime plus3Years = now.plus(3, ChronoUnit.YEARS);
        System.out.println("now:" + now);
        System.out.println("plus2Days:" + plus2Days);
        System.out.println("plus-3Hours:" + plus_3Hours);
        System.out.println("minus3Hours:" + minus3Hours);
        System.out.println("plus3Years:" + plus3Years);
    }

    @Test
    public void test07() {
        LocalDateTime localDateTime01 = LocalDateTime.of(2022, 03, 14, 05, 30, 20);
        LocalDateTime localDateTime02 = LocalDateTime.of(2022, 03, 15, 05, 30, 20);
        LocalDateTime localDateTime03 = LocalDateTime.of(2022, 03, 14, 05, 30, 20);
        // isBefore方法，判断localDateTime01是否在localDateTime02之前
        System.out.println("localDateTime01.isBefore(localDateTime02):" + localDateTime01.isBefore(localDateTime02));
        // isAfter方法，判断localDateTime02是否在localDateTime01之后
        System.out.println("localDateTime02.isAfter(localDateTime02):" + localDateTime02.isAfter(localDateTime01));
        // isEqual方法，判断两时间是否为同一时间（非同一对象）
        System.out.println("localDateTime01.isEqual(localDateTime03):" + localDateTime01.isEqual(localDateTime03));
    }

    @Test
    public void test08() {
        // Duration 以秒和纳秒为单位
        LocalDateTime localDateTime01 = LocalDateTime.of(2022, 03, 14, 05, 30, 20);
        LocalDateTime localDateTime02 = LocalDateTime.of(2022, 03, 15, 05, 30, 20);
        Duration duration = Duration.between(localDateTime01, localDateTime02);
        System.out.println("两时间相差的秒数：" + duration.getSeconds());
        System.out.println("两时间相差的纳秒数：" + duration.getNano());
        // Period 以年月日为单位
        LocalDate localDate01 = LocalDate.of(2021, 03, 03);
        LocalDate localDate02 = LocalDate.of(2022, 05, 06);
        Period period = Period.between(localDate01, localDate02);
        // 不能单独来看，得把年月日组合起来看
        System.out.println("两时间相差的年数：" + period.getYears());
        System.out.println("两时间相差的月数：" + period.getMonths());
        System.out.println("两时间相差的天数：" + period.getDays());
        // ChronoUnit
        long s = ChronoUnit.SECONDS.between(localDateTime01, localDateTime02);
        System.out.println("两时间相差的秒数：" + s);
        long m = ChronoUnit.MONTHS.between(localDate01, localDate02);
        System.out.println("两时间相差的月数：" + m);

    }

    @Test
    public void test09() {
        // TemporalAdjuster:时间校正器
        // 获取当前日期的下一个周日是哪天？
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
        LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
        System.out.println(localDateTime);
        // 获取下一个工作日是哪天？
        LocalDate localDate = LocalDate.now().with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                LocalDate date = (LocalDate) temporal;
                if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    return date.plusDays(3);
                } else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                    return date.plusDays(2);
                } else {
                    return date.plusDays(1);
                }
            }
        });
        System.out.println("下一个工作日是：" + localDate);
    }

    @Test
    public void test10() {
        // ZoneId:类中包含了所有的时区信息
        // ZoneId的getAvailableZoneIds():获取所有的ZoneId
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        /*for (String s : zoneIds) {
            System.out.println(s);
        }*/
        // ZonedDateTime:带时区的日期时间
        // ZonedDateTime的now():获取本时区的ZonedDateTime对象
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime(default):" + zonedDateTime);
        // 可以指定时区
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("zonedDateTime(Asia/Tokyo):" + zonedDateTime1);
    }
}
