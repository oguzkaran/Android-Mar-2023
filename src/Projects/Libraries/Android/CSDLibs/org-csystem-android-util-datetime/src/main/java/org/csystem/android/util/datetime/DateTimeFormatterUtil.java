package org.csystem.android.util.datetime;

import java.time.format.DateTimeFormatter;

public final class DateTimeFormatterUtil {
    private DateTimeFormatterUtil()
    {}

    public static final DateTimeFormatter DATE_TIME_FORMATTER_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //...
}
