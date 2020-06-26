package com.guoguo.javaAudition.job;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: algorithm
 * @description:
 * @author: Karl Guo
 * @create: 2018-10-24 11:14
 **/

public class DateUtils {


    public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_YMDHM = "yyyy-MM-dd HH:mm";

    public static final String DATE_FORMAT_SHORT = "yyyy-MM-dd";

    public static final String DATE_FORMAT_COMPACT = "yyyyMMdd";

    public static final String DATE_FORMAT_COMPACT_FULL = "yyyyMMddHHmmss";

    public static final String DATE_FORMAT_FULL_MSEL = "yyyyMMddHHmmssSSSS";

    public static final String DATE_YEAR_MONTH = "yyyyMM";

    public static final String DATE_FORMAT_FULL_MSE = "yyyyMMddHHmmssSSS";

    public static final String DATE_FORMAT_INTER = "dd-MM-yyyy KK:mm:ss a";

    public static final String DATE_FORMAT_YEAR_MONTH = "MMM yyyy";

    public static final String DATE_FORMAT_SHOET_B = "yyyy/MM/dd";


    /**
     * 获取当前时间
     * @return
     */
    public static String getNow(){
        return LocalDateTime.now().toString();
    }

    /**
     * 获取系统当前时间 yyyy-MM-dd HH:ss:mm
     * @return
     */
    public static String getCurTime(){
        return getCurDateTime(DATE_FORMAT_FULL);
    }

    /**
     * 获取当前日期年月 yyyy-MM
     * @return
     */
    public static String getCurDateYearMonth(){
        return getCurDateTime(DATE_YEAR_MONTH);
    }

    /**
     * 获取当前年月日  yyyyMMdd
     * @return
     */
    public static String getCurDateCompact(){
        return getCurDateTime(DATE_FORMAT_COMPACT);
    }

    /**
     * 获取当前年月日
     * @return
     */
    public static String getCurDateFormatShort(){
        return getCurDateTime(DATE_FORMAT_SHORT);
    }

    /**
     * 获取当前时间   yyyyMMddHHmmss
     * @return
     */
    public static String getCurDateCompactFull(){
        return getCurDateTime(DATE_FORMAT_COMPACT_FULL);
    }

    /**
     * 字符串转化为日期  yyyy-MM-dd HH:mm:ss
     * @param strDateTime
     * @return
     */
    public static LocalDateTime strToDateTime(String strDateTime){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(strDateTime, f);
    }

    /**
     * 字符串转日期 yyyy-MM-dd
     * @param strDate
     * @return
     */
    public static LocalDate strToDate(String strDate){
        LocalDate localDate = LocalDate.parse(strDate,DateTimeFormatter.BASIC_ISO_DATE);
        return localDate;
    }

    /**
     *  获取当前日期字符串 自定义格式
     * @return
     */
    public static String getCurDateTime(String dataFormat){
        LocalDateTime arrivalDate = LocalDateTime.now();
        String landing = null;
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(dataFormat);
            landing = arrivalDate.format(format);
//            System.out.printf("Arriving at : %s %n", landing);

        } catch (DateTimeException ex) {
//            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }
        return landing;
    }

    /**
     * 获取当天 0 点  2018-04-11 00:00:00
     * @return
     */
    public static LocalDateTime getToday0(){

        return LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static Date getTodayStart(){
        return getDayStart(new Date());
    }

    public static Date getDayStart(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取当前末点   2018-04-11 23:59:59:999
     * @return
     */
    public static LocalDateTime getTodayEnd(){
        return LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999);
    }


    //Date转换为LocalDateTime
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    //获取指定日期的毫秒
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    //获取指定日期的秒
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 判断是否是今天
     * @param strDate
     * @return
     */
    public static boolean isCurrentDay(String strDate){
        boolean flag = false;
        LocalDate localDate = LocalDate.parse(strDate);
        if(LocalDate.now().getYear() == localDate.getYear()){
            MonthDay monthDay = MonthDay.from(localDate);
            MonthDay today = MonthDay.from(LocalDate.now());
            return monthDay.equals(today);
        }
        return flag;
    }

    /**
     * 日期转字符串
     * @return
     */
    public static String parseDateToString(Date date, String format){
        if (date != null) {
            Instant instant = date.toInstant();
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
            return localDateTime.format(dateTimeFormatter);
        }
        return null;
    }

    /**
     * 字符串转日期
     *
     * @return Date
     */
    public static Date parseStringToDate(String date, String format) {
        DateFormat sdf = new SimpleDateFormat(format);
        Date dd1 = null;
        try {
            dd1 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dd1;
    }


    /**
     * 得到当日期前N天时间
     * @param format
     * @param day
     * @return
     */
    public static String beforeNDaysDate(String format, int day){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        if(day > 0){
            return LocalDateTime.now().minusDays(day).format(dateTimeFormatter);
        }
        return null;
    }


    /**
     * 得到N天后的日期
     * @param theDate
     * @param nDayNum
     * @param format
     * @return
     */
    public static String afterNDaysDate(String theDate, Integer nDayNum, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(theDate, dateTimeFormatter)
                .plusDays(nDayNum)
                .format(dateTimeFormatter);
    }

    /**
     * 得到N小时后的日期
     *
     * @param theDate  时间
     * @param nHourNum N小时数
     * @param format   时间格式
     * @return
     */
    public static String afterNHoursDate(String theDate, Integer nHourNum, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(theDate,dateTimeFormatter)
                .plusHours(nHourNum)
                .format(dateTimeFormatter);
    }

    /**
     * 按天数增加日期
     */
    public static Date addDateByDay(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }


    /**
     * 得到N分钟后的日期
     *
     * @param theDate
     * @param nMinNum
     * @param format
     * @return
     */
    public static String afterNMinsDate(String theDate, Integer nMinNum, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(theDate,dateTimeFormatter)
                .plusMinutes(nMinNum)
                .format(dateTimeFormatter);
    }

    /**
     * 得到N秒后的日期
     * @param theDate
     * @param nSecNum
     * @param format
     * @return
     */
    public static String afterNSecondsDate(String theDate, Integer nSecNum, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(theDate, dateTimeFormatter)
                .plusSeconds(nSecNum)
                .format(dateTimeFormatter);
    }

    /**
     * 比较两个字符串格式日期大小,带格式的日期
     * @param strdat1
     * @param strdat2
     * @param format
     * @return
     */
    public static boolean isBefore(String strdat1, String strdat2, String format) {
        try {
            Date dat1 = parseStringToDate(strdat1, format);
            Date dat2 = parseStringToDate(strdat2, format);
            return dat1.before(dat2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 比较两个字符串格式日期大小,带格式的日期,返回int
     * @param strdat1
     * @param strdat2
     * @param format
     * @return
     */
    public static long isBefore_int(String strdat1, String strdat2, String format) {
        long result = 0;
        try {
            Date dat1 = parseStringToDate(strdat1, format);
            Date dat2 = parseStringToDate(strdat2, format);
            return dat2.getTime() - dat1.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 计算两个日期相差天数
     * @param start
     * @param end
     * @return
     */
    public static int getSubDays(String start, String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        Long between = ChronoUnit.DAYS.between(startDate, endDate);
        return between.intValue();
    }


    /**
     * 计算两段时间之差
     * @param start
     * @param end
     * @return
     */
    public static long getSubTimeDiff(String start, String end){
        LocalDateTime startDateTime = LocalDateTime.parse(start);
        LocalDateTime endDateTime = LocalDateTime.parse(end);
        long between = ChronoUnit.MILLIS.between(startDateTime, endDateTime);
        return between;
    }

    /**
     *  计算两段时间年份之差
     * @param start
     * @param end
     * @return
     */
    public static String getSubYear(Date start, Date end){
        LocalDateTime startDate = dateToLocalDateTime(start);
        LocalDateTime endDate = dateToLocalDateTime(end);
        int startYear = startDate.getYear();
        int endYear = endDate.getYear();
        return String.valueOf(endYear - startYear);
    }

    /**
     * 计算两个时间之差
     * @param time1
     * @param time2
     * @return
     * @throws Exception
     */
    public static String getTimeDiff(Date time1, Date time2) throws Exception {
        long l = time1.getTime() - time2.getTime();
        String returnStr = "";
        long day = l / (24 * 60 * 60 * 1000);
        if (day > 0) {
            returnStr += (day + "天");
        }
        long hour = (l / (60 * 60 * 1000) - day * 24);
        if (hour > 0) {
            returnStr += (hour + "小时");
        }
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        if (min > 0) {
            returnStr += (min + "分");
        }
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        if (s > 0) {
            returnStr += (s + "秒");
        }
        return returnStr;
    }

    /**
     * LocalDateTime to java.util.Date
     * @param time
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime time){
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * java.util.Date to LocalDateTime
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date){
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 取本月第一天
     * @return
     */
    public static LocalDate firstDayOfThisMonth(){
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 取本月最后一天
     * @return
     */
    public static LocalDate lastDayOfThisMonth(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public static void main(String[] args) {

        Date date = DateUtils.addDateByDay(parseStringToDate(DateUtils.lastDayOfThisMonth().toString(), DateUtils.DATE_FORMAT_SHORT), 1);
        System.out.println(date);
    }



}
