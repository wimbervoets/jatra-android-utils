package be.jatra.android.util.lang;

import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


//http://www.michaelminella.com/testing/how-to-mock-static-methods.html
//https://github.com/jayway/powermock/wiki/GettingStarted
//http://stackoverflow.com/questions/21105403/mocking-static-methods-with-mockito

@RunWith(PowerMockRunner.class)
@PrepareForTest(Log.class)
public class DateUtilsTest {

    @Test
    public void formatCurrentDate_OK() throws Exception {
        mockStatic(Log.class);
//        Mockito.when(Log.d(anyString(), anyString())).thenReturn(anyInt());
//        PowerMockito.doNothing().when(Log.class, "d", anyString(), anyString());
//        PowerMockito.when(Log.class, "d", eq(DateUtils.class.getSimpleName()), anyString()).thenReturn(anyInt());
//        PowerMockito.when(Log.class, "d", eq(DateUtils.class.getSimpleName()), anyString()).thenReturn(anyInt());

//        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//        PowerMockito.doNothing().when(
//                StaticResource.class, "getResource", captor.capture());

        String actualDate = DateUtils.formatCurrentDate();

//        PowerMockito.verifyStatic(Mockito.times(2));
        assertNotNull(actualDate);
    }

    @Test
    public void formatDate_OK() {
        mockStatic(Log.class);
        final Date date = new Date();
        final String actualFormattedDate = DateUtils.formatDate(date);
        System.out.println("formatDate_OK-actualFormattedDate=" + actualFormattedDate);//4/01/16 13:26
//        LOGGER.debug( "formatDate(date=" + date + ")");
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        final String formattedDate = sdf.format(date);
//        LOGGER.debug( "formattedDate=" + formattedDate);
//        return formattedDate;
    }

    @Test
    public void formatDate_intintint_OK() {
        mockStatic(Log.class);
        final Date date = new Date();
        final String actualFormattedDate = DateUtils.formatDate(date);
        System.out.println("formatDate_intintint_OK-actualFormattedDate=" + actualFormattedDate);//4/01/16 13:26
        //final int year, final int monthOfYear, final int dayOfMonth
//        final String date = "" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
//        LOGGER.debug( "date=" + date);
//        return date;
    }

    @Test
    public void formatTime_intintint_OK() {
        mockStatic(Log.class);
        final Date time = new Date();
        final String actualFormattedTime = DateUtils.formatTime(15, 13, 29);
        final String expectedFormattedTime = "15:13:29";
        assertThat("time not equal", actualFormattedTime, equalTo(expectedFormattedTime));
    }

    @Test
    public void formatDate_DateString_OK() {
        mockStatic(Log.class);
        final Date date = new Date();
        final String actualFormattedDate = DateUtils.formatDate(date, "dd MMM yyyy");
        System.out.println("formatDate_DateString_OK-actualFormattedDate=" + actualFormattedDate);//04 jan 2016
        //final Date date, final String pattern
//        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//        return sdf.format(date);
    }

    @Test
    public void parseDate_String_OK() {
        mockStatic(Log.class);
        final String date = "04/01/2016";
        final Date actualParsedDate = DateUtils.parseDate(date);
        System.out.println("parseDate_String_OK-actualParsedDate=" + actualParsedDate);//null
        //final String dateAsString
//        if (null == dateAsString) {
//            return null;
//        }

//        Date date = null;
//        try {
//            date = new SimpleDateFormat().parse(dateAsString);
//        } catch (final ParseException e) {
//            LOGGER.error( "The given date could not be parsed.");
//        }
//        return date;
    }

    @Test
    public void parseDate_StringString_OK() {
        mockStatic(Log.class);
        final String date = "4 January 2016";
        final Date actualParsedDate = DateUtils.parseDate(date, "d MMMM yyyy");
        System.out.println("parseDate_StringString_OK-actualParsedDate=" + actualParsedDate);//null
    }

    @Test
    public void parseDate_StringString_date_null() {
        mockStatic(Log.class);
        final String date = null;
        final Date actualParsedDate = DateUtils.parseDate(null, "d MMMM yyyy");
        assertNull(actualParsedDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDate_StringString_pattern_null() {
        mockStatic(Log.class);
        final String date = "4 January 2016";
        DateUtils.parseDate(date, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDate_StringString_pattern_empty() {
        mockStatic(Log.class);
        final String date = "4 January 2016";
        DateUtils.parseDate(date, "");
    }

    @Test
    public void getCurrentDate_OK() {
        mockStatic(Log.class);
        final Date actualDate = DateUtils.getCurrentDate();
        assertNotNull(actualDate);
    }

    @Test
    public void mergeDateAndTime_DateDate_OK() {
        mockStatic(Log.class);
        final Date date = getDate();
        final Date time = new Date();
        Date actualDate = DateUtils.mergeDateAndTime(date, time);
        System.out.println("mergeDateAndTime_DateDate_OK-actualDate=" + actualDate);//Mon Jan 04 13:26:29 CET 2016

        //final Date date, final Date time
//        LOGGER.debug( "mergeDateAndTime(date=" + date + ", time=" + time + ")");
//        Calendar cDate = new GregorianCalendar();
//        if (date != null) {
//            cDate.setTime(date);
//        }
//
//        Calendar cTime = new GregorianCalendar();
//        if (time != null) {
//            cTime.setTime(time);
//        }
//
//        Calendar mergedDateAndTime = new GregorianCalendar();
//        mergedDateAndTime.set(Calendar.YEAR, cDate.get(Calendar.YEAR));
//        mergedDateAndTime.set(Calendar.MONTH, cDate.get(Calendar.MONTH));
//        mergedDateAndTime.set(Calendar.DATE, cDate.get(Calendar.DATE));
//        mergedDateAndTime.set(Calendar.HOUR, cTime.get(Calendar.HOUR));
//        mergedDateAndTime.set(Calendar.MINUTE, cTime.get(Calendar.MINUTE));
//        mergedDateAndTime.set(Calendar.SECOND, cTime.get(Calendar.SECOND));
//        mergedDateAndTime.set(Calendar.AM_PM, cTime.get(Calendar.AM_PM));
//        return mergedDateAndTime.getTime();
    }


    private Date getDate() {
        return new Date();
    }

    private Date getTime() {
        return new Date();
    }
}
