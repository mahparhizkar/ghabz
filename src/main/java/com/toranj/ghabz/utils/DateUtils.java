package com.toranj.ghabz.utils;

/*      */
/*      */

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.GregorianCalendar;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ public class DateUtils
        /*      */ {
    /*      */   public static final String FARSI_DATE_PATTERN = "yyyy/MM/dd";
    /*      */   public static final String FARSI_FULL_TIME_STAMP_PATTERN = "yyyy/MM/dd HH:mm:ss.SSS";
    /*      */   public static final String FULL_TIME_STAMP_PATTERN = "dd.MM.yyyy HH:mm:ss.SSS";
    /*   38 */   private static final Date MIN_DATE = newDate(1970, 1, 1);
    /*      */
    /*      */
    /*      */
    /*      */
    /*   43 */   private static final Date MAX_DATE = newDate(2300, 1, 1);
    /*      */
    /*      */
    /*      */
    /*      */
    /*   48 */   private static Date todaysDate = null;
    /*      */
    /*      */
    /*      */
    /*      */
    /*   53 */   private static Date nowDate = null;
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static void overrideToday(Date date)
    /*      */   {
        /*   69 */     todaysDate = date;
        /*   70 */     nowDate = null;
        /*      */   }
    /*      */
    /*      */   public static void overrideNow(Date date) {
        /*   74 */     nowDate = date;
        /*   75 */     todaysDate = null;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */   public static Date getOverridenToday()
    /*      */   {
        /*   82 */     return todaysDate;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */   public static Date getOverridenNow()
    /*      */   {
        /*   89 */     return nowDate;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static void setChronologyLocale(String localeID)
    /*      */   {
        /*   99 */     locale = new ULocale(localeID);
        /*      */   }
    /*      */
    /*      */   public static String getChronologyLocale() {
        /*  103 */     return "" + locale;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */   public static void resetChronology()
    /*      */   {
        /*  110 */     locale = ULocale.getDefault();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*  117 */   private static ULocale locale = ULocale.getDefault();
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date getFirstInMonth(Date date)
    /*      */   {
        /*  124 */     Calendar icuDate = icuCalendar(date);
        /*      */
        /*  126 */     if (isFirstInMonth(icuDate)) {
            /*  127 */       return date;
            /*      */     }
        /*      */
        /*  130 */     icuDate.set(5, 1);
        /*  131 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date getFirstInYear(Date date)
    /*      */   {
        /*  140 */     Calendar icuDate = icuCalendar(date);
        /*      */
        /*  142 */     icuDate.set(5, 1);
        /*  143 */     icuDate.set(2, 0);
        /*  144 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */   public static Date getNextFirstInMonth(Date date) {
        /*  148 */     Calendar icuDate = icuCalendar(date);
        /*      */
        /*  150 */     icuDate.set(5, 1);
        /*  151 */     icuDate.add(2, 1);
        /*  152 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */   private static boolean isFirstInMonth(Calendar date) {
        /*  156 */     return date.get(5) == 1;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isFirstInMonth(Date date)
    /*      */   {
        /*  164 */     return isFirstInMonth(icuCalendar(date));
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isWeekend(Date date)
    /*      */   {
        /*  173 */     return icuCalendar(date).isWeekend();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date newDate(int year, int month, int day, int hour, int minute, int second)
    /*      */   {
        /*  186 */     return icuGregorianCalendar(year, month, day, hour, minute, second).getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date newDate(int year, int month, int day, int hour, int minute)
    /*      */   {
        /*  199 */     return newDate(year, month, day, hour, minute, 0);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date newDate(int year, int month, int day)
    /*      */   {
        /*  210 */     return newDate(year, month, day, 0, 0);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date copyDate(Date date)
    /*      */   {
        /*  218 */     return new Date(date.getTime());
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date newDate(Date date, int day)
    /*      */   {
        /*  227 */     return newDate(getYearIndexFrom(date), getMonthIndexFrom(date), day, 0, 0);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static String millisecondsToString(long milliseconds)
    /*      */   {
        /*  235 */     return millisecondsToString(milliseconds, "HH:mm:ss.SSS");
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static String millisecondsToString(long milliseconds, String format)
    /*      */   {
        /*  244 */     Calendar icuGC = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
        /*  245 */     icuGC.setTimeInMillis(milliseconds);
        /*  246 */     return new SimpleDateFormat(format, Locale.ROOT).format(icuGC);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int getYearIndexFrom(Date date)
    /*      */   {
        /*  255 */     return icuGregorianCalendar(date).get(1);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int getYearIndexInCurrentChronologyFrom(Date date)
    /*      */   {
        /*  264 */     return icuCalendar(date).get(1);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int getMonthIndexFrom(Date date)
    /*      */   {
        /*  273 */     return icuGregorianCalendar(date).get(2) + 1;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int getMonthIndexInCurrentChronologyFrom(Date date)
    /*      */   {
        /*  282 */     return icuCalendar(date).get(2) + 1;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int getDayIndexFrom(Date date)
    /*      */   {
        /*  291 */     return icuGregorianCalendar(date).get(5);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int getDayIndexInCurrentChronologyFrom(Date date)
    /*      */   {
        /*  300 */     return icuCalendar(date).get(5);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date getDateMidnight(Date date)
    /*      */   {
        /*  310 */     Calendar icuDate = icuCalendar(date);
        /*  311 */     icuDate.setTime(date);
        /*  312 */     icuDate.set(21, 0);
        /*  313 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date getEndOfDay(Date date)
    /*      */   {
        /*  321 */     Calendar icuDate = icuCalendar(date);
        /*  322 */     icuDate.setTime(date);
        /*  323 */     icuDate.set(21, icuDate.getActualMaximum(21));
        /*  324 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static String newDateAsString(int year, int month, int day)
    /*      */   {
        /*  335 */     return dateToString(newDate(year, month, day));
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date newVgerDate(int year, int month, int day)
    /*      */   {
        /*  348 */     return newDate(year, month, day, 12, 0);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date getLastInMonth(Date date)
    /*      */   {
        /*  357 */     Calendar icuDate = icuCalendar(date);
        /*      */
        /*  359 */     lastInMonth(icuDate);
        /*  360 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date getLastInYear(Date date)
    /*      */   {
        /*  369 */     Calendar icuDate = icuCalendar(date);
        /*      */
        /*  371 */     icuDate.set(6, icuDate.getActualMaximum(6));
        /*  372 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static String dateToString(Date date)
    /*      */   {
        /*  383 */     return dateToString(date, "dd.MM.yyyy");
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static String dateToString(Date date, String format)
    /*      */   {
        /*  396 */     if (date == null) return "";
        /*  397 */     if (format == null) return "";
        /*  398 */     return new SimpleDateFormat(format, Locale.ROOT).format(date);
        /*      */   }
    /*      */
    /*      */   public static String dateToStringByUserLanguage(Date date, String language) {
        /*  402 */     if (date == null) return null;
        /*  403 */     boolean persianCalendar = "fa".equals(language);
        /*  404 */     if (!persianCalendar) {
            /*  405 */       return dateToString(date);
            /*      */     }
        /*  407 */     return formatDateBy(date, "yyyy/MM/dd");
        /*      */   }
    /*      */
    /*      */   public static String dateToTimestampStringByUserLanguage(Date date, String language) {
        /*  411 */     if (date == null) return null;
        /*  412 */     boolean persianCalendar = "fa".equals(language);
        /*  413 */     if (!persianCalendar) {
            /*  414 */       return dateToString(date, "dd.MM.yyyy HH:mm:ss.SSS");
            /*      */     }
        /*  416 */     return formatDateBy(date, "yyyy/MM/dd HH:mm:ss.SSS");
        /*      */   }
    /*      */
    /*      */   private static String formatDateBy(Date date, String format) {
        /*  420 */     Calendar icuDate = icuCalendar(date);
        /*  421 */     SimpleDateFormat formatter = new SimpleDateFormat(format, icuDate.getLocale(ULocale.ACTUAL_LOCALE));
        /*  422 */     return formatter.format(icuDate.getTime());
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int numberOfYears(Date dateBefore, Date dateAfter)
    /*      */   {
        /*  433 */     return numberOfYears(icuCalendar(dateBefore), icuCalendar(dateAfter));
        /*      */   }
    /*      */
    /*      */   private static int numberOfYears(Calendar icuDateBefore, Calendar icuDateAfter)
    /*      */   {
        /*  438 */     if ((isLastInMonth(icuDateBefore)) || (isLastInMonth(icuDateAfter))) {
            /*  439 */       icuDateBefore.add(5, 1);
            /*  440 */       icuDateAfter.add(5, 1);
            /*      */     }
        /*      */
        /*  443 */     Calendar tempIcuDateBefore = icuCalendar(icuDateBefore.getTime());
        /*  444 */     Calendar tempIcuDateAfter = icuCalendar(icuDateAfter.getTime());
        /*  445 */     boolean negative = false;
        /*      */
        /*  447 */     if (icuDateBefore.compareTo(icuDateAfter) > 0) {
            /*  448 */       tempIcuDateBefore = icuCalendar(icuDateAfter.getTime());
            /*  449 */       tempIcuDateAfter = icuCalendar(icuDateBefore.getTime());
            /*  450 */       negative = true;
            /*      */     }
        /*      */
        /*  453 */     int years = tempIcuDateAfter.get(1) - tempIcuDateBefore.get(1);
        /*  454 */     if (years == 0) return 0;
        /*  455 */     years--;
        /*  456 */     if ((tempIcuDateAfter.get(2) > tempIcuDateBefore.get(2)) || ((tempIcuDateAfter.get(2) == tempIcuDateBefore.get(2)) && (tempIcuDateAfter.get(5) >= tempIcuDateBefore.get(5))))
            /*      */     {
            /*      */
            /*  459 */       years++;
            /*      */     }
        /*  461 */     return negative ? -1 * years : years;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int numberOfMonths(Date dateBefore, Date dateAfter)
    /*      */   {
        /*  473 */     return numberOfMonths(icuCalendar(dateBefore), icuCalendar(dateAfter));
        /*      */   }
    /*      */
    /*      */   private static int numberOfMonths(Calendar icuDateBefore, Calendar icuDateAfter)
    /*      */   {
        /*  478 */     if ((isLastInMonth(icuDateBefore)) || (isLastInMonth(icuDateAfter))) {
            /*  479 */       icuDateBefore.add(5, 1);
            /*  480 */       icuDateAfter.add(5, 1);
            /*      */     }
        /*      */
        /*  483 */     Calendar tempIcuDateBefore = icuCalendar(icuDateBefore.getTime());
        /*  484 */     Calendar tempIcuDateAfter = icuCalendar(icuDateAfter.getTime());
        /*  485 */     boolean negative = false;
        /*      */
        /*  487 */     if (icuDateBefore.compareTo(icuDateAfter) > 0) {
            /*  488 */       tempIcuDateBefore = icuCalendar(icuDateAfter.getTime());
            /*  489 */       tempIcuDateAfter = icuCalendar(icuDateBefore.getTime());
            /*  490 */       negative = true;
            /*      */     }
        /*      */
        /*      */
        /*  494 */     int months = tempIcuDateAfter.get(1) > tempIcuDateBefore.get(1) ? 12 * (tempIcuDateAfter.get(1) - tempIcuDateBefore.get(1)) : 0;
        /*  495 */     months += tempIcuDateAfter.get(2) - tempIcuDateBefore.get(2);
        /*      */
        /*  497 */     if (months == 0) {
            /*  498 */       return 0;
            /*      */     }
        /*  500 */     months--;
        /*      */
        /*  502 */     if (tempIcuDateAfter.get(5) >= tempIcuDateBefore.get(5)) {
            /*  503 */       months++;
            /*      */     }
        /*  505 */     return negative ? -1 * months : months;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date subtractDay(Date date)
    /*      */   {
        /*  515 */     Calendar icuDate = icuCalendar(date);
        /*  516 */     boolean wasMidnight = shouldCorrectMidnightTimeAfterDaylightSavingTimeTransition(icuDate);
        /*  517 */     icuDate.add(5, -1);
        /*  518 */     if (wasMidnight) {
            /*  519 */       icuDate.set(21, 0);
            /*      */     }
        /*  521 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int numberOfCalendarYears(Date dateBefore, Date dateAfter)
    /*      */   {
        /*  531 */     Calendar icuDateBefore = icuCalendar(dateBefore);
        /*  532 */     Calendar icuDateAfter = icuCalendar(dateAfter);
        /*  533 */     return icuDateAfter.get(1) - icuDateBefore.get(1);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date dateToday()
    /*      */   {
        /*  543 */     Calendar today = Calendar.getInstance(locale);
        /*  544 */     if (getOverridenNow() != null) {
            /*  545 */       today = icuCalendar(getOverridenNow());
            /*  546 */     } else if (getOverridenToday() != null) {
            /*  547 */       today = icuCalendar(getOverridenToday());
            /*      */     }
        /*  549 */     today.set(21, 0);
        /*  550 */     return today.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date currentSystemDate()
    /*      */   {
        /*  558 */     Calendar now = Calendar.getInstance(locale);
        /*  559 */     now.set(21, 0);
        /*  560 */     return now.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static String dateTodayString()
    /*      */   {
        /*  568 */     return dateToString(dateToday());
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date dateNow()
    /*      */   {
        /*  578 */     Calendar now = Calendar.getInstance(locale);
        /*  579 */     if (getOverridenNow() != null) {
            /*  580 */       now = icuCalendar(getOverridenNow());
            /*  581 */     } else if (getOverridenToday() != null) {
            /*  582 */       int millisOfDay = now.get(21);
            /*  583 */       now = icuCalendar(getOverridenToday());
            /*  584 */       now.set(21, millisOfDay);
            /*      */     }
        /*  586 */     return now.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date addDays(Date date, int number)
    /*      */   {
        /*  596 */     Calendar icuDate = icuCalendar(date);
        /*  597 */     boolean wasMidnight = shouldCorrectMidnightTimeAfterDaylightSavingTimeTransition(icuDate);
        /*  598 */     icuDate.add(5, number);
        /*  599 */     if (wasMidnight) {
            /*  600 */       icuDate.set(21, 0);
            /*      */     }
        /*  602 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */   private static boolean shouldCorrectMidnightTimeAfterDaylightSavingTimeTransition(Calendar icuDate) {
        /*  606 */     if ((icuDate.get(21) > 0) && (icuDate.get(21) == icuDate.get(16)) && (isStartOfDay(icuDate))) {
            /*  607 */       return true;
            /*      */     }
        /*  609 */     return false;
        /*      */   }
    /*      */
    /*      */   private static boolean isStartOfDay(Calendar icuCalendar) {
        /*  613 */     Calendar icuCalendarForCompare = Calendar.getInstance(locale);
        /*  614 */     icuCalendarForCompare.set(icuCalendar.get(1), icuCalendar.get(2), icuCalendar.get(5));
        /*  615 */     icuCalendarForCompare.set(21, 0);
        /*      */
        /*  617 */     return isSameTimestamp(icuCalendar.getTime(), icuCalendarForCompare.getTime());
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date addWeeks(Date date, int number)
    /*      */   {
        /*  627 */     Calendar icuDate = icuCalendar(date);
        /*  628 */     boolean wasMidnight = shouldCorrectMidnightTimeAfterDaylightSavingTimeTransition(icuDate);
        /*  629 */     icuDate.add(3, number);
        /*  630 */     if (wasMidnight) {
            /*  631 */       icuDate.set(21, 0);
            /*      */     }
        /*  633 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date addMonths(Date date, int number)
    /*      */   {
        /*  644 */     Calendar icuDate = icuCalendar(date);
        /*  645 */     boolean wasMidnight = shouldCorrectMidnightTimeAfterDaylightSavingTimeTransition(icuDate);
        /*  646 */     boolean lastInMonth = isLastInMonth(icuDate);
        /*  647 */     icuDate.add(2, number);
        /*  648 */     if (lastInMonth) {
            /*  649 */       lastInMonth(icuDate);
            /*      */     }
        /*  651 */     if (wasMidnight) {
            /*  652 */       icuDate.set(21, 0);
            /*      */     }
        /*  654 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date addYears(Date date, int number)
    /*      */   {
        /*  665 */     Calendar icuDate = icuCalendar(date);
        /*  666 */     boolean wasMidnight = shouldCorrectMidnightTimeAfterDaylightSavingTimeTransition(icuDate);
        /*  667 */     boolean lastInMonth = isLastInMonth(icuDate);
        /*  668 */     icuDate.add(1, number);
        /*  669 */     if (lastInMonth) {
            /*  670 */       lastInMonth(icuDate);
            /*      */     }
        /*  672 */     if (wasMidnight) {
            /*  673 */       icuDate.set(21, 0);
            /*      */     }
        /*  675 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   private static Calendar addIcuYearsMonthsDays(Calendar icuDate, int years, int months, int days)
    /*      */   {
        /*  687 */     Calendar result = icuCalendar(icuDate.getTime());
        /*  688 */     boolean wasMidnight = shouldCorrectMidnightTimeAfterDaylightSavingTimeTransition(result);
        /*  689 */     result.add(1, years);
        /*  690 */     result.add(2, months);
        /*  691 */     if (isLastInMonth(icuDate)) {
            /*  692 */       lastInMonth(result);
            /*      */     }
        /*  694 */     result.add(5, days);
        /*  695 */     if (wasMidnight) {
            /*  696 */       icuDate.set(21, 0);
            /*      */     }
        /*  698 */     return result;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date addYearsMonthsDays(Date date, int years, int months, int days)
    /*      */   {
        /*  710 */     Calendar icuDate = icuCalendar(date);
        /*      */
        /*  712 */     return addIcuYearsMonthsDays(icuDate, years, months, days).getTime();
        /*      */   }
    /*      */
    /*      */   private static boolean isLastInMonth(Calendar date) {
        /*  716 */     int lastInMonth = date.getActualMaximum(5);
        /*  717 */     return date.get(5) == lastInMonth;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isLastInMonth(Date date)
    /*      */   {
        /*  725 */     return isLastInMonth(icuCalendar(date));
        /*      */   }
    /*      */
    /*      */   private static void lastInMonth(Calendar date) {
        /*  729 */     date.set(5, date.getActualMaximum(5));
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date dateFromString(String string)
    /*      */   {
        /*  737 */     return dateFromString(string, "dd.MM.yyyy");
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date dateFromString(String string, String pattern)
    /*      */   {
        /*      */     try
            /*      */     {
            /*  748 */       SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ROOT);
            /*  749 */       sdf.setLenient(false);
            /*  750 */       return sdf.parse(string);
            /*      */     } catch (ParseException e) {
            /*  752 */       throw new IllegalArgumentException("Could not parse date string (" + string + ") with pattern(" + pattern + ")");
            /*      */     }
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date minDate()
    /*      */   {
        /*  761 */     return MIN_DATE;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date maxDate()
    /*      */   {
        /*  769 */     return MAX_DATE;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isMaxDate(Date date)
    /*      */   {
        /*  778 */     return isSameDate(maxDate(), date);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isMinDate(Date date)
    /*      */   {
        /*  787 */     return isSameDate(minDate(), date);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Duration getDuration(Date fromDate, Date untilDate)
    /*      */   {
        /*  797 */     Calendar icuFromDate = icuCalendar(fromDate);
        /*  798 */     Calendar icuUntilDate = icuCalendar(untilDate);
        /*  799 */     int numberOfYears = numberOfYears(icuFromDate, icuUntilDate);
        /*  800 */     int numberOfMonths = numberOfMonths(icuFromDate, icuUntilDate);
        /*  801 */     if (Math.abs(numberOfMonths) > 11) {
            /*  802 */       numberOfMonths %= 12 * numberOfYears;
            /*      */     }
        /*  804 */     Calendar previousMonthBegin = addIcuYearsMonthsDays(icuFromDate, numberOfYears, numberOfMonths, 0);
        /*  805 */     int numberOfDays = numberOfDays(previousMonthBegin, icuUntilDate);
        /*  806 */     return new Duration(numberOfYears, numberOfMonths, numberOfDays);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int getDurationPart(Date fromDate, Date untilDate, DurationReturnType durationReturnType)
    /*      */   {
        /*  817 */     return getDuration(fromDate, untilDate).getDurationPart(durationReturnType);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isSameTimestamp(Date firstDate, Date secondDate)
    /*      */   {
        /*  826 */     return firstDate.compareTo(secondDate) == 0;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isSameDate(Date firstDate, Date secondDate)
    /*      */   {
        /*  838 */     if ((firstDate == null) && (secondDate == null)) return true;
        /*  839 */     if ((firstDate == null) || (secondDate == null)) return false;
        /*  840 */     Calendar icuFirst = icuCalendar(firstDate);
        /*  841 */     Calendar icuSecond = icuCalendar(secondDate);
        /*  842 */     return (icuFirst.get(1) == icuSecond.get(1)) && (icuFirst.get(2) == icuSecond.get(2)) && (icuFirst.get(5) == icuSecond.get(5));
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isBefore(Date firstDate, Date secondDate)
    /*      */   {
        /*  854 */     return firstDate.compareTo(secondDate) < 0;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isEqualOrBefore(Date firstDate, Date secondDate)
    /*      */   {
        /*  864 */     if (isSameTimestamp(firstDate, secondDate))
            /*  865 */       return true;
        /*  866 */     return isBefore(firstDate, secondDate);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isEqualOrBetween(Date theDate, Date intervalBegin, Date intervalEnd)
    /*      */   {
        /*  879 */     return (isEqualOrAfter(theDate, intervalBegin)) && ((intervalEnd == null) || (isBefore(theDate, intervalEnd)));
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isAfter(Date firstDate, Date secondDate)
    /*      */   {
        /*  890 */     return isBefore(secondDate, firstDate);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isEqualOrAfter(Date firstDate, Date secondDate)
    /*      */   {
        /*  900 */     if (isSameTimestamp(firstDate, secondDate))
            /*  901 */       return true;
        /*  902 */     return isAfter(firstDate, secondDate);
        /*      */   }
    /*      */
    /*      */   public static Date fromMillis(long millis) {
        /*  906 */     Date result = new Date();
        /*  907 */     result.setTime(millis);
        /*  908 */     return result;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static long getMillis(Date date)
    /*      */   {
        /*  917 */     return date.getTime();
        /*      */   }
    /*      */
    /*      */   public static String currentTimeMillis()
    /*      */   {
        /*  922 */     return String.valueOf(System.currentTimeMillis());
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int numberOfDays(Date fromDate, Date untilDate)
    /*      */   {
        /*  932 */     return numberOfDays(icuCalendar(fromDate), icuCalendar(untilDate));
        /*      */   }
    /*      */
    /*      */   private static int numberOfDays(Calendar icuFromDate, Calendar icuUntilDate)
    /*      */   {
        /*  937 */     Calendar tempIcuFromDate = icuCalendar(icuFromDate.getTime());
        /*  938 */     Calendar tempIcuUntilDate = icuCalendar(icuUntilDate.getTime());
        /*  939 */     boolean negative = false;
        /*      */
        /*  941 */     if (icuFromDate.compareTo(icuUntilDate) > 0) {
            /*  942 */       tempIcuFromDate = icuCalendar(icuUntilDate.getTime());
            /*  943 */       tempIcuUntilDate = icuCalendar(icuFromDate.getTime());
            /*  944 */       negative = true;
            /*      */     }
        /*      */
        /*  947 */     int days = 0;
        /*  948 */     while (tempIcuFromDate.compareTo(tempIcuUntilDate) < 0) {
            /*  949 */       if ((tempIcuFromDate.get(2) == tempIcuUntilDate.get(2)) && (tempIcuFromDate.get(1) == tempIcuUntilDate.get(1)))
                /*      */       {
                /*  951 */         days += tempIcuUntilDate.get(5) - tempIcuFromDate.get(5);
                /*  952 */         break; }
            /*  953 */       if (tempIcuFromDate.get(5) == 1) {
                /*  954 */         if ((tempIcuFromDate.get(1) < tempIcuUntilDate.get(1)) && (tempIcuFromDate.get(2) == 0)) {
                    /*  955 */           days += tempIcuFromDate.getActualMaximum(6);
                    /*  956 */           tempIcuFromDate.add(1, 1);
                    /*      */         } else {
                    /*  958 */           days += tempIcuFromDate.getActualMaximum(5);
                    /*  959 */           tempIcuFromDate.add(2, 1);
                    /*      */         }
                /*      */       } else {
                /*  962 */         days += 1 + tempIcuFromDate.getActualMaximum(5) - tempIcuFromDate.get(5);
                /*  963 */         tempIcuFromDate.set(5, 1);
                /*  964 */         tempIcuFromDate.add(2, 1);
                /*      */       }
            /*      */     }
        /*      */
        /*  968 */     return negative ? -1 * days : days;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date maxDate(Date firstDate, Date secondDate)
    /*      */   {
        /*  978 */     return maximum(new Date[] { firstDate, secondDate });
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date maximum(Date... dates)
    /*      */   {
        /*  988 */     Date result = dates[0];
        /*  989 */     for (Date date : dates) {
            /*  990 */       if (date.compareTo(result) > 0) result = date;
            /*      */     }
        /*  992 */     return result;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date minDate(Date firstDate, Date secondDate)
    /*      */   {
        /* 1002 */     return minimum(new Date[] { firstDate, secondDate });
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date minimum(Date... dates)
    /*      */   {
        /* 1012 */     Date result = dates[0];
        /* 1013 */     for (Date date : dates) {
            /* 1014 */       if (date.compareTo(result) < 0) result = date;
            /*      */     }
        /* 1016 */     return result;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int numberOfDaysInMonth(int year, int month)
    /*      */   {
        /* 1026 */     return icuGregorianCalendar(year, month, 1, 0, 0, 0).getActualMaximum(5);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int numberOfDaysInMonthCurrentChronology(int year, int month)
    /*      */   {
        /* 1036 */     return icuCalendar(year, month, 1, 0, 0, 0).getActualMaximum(5);
        /*      */   }
    /*      */
    /*      */   public static Date vgerDateFromString(String string)
    /*      */   {
        /* 1041 */     Date date = dateFromString(string);
        /* 1042 */     Date vgerDate = vgerDateFromDate(date);
        /* 1043 */     return vgerDate;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date vgerDateFromDate(Date date)
    /*      */   {
        /* 1052 */     Calendar icuDate = icuGregorianCalendar(date);
        /* 1053 */     return newDate(icuDate.get(1), icuDate.get(2) + 1, icuDate.get(5), 12, 0);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static List<Date> getYearlyDates(Date begin, int numberOfYears)
    /*      */   {
        /* 1063 */     List<Date> result = new ArrayList();
        /* 1064 */     for (int counter = 0; counter < numberOfYears; counter++) {
            /* 1065 */       result.add(addYears(begin, counter));
            /*      */     }
        /* 1067 */     return result;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static double inMonths(Date intervalBegin, Date intervalEnd)
    /*      */   {
        /* 1077 */     int fullMotnhs = numberOfMonths(intervalBegin, intervalEnd);
        /* 1078 */     Date beginLastMonth = addMonths(intervalBegin, fullMotnhs);
        /* 1079 */     Date endLastMonth = addMonths(intervalBegin, fullMotnhs + 1);
        /* 1080 */     double innerDays = numberOfDays(beginLastMonth, intervalEnd);
        /* 1081 */     double outerDays = numberOfDays(beginLastMonth, endLastMonth);
        /* 1082 */     double partialMonth = 0.0D;
        /* 1083 */     if (innerDays > 0.0D) partialMonth = innerDays / outerDays;
        /* 1084 */     return fullMotnhs + partialMonth;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date newYearsDay(int year)
    /*      */   {
        /* 1093 */     return newDate(year, 1, 1);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date newYearsDayCurrentChronology(int year)
    /*      */   {
        /* 1102 */     Calendar result = icuCalendar(year, 1, 1, 0, 0, 0);
        /* 1103 */     return result.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date newYearsEve(int year)
    /*      */   {
        /* 1112 */     return newDate(year, 12, 31);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date newYearsEveCurrentChronology(int year)
    /*      */   {
        /* 1121 */     Calendar result = icuCalendar(year, 12, 1, 0, 0, 0);
        /* 1122 */     result.set(2, result.getActualMaximum(2));
        /* 1123 */     result.set(5, result.getActualMaximum(5));
        /* 1124 */     return result.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date firstOf(int year, int month)
    /*      */   {
        /* 1134 */     Calendar icuGC = icuGregorianCalendar(year, month, 1, 0, 0, 0);
        /* 1135 */     icuGC.set(5, icuGC.getActualMinimum(5));
        /* 1136 */     return icuGC.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date lastOf(int year, int month)
    /*      */   {
        /* 1146 */     Calendar icuGC = icuGregorianCalendar(year, month, 1, 0, 0, 0);
        /* 1147 */     icuGC.set(5, icuGC.getActualMaximum(5));
        /* 1148 */     return icuGC.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date firstOfInCurrentChronology(int year, int month)
    /*      */   {
        /* 1158 */     Calendar icuDate = icuCalendar(year, month, 1, 0, 0, 0);
        /* 1159 */     icuDate.set(5, icuDate.getActualMinimum(5));
        /* 1160 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date lastOfInCurrentChronology(int year, int month)
    /*      */   {
        /* 1170 */     Calendar icuDate = icuCalendar(year, month, 1, 0, 0, 0);
        /* 1171 */     icuDate.set(5, icuDate.getActualMaximum(5));
        /* 1172 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static double elapsedDurationInYears(Date startDate, Date date1, Date date2)
    /*      */   {
        /* 1184 */     Date previousAnniversary = previousOrSameAnniversaryDate(date1, startDate);
        /* 1185 */     double durationInYears1 = elapsedDurationInYears(previousAnniversary, date1);
        /* 1186 */     double durationInYears2 = elapsedDurationInYears(previousAnniversary, date2);
        /* 1187 */     return durationInYears2 - durationInYears1;
        /*      */   }
    /*      */
    /*      */   private static double elapsedDurationInYears(Date date1, Date date2) {
        /* 1191 */     Duration duration = getDuration(date1, date2);
        /* 1192 */     int years = duration.getNumberOfYears();
        /* 1193 */     int months = duration.getNumberOfMonths();
        /* 1194 */     int days = duration.getNumberOfDays();
        /* 1195 */     Calendar icuDate1 = icuCalendar(date1);
        /* 1196 */     Calendar previousMonthStart = addIcuYearsMonthsDays(icuDate1, years, months, 0);
        /* 1197 */     double daysInMonth = previousMonthStart.getActualMaximum(5);
        /* 1198 */     return years + 1.0D * months / 12.0D + 1.0D * days / daysInMonth / 12.0D;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date previousOrSameAnniversaryDate(Date date, Date initialAnniversary)
    /*      */   {
        /* 1208 */     Calendar icuDate = icuCalendar(date);
        /* 1209 */     Calendar icuInitialAnniversary = icuCalendar(initialAnniversary);
        /* 1210 */     if (isAnniversary(icuDate, icuInitialAnniversary)) return date;
        /* 1211 */     return previousAnniversaryDate(date, initialAnniversary);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date previousAnniversaryDate(Date date, Date initialAnniversary)
    /*      */   {
        /* 1220 */     Calendar icuDate = icuCalendar(date);
        /* 1221 */     Calendar icuInitialAnniversary = icuCalendar(initialAnniversary);
        /* 1222 */     return previousAnniversaryDate(icuDate, icuInitialAnniversary);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date nextOrSameAnniversaryDate(Date date, Date initialAnniversary)
    /*      */   {
        /* 1232 */     Calendar icuDate = icuCalendar(date);
        /* 1233 */     Calendar icuInitialAnniversary = icuCalendar(initialAnniversary);
        /* 1234 */     if (isAnniversary(icuDate, icuInitialAnniversary)) return date;
        /* 1235 */     return nextAnniversaryDate(icuDate, icuInitialAnniversary);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Date nextAnniversaryDate(Date date, Date initialAnniversary)
    /*      */   {
        /* 1245 */     Calendar icuDate = icuCalendar(date);
        /* 1246 */     Calendar icuInitialAnniversary = icuCalendar(initialAnniversary);
        /* 1247 */     return nextAnniversaryDate(icuDate, icuInitialAnniversary);
        /*      */   }
    /*      */
    /*      */   private static Date previousAnniversaryDate(Calendar icuDate, Calendar icuInitialAnniversary) {
        /* 1251 */     return getNextOrPreviousAnniversaryDate(icuDate, icuInitialAnniversary, true);
        /*      */   }
    /*      */
    /*      */   private static Date nextAnniversaryDate(Calendar icuDate, Calendar icuInitialAnniversary) {
        /* 1255 */     return getNextOrPreviousAnniversaryDate(icuDate, icuInitialAnniversary, false);
        /*      */   }
    /*      */
    /*      */   private static Date getNextOrPreviousAnniversaryDate(Calendar icuDate, Calendar icuInitialAnniversary, boolean previous)
    /*      */   {
        /* 1260 */     Calendar result = icuCalendar(icuInitialAnniversary.getTime());
        /*      */
        /* 1262 */     int nextAnniversaryMonth = icuInitialAnniversary.get(2);
        /* 1263 */     int nextAnniversaryYear = icuDate.get(1);
        /* 1264 */     int nextAnniversaryDay = icuInitialAnniversary.get(5);
        /*      */
        /* 1266 */     if (previous) {
            /* 1267 */       if ((icuDate.get(2) < icuInitialAnniversary.get(2)) || (isEqualOrBeforeInMonth(icuDate, icuInitialAnniversary))) {
                /* 1268 */         nextAnniversaryYear--;
                /*      */       }
            /*      */     }
        /* 1271 */     else if ((icuDate.get(2) > icuInitialAnniversary.get(2)) || (isEqualOrAfterInMonth(icuDate, icuInitialAnniversary))) {
            /* 1272 */       nextAnniversaryYear++;
            /*      */     }
        /*      */
        /*      */
        /* 1276 */     result.set(nextAnniversaryYear, nextAnniversaryMonth, 0);
        /*      */
        /* 1278 */     if (isLastInMonth(icuInitialAnniversary)) {
            /* 1279 */       result.set(5, result.getActualMaximum(5));
            /*      */     } else {
            /* 1281 */       result.set(5, nextAnniversaryDay);
            /*      */     }
        /*      */
        /* 1284 */     return result.getTime();
        /*      */   }
    /*      */
    /*      */   private static boolean isEqualOrAfterInMonth(Calendar icuFirstDate, Calendar icuSecondDate) {
        /* 1288 */     if (icuFirstDate.get(2) != icuSecondDate.get(2)) {
            /* 1289 */       return false;
            /*      */     }
        /* 1291 */     if ((isSameDayOfMonth(icuFirstDate, icuSecondDate)) || (icuFirstDate.get(5) >= icuSecondDate.get(5))) {
            /* 1292 */       return true;
            /*      */     }
        /* 1294 */     return false;
        /*      */   }
    /*      */
    /*      */   private static boolean isEqualOrBeforeInMonth(Calendar icuFirstDate, Calendar icuSecondDate) {
        /* 1298 */     if (icuFirstDate.get(2) != icuSecondDate.get(2)) {
            /* 1299 */       return false;
            /*      */     }
        /* 1301 */     if ((isSameDayOfMonth(icuFirstDate, icuSecondDate)) || (icuFirstDate.get(5) <= icuSecondDate.get(5))) {
            /* 1302 */       return true;
            /*      */     }
        /* 1304 */     return false;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isAnniversary(Date date, Date anniversaryDate)
    /*      */   {
        /* 1314 */     Calendar icuDate = icuCalendar(date);
        /* 1315 */     Calendar icuAnniversaryDate = icuCalendar(anniversaryDate);
        /*      */
        /* 1317 */     return isAnniversary(icuDate, icuAnniversaryDate);
        /*      */   }
    /*      */
    /*      */   private static boolean isAnniversary(Calendar icuDate, Calendar icuAnniversaryDate) {
        /* 1321 */     if (icuDate.get(2) != icuAnniversaryDate.get(2)) { return false;
            /*      */     }
        /* 1323 */     return isSameDayOfMonth(icuDate, icuAnniversaryDate);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static boolean isSameDayOfMonth(Date date, Date referenceDate)
    /*      */   {
        /* 1337 */     Calendar icuReferenceDate = icuCalendar(referenceDate);
        /* 1338 */     Calendar icuDate = icuCalendar(date);
        /*      */
        /* 1340 */     return isSameDayOfMonth(icuReferenceDate, icuDate);
        /*      */   }
    /*      */
    /*      */   private static boolean isSameDayOfMonth(Calendar icuReferenceDate, Calendar icuDate) {
        /* 1344 */     if (isLastInMonth(icuReferenceDate)) {
            /* 1345 */       return isLastInMonth(icuDate);
            /*      */     }
        /*      */
        /* 1348 */     int dayIndexDate = icuDate.get(5);
        /* 1349 */     int dayIndexReference = icuReferenceDate.get(5);
        /*      */
        /* 1351 */     if (icuDate.getActualMaximum(5) < dayIndexReference) {
            /* 1352 */       return isLastInMonth(icuDate);
            /*      */     }
        /*      */
        /* 1355 */     return dayIndexDate == dayIndexReference;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static long getMillisFromTo(Date startTime, Date endTime)
    /*      */   {
        /* 1364 */     return endTime.getTime() - startTime.getTime();
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Calendar convertFromGregorianToPersianDate(Date date)
    /*      */   {
        /* 1372 */     return convertFromGregorianToPersianDate(date, "fa_IR");
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static Calendar convertFromGregorianToPersianDateWithWesternNumbers(Date date)
    /*      */   {
        /* 1380 */     return convertFromGregorianToPersianDate(date, "en_UK");
        /*      */   }
    /*      */
    /*      */   private static Calendar convertFromGregorianToPersianDate(Date date, String localeString) {
        /* 1384 */     ULocale locale = new ULocale(localeString + "@calendar=persian");
        /* 1385 */     Calendar persianCalendar = Calendar.getInstance(locale);
        /* 1386 */     persianCalendar.setTime(date);
        /* 1387 */     return persianCalendar;
        /*      */   }
    /*      */
    /*      */   private static Calendar icuCalendar(Date date) {
        /* 1391 */     if (date == null) throw new NullPointerException();
        /* 1392 */     Calendar icuDate = Calendar.getInstance(locale);
        /* 1393 */     icuDate.setTime(date);
        /* 1394 */     return icuDate;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   private static Calendar icuCalendar(int year, int month, int day, int hour, int minute, int second)
    /*      */   {
        /* 1405 */     Calendar icuDate = Calendar.getInstance(locale);
        /* 1406 */     icuSet(icuDate, year, month, day, hour, minute, second);
        /* 1407 */     return icuDate;
        /*      */   }
    /*      */
    /*      */   private static Calendar icuGregorianCalendar(Date date) {
        /* 1411 */     if (date == null) throw new NullPointerException();
        /* 1412 */     Calendar icuDate = GregorianCalendar.getInstance(Locale.ROOT);
        /* 1413 */     icuDate.setTime(date);
        /* 1414 */     return icuDate;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   private static Calendar icuGregorianCalendar(int year, int month, int day, int hour, int minute, int second)
    /*      */   {
        /* 1428 */     Calendar icuDate = GregorianCalendar.getInstance(Locale.ROOT);
        /* 1429 */     icuSet(icuDate, year, month, day, hour, minute, second);
        /* 1430 */     return icuDate;
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   private static void icuSet(Calendar icuDate, int year, int month, int day, int hour, int minute, int second)
    /*      */   {
        /* 1444 */     icuDate.set(1, year);
        /* 1445 */     icuSet(icuDate, 2, month - 1, "Month");
        /* 1446 */     icuSet(icuDate, 5, day, "Day");
        /* 1447 */     icuSet(icuDate, 11, hour, "Hour");
        /* 1448 */     icuSet(icuDate, 12, minute, "Minute");
        /* 1449 */     icuSet(icuDate, 13, second, "Second");
        /* 1450 */     icuSet(icuDate, 14, 0, "Milliseconds");
        /*      */   }
    /*      */
    /*      */   private static void icuSet(Calendar icuDate, int field, int value, String fieldName) {
        /* 1454 */     if ((value < icuDate.getActualMinimum(field)) || (value > icuDate.getActualMaximum(field)))
            /* 1455 */       throw new IllegalArgumentException(fieldName + " number out of bounds");
        /* 1456 */     icuDate.set(field, value);
        /*      */   }
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */   public static int getWeekInYear(Date date)
    /*      */   {
        /* 1465 */     Calendar icuDate = icuCalendar(date);
        /* 1466 */     return icuDate.get(3);
        /*      */   }
    /*      */
    /*      */   public static Date nextNewYearsDay(Date date) {
        /* 1470 */     Calendar icuDate = icuCalendar(date);
        /*      */
        /* 1472 */     int year = icuDate.get(1);
        /*      */
        /* 1474 */     icuDate.set(5, 1);
        /* 1475 */     icuDate.set(2, 0);
        /* 1476 */     icuDate.set(1, year + 1);
        /*      */
        /* 1478 */     return icuDate.getTime();
        /*      */   }
    /*      */
    /*      */   public static Date previousNewYearsDay(Date date) {
        /* 1482 */     Calendar icuDate = icuCalendar(date);
        /*      */
        /* 1484 */     int year = icuDate.get(1);
        /*      */
        /* 1486 */     icuDate.set(5, 1);
        /* 1487 */     icuDate.set(2, 0);
        /* 1488 */     icuDate.set(1, year);
        /*      */
        /* 1490 */     return icuDate.getTime();
        /*      */   }
    /*      */ }

/* Location:           C:\Vger\Maven\Repository\de\novum\vger\technical\technical_frames\6.48.17\technical_frames-6.48.17.jar
 * Qualified Name:     de.novum.vger.technical.technical_frames.date.DateUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */