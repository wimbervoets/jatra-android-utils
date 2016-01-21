package be.jatra.android.util.lang;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressLint("SimpleDateFormat")
public final class DateUtils {

    private static final String TAG = DateUtils.class.getSimpleName();

    public static String formatCurrentDate() {
        return formatDate(getCurrentDate());
    }

    public static String formatDate(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        final String formattedDate = sdf.format(date);
        Log.d(TAG, "formatDate(date) - formattedDate=" + formattedDate);
        return formattedDate;
    }

    public static String formatDate(final int year, final int monthOfYear, final int dayOfMonth) {
        final String date = "" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        Log.d(TAG, "formatDate(int, int, int) - date=" + date);
        return date;
    }

    public static String formatTime(final int hourOfDay, final int minute, final int second) {
        final String time = "" + hourOfDay + ":" +
                ((minute <= 9) ? "0" + minute : minute) + ":" +
                ((second <= 9) ? "0" + second : second);
        Log.d(TAG, "formatTime(int, int, int) - time=" + time);
        return time;
    }

    public static String formatDate(final Date date, final String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date parseDate(final String dateAsString) {
        Log.d(TAG, "parseDate(dateAsString=" + dateAsString + ")");
        if (null == dateAsString) {
            return null;
        }

        Date date = null;
        try {
            date = new SimpleDateFormat().parse(dateAsString);
        } catch (final ParseException e) {
            Log.e(TAG, "The given date could not be parsed.");
        }
        return date;
    }

    public static Date parseDate(final String dateAsString, final String pattern) {
        Log.d(TAG, "parseDate(dateAsString=" + dateAsString + ", pattern=" + pattern + ")");
        if (null == dateAsString) {
            return null;
        }
        if ((null == pattern) || "".equals(pattern)) {
            throw new IllegalArgumentException("The 'pattern' parameter cannot be empty.");
        }

        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(dateAsString);
        } catch (final ParseException e) {
            Log.e(TAG, "The given date could not be parsed.");
        }
        return date;
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Date mergeDateAndTime(final Date date, final Date time) {
        Log.d(TAG, "mergeDateAndTime(date=" + date + ", time=" + time + ")");
        Calendar cDate = new GregorianCalendar();
        if (date != null) {
            cDate.setTime(date);
        }

        Calendar cTime = new GregorianCalendar();
        if (time != null) {
            cTime.setTime(time);
        }

        Calendar mergedDateAndTime = new GregorianCalendar();
        mergedDateAndTime.set(Calendar.YEAR, cDate.get(Calendar.YEAR));
        mergedDateAndTime.set(Calendar.MONTH, cDate.get(Calendar.MONTH));
        mergedDateAndTime.set(Calendar.DATE, cDate.get(Calendar.DATE));
        mergedDateAndTime.set(Calendar.HOUR, cTime.get(Calendar.HOUR));
        mergedDateAndTime.set(Calendar.MINUTE, cTime.get(Calendar.MINUTE));
        mergedDateAndTime.set(Calendar.SECOND, cTime.get(Calendar.SECOND));
        mergedDateAndTime.set(Calendar.AM_PM, cTime.get(Calendar.AM_PM));
        return mergedDateAndTime.getTime();
    }
}
