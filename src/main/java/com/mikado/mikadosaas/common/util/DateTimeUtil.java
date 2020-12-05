package com.mikado.mikadosaas.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;

public class DateTimeUtil {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DateTimeUtil.class);

	/**
	 * for get date in yyyy-MM-dd format
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateFromDateTime(Date date) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(formatter.format(date));
		} catch (ParseException e) {
			LOGGER.error("error while parsing the date", e);
		}
		return date;
	}

	public static Time getTimeFromDateTime(Date date) {
		return new Time(date.getTime());
	}

	public static Time longMinuteToTime(long overTimeApproved) {
		return Time.valueOf(overTimeApproved / 60 + ":" + overTimeApproved % 60
				+ ":00");
	}

	public static long getTimeDifference(Time startTime, Time endTime) {
		if (startTime == null || endTime == null) {
			return 0;
		}
		LocalTime from = startTime.toLocalTime();
		LocalTime to = endTime.toLocalTime();
		Duration duration = Duration.between(from, to);
		return duration.getSeconds() / 60;
	}

	// public static Time addTime(Time time1, Time time2) {
	// LocalTime localtime = time1.toLocalTime();
	// localtime = localtime.plus(time2);
	// return Time.valueOf(localtime);
	// }
}
