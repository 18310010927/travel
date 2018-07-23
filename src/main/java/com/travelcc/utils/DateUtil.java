package com.travelcc.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Date工具类
 */
public class DateUtil {
    public static String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static String DATE_FORMAT_HHMMSS = "HHmmss";
    public static String DATE_FORMAT_YYYY_MM_DD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";
    public static String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd hh:mm:ss.SSS";
    public static String DATE_FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    /**
     * 此类中封装一些常用的字符串操作。 所有方法都是静态方法，不需要生成此类的实例， 为避免生成此类的实例，构造方法被申明为private类型的。
     */
    private DateUtil() {
    	
    }
    /**
     * 获取时间的分钟数（double）
     * @param timer
     * @return
     */
    public static Double getTotalMinutes(long timer) {
    	  Double time=(double)timer/(1000*60);
    	  double   f1   =  new BigDecimal(time).setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue();  
    	  return f1;
    }
  
    /**
     * 获取两个时间的时间差
     * @param time1 
     * @param time2 
     * @return date 
     */
    public static Date getDateMinus(Date time1,Date time2) {
    	Date date=new Date(getDateDiff(time1.getTime(), time2.getTime()));
    	return date;
    	
    }
    /**
     * 获取两个时间的时间差
     * @param time1 
     * @param time2 
     * @return long 
     */
    public static Long getDateDiff(Date time1,Date time2) {
    	
    	return getDateDiff(time1.getTime(), time2.getTime());
    	
    }
    /**
     * 获取两个时间的时间差
     * @param time1 
     * @param time2 
     * @return long 
     */
    public static Long getDateDiff(Long time1,Long time2) {
    	return time1 - time2;
    }
    /**
     * 获取当前系统时间，格式'yyyy-mm-dd'
     *
     * @return 当前系统时间
     */
    public static String getLocalDate() {
        return format(getDate());
    }

    /**
     * 获取指定格式的系统时间字符串
     *
     * @param dateFormat 日期格式
     * @return 指定格式的系统时间
     */
    public static String getLocalDate(String dateFormat) {
        return format(getDate(), dateFormat);
    }

    /**
     * 获取当前系统日期、时间
     *
     * @return 当前系统日期、时间
     */
    public static Date getDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获取当前时间戳
     *
     * @return 当前时间戳
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(getDate().getTime());
    }

    /**
     * 返回当前系统日期、时间
     *
     * @param format 返回日期的格式
     * @return 系统日期、时间
     */
    public static Date getDate(String format) {
        return parse(getLocalDate(format),format);
    }

    /**
     * 格式化日期 'yyyy-mm-dd'
     *
     * @param date 日期
     * @return 日期字符串格式 'yyyy-mm-dd'
     */
    public static String format(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 格式：dateFormat 指定的格式
     *
     * @param date 日期
     * @param dateFormat 日期格式
     * @return 日期字符串格式
     */
    public static String format(Date date, String dateFormat) {
        return format(date, dateFormat, "");
    }

    public static String format(Date date, String dateFormat, String defaultRtn) {
        if (defaultRtn == null)
            defaultRtn = "";
        if (date == null)
            return defaultRtn;
        Format formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    /**
     * 将"yyyy-MM-dd"格式的字符串格式化为Date类型
     *
     * @param str 待转换的字符串
     * @return 日期
     */
    public static Date parse(String str) {
        return parse(str, "yyyy-MM-dd");
    }

    /**
     * 将指定格式的字符串格式化为Date类型
     *
     * @param str 待转换的字符串
     * @param dateFormat 格式
     * @return 日期
     */
    public static Date parse(String str, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        try {
            return format.parse(str);
        } catch (ParseException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * 根据指定日期字符串进行日期计算后返回格式化的日期-时间字符串
     *
     * @param rq 日期
     * @param format 录入日期或时间的格式
     * @param field 日历字段
     * @param amount 为字段添加的日期或时间量。
     * @param rtnFormat 返回的日期或时间的格式
     * @return 格式化的日期-时间字符串。
     */
    public static String add(String rq, String format, int field, int amount, String rtnFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse(rq, format));
        calendar.add(field, amount);
        return format(calendar.getTime(), rtnFormat);
    }

    /**
     * 将日期进行计算后返回计算后的格式化的日期
     *
     * @param rq 格式化的日期-时间字符串
     * @param amount 为字段添加的日期量。
     * @return 计算后的格式化的日期
     */
    public static String addDate(String rq, int amount) {
        return add(rq, "yyyy-MM-dd", Calendar.DATE, amount, "yyyy-MM-dd");
    }

    /**
     * 将月度进行计算后返回计算后的格式化的日期
     *
     * @param rq 格式化的日期-时间字符串
     * @param amount 为字段添加的日期量。
     * @return 计算后的格式化的日期
     */
    public static String addMonth(String rq, int amount) {
        return add(rq, "yyyyMM", Calendar.MONTH, amount, "yyyyMM");
    }

    /**
     * 将年度进行计算后返回计算后的格式化的日期
     *
     * @param rq 格式化的日期-时间字符串
     * @param amount 为字段添加的日期量。
     * @return 计算后的格式化的日期
     */
    public static String addYear(String rq, int amount) {
        return add(rq, "yyyy", Calendar.YEAR, amount, "yyyy");
    }

    /**
     * 增加日期
     *
     * @param date 日期
     * @param field the calendar field
     * @param i 数量
     * @return 添加i数量日期单位后的日期
     */
    public static Date addDate(Date date, int field, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, i);
        return calendar.getTime();
    }

    /**
     * 增加日期
     *
     * @param date 日期
     * @param i 天数
     * @return 添加i天后的日期
     */
    public static Date addDate(Date date, int i) {
        return addDate(date, Calendar.DATE, i);
    }

    /**
     * 增加日期
     *
     * @param date 日期
     * @param i 月数
     * @return 添加i月后的日期
     */
    public static Date addMonth(Date date, int i) {
        return addDate(date, Calendar.MONTH, i);
    }

    /**
     * 增加日期
     *
     * @param date 日期
     * @param i 年数
     * @return 添加i年后的日期
     */
    public static Date addYear(Date date, int i) {
        return addDate(date, Calendar.YEAR, i);
    }

    /**
     * 计算两个日期之间的日期差值
     * @param date1 日期1
     * @param date2 日期2
     * @return 日期1-日期2 的值
     * @since 1.1
     */
    public static int differenceOfDay(Date date1, Date date2) {
        int sign = date1.compareTo(date2);
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        if (sign > 0) {
            cal1.setTime(date1);
            cal2.setTime(date2);
        } else {
            cal1.setTime(date2);
            cal2.setTime(date1);
        }
        int total = 0;
        while (cal2.get(Calendar.YEAR) < cal1.get(Calendar.YEAR)) {
            total += cal2.getActualMaximum(Calendar.DAY_OF_YEAR);
            cal2.add(Calendar.YEAR, 1);
        }
        if (cal2.get(Calendar.YEAR) == cal1.get(Calendar.YEAR)) {
            total += cal1.get(Calendar.DAY_OF_YEAR) - cal2.get(Calendar.DAY_OF_YEAR);
        }
        return sign * total;
    }

    /**
     * 获取距当前系统时间前24小时的数据，格式'yyyy-mm-dd'
     *
     * @return 昨天系统时间
     */
    public static String getLastDate() {
        Date date = new Date();
        date = addDate(date, -1);
        return format(date);
    }

    /**
     * 获取日期的所在月份的最大日期
     *
     * @param date
     * @return 日期的所在月份的最大日期
     */
    public static Date getLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        return calendar.getTime();
    }

    /**
     * 获取距当前系统时间前24小时的数据，格式'yyyy-mm-dd'
     *
     * @return 昨天系统时间
     */
    public static int getLocalHourse() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取距当前系统时间前24小时的数据，格式'yyyy-mm-dd'
     *
     * @return 昨天系统时间
     */
    public static int getLocalMinute() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 根据日历的规则，为给定的日历字段添加或减去指定的旬数。
     *
     * @param date 日期
     * @param amount 与日期所在旬的差值量
     * @return 根据日历的规则，获取给定的日期所在旬差值为amount的旬度的第一日
     * @since 1.1
     */
    public static Date getFirstDayPeriodOfTenDays(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int xunCount = (calendar.get(Calendar.DAY_OF_MONTH) - 1) / 10;
        if (xunCount == 3)
            xunCount = 2;
        int monthDiff;
        if ((xunCount + amount) < 0) {
            if ((xunCount + amount) / 3 == 0)
                monthDiff = ((xunCount + amount) / 3 - 1);
            else
                monthDiff = (xunCount + amount) / 3;
        } else {
            monthDiff = (xunCount + amount) / 3;
        }
        calendar.setTime(addMonth(calendar.getTime(), monthDiff));
        if ((xunCount + amount) % 3 == 0) {
            xunCount = 0;
        } else if ((xunCount + amount) % 3 < 0) {
            xunCount = (xunCount + amount) % 3 + 3;
        } else {
            xunCount = (xunCount + amount) % 3;
        }
        switch (xunCount) {
            case 0:
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                break;
            case 1:
                calendar.set(Calendar.DAY_OF_MONTH, 11);
                break;
            default:
                calendar.set(Calendar.DAY_OF_MONTH, 21);
        }
        return calendar.getTime();
    }

    /**
     * 根据日历的规则，为给定的日历字段添加或减去指定的旬数。
     *
     * @param date 日期
     * @param amount 与日期所在旬的差值量
     * @return 根据日历的规则，获取给定的日期所在旬差值为amount的旬度的最后一日
     * @since 1.1
     */
    public static Date getEndDayPeriodOfTenDays(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int xunCount = (calendar.get(Calendar.DAY_OF_MONTH) - 1) / 10;
        if (xunCount == 3)
            xunCount = 2;
        int monthDiff;
        if ((xunCount + amount) < 0) {
            if ((xunCount + amount) / 3 == 0)
                monthDiff = ((xunCount + amount) / 3 - 1);
            else
                monthDiff = (xunCount + amount) / 3;
        } else {
            monthDiff = (xunCount + amount) / 3;
        }
        calendar.setTime(addMonth(calendar.getTime(), monthDiff));
        if ((xunCount + amount) % 3 == 0) {
            xunCount = 0;
        } else if ((xunCount + amount) % 3 < 0) {
            xunCount = (xunCount + amount) % 3 + 3;
        } else {
            xunCount = (xunCount + amount) % 3;
        }
        switch (xunCount) {
            case 0:
                calendar.set(Calendar.DAY_OF_MONTH, 10);
                break;
            case 1:
                calendar.set(Calendar.DAY_OF_MONTH, 20);
                break;
            default:
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        return calendar.getTime();
    }

    /**
     * 根据日期，得到该日期本月第一天为多少
     *
     * @param rq
     * @return 该月第一天
     */
    public static String getFirstDayOfMonth(String rq) {
        String strResult = "";
        strResult = rq.substring(0, 7) + "-01";
        return strResult;
    }

    /**
     * 根据日期，得到该日期本月第一天为多少
     *
     * @param rq
     * @return 该月第一天
     */
    public static String getFirstDayOfMonth(Date rq) {
        String strRq = format(rq);
        String strResult = "";
        strResult = strRq.substring(0, 7) + "-01";
        return strResult;
    }

    /**
     * 根据日期，得到该日期本月第一天为多少
     *
     * @param rq
     * @return 该月第一天
     */
    public static Date getFirstDayOfMonthDate(String rq) {
        String strResult = "";
        strResult = rq.substring(0, 7) + "-01";
        return getDate(strResult);
    }

    /**
     * 根据日期，得到该日期本年第一天为多少
     *
     * @param rq
     * @return 该年第一天
     */
    public static String getFirstDayOfYear(Date rq) {
        String strRq = format(rq);
        String strResult = "";
        strResult = strRq.substring(0, 4) + "-01-01";
        return strResult;
    }

    /**
     * 根据日期，得到该日期年第一天为多少
     *
     * @param rq
     * @return 该年第一天
     */
    public static Date getFirstDayOfYearDate(Date rq) {
        String strrq = format(rq);
        String strResult = "";
        strResult = strrq.substring(0, 4) + "-01-01";
        return getDate(strResult);
    }

    /**
     * 根据日期，得到该日期本月第一天为多少
     *
     * @param rq
     * @return 该月第一天
     */
    public static Date getFirstDayOfMonthDate(Date rq) {
        String strResult = "";
        String strRq = format(rq);
        strResult = strRq.substring(0, 7) + "-01";
        return getDate(strResult);
    }

    /**
     * 合并两个时间，合并后的时间是将date的年、月、日作为年、月、日，将time的时、分、秒作为时、分、秒
     *
     * @param date 2009-10-20 15:47:03
     * @param time 2009-10-23 17:45:10
     * @return date time 2009-10-20 17:45:10
     */
    public static Date getDateTime(Date date, Date time) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date);
        c2.setTime(time);
        c1.set(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DATE), c2.get(Calendar.HOUR_OF_DAY), c2.get(Calendar.MINUTE), c2.get(Calendar.SECOND));
        return c1.getTime();
    }

    /**
     * 根据给定的月份第几周和周几算出所在的日期
     *
     * @param month 月份
     * @param week 第几周
     * @param weekday 一周中的周几
     * @return 指定月份中第几周、周几的日期
     */
    public static Date getDayOfWeekMonth(int month, int week, int weekday) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.WEEK_OF_MONTH, week);
        c.set(Calendar.DAY_OF_WEEK, weekday);
        return c.getTime();
    }

    /**
     * 根据给定的月份、第几周、周几计算出日期的集合
     *
     * @param months 月份的数组
     * @param weeks 第几周的数组
     * @param weekDays 周几的数组
     * @return 日期的集合
     */
    public static List<Date> getDayOfWeekMonth(int[] months, int[] weeks, int[] weekDays) {
        List<Date> list = new ArrayList<Date>();
        for (int m : months) {
            for (int w : weeks) {
                for (int weekday : weekDays) {
                    Date day = getDayOfWeekMonth(m, w, weekday);
                    if (day.getMonth() == (m - 1)) {
                        list.add(day);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 比较date1和date2相差的多少秒
     *
     * @param date1
     * @param date2
     * @return 两个时间相差的秒数
     */
    public static int differenceOfSecond(Date date1, Date date2) {
        return Math.abs((int) (date1.getTime() - date2.getTime()) / 1000);
    }

    public static int getDatePart(Date date, int ymd) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return ymd == Calendar.MONTH ? c.get(ymd) + 1 : c.get(ymd);
    }
    
    public static String getYear(Date date) {
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String year=""+calendar.get(Calendar.YEAR);
		return year;
    }
    public static String getMonth(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	String month=""+(calendar.get(Calendar.MONTH)+1);
    	return month;
    }
    public static String getDayOfMonth(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	String day=""+calendar.get(Calendar.DATE);
    	return day;
    }
}
