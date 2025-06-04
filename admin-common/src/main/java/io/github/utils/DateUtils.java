package io.github.utils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {


    /**
     * 获取未来某一时刻的 UTC 时间
     */
    public static String getFutureTimeInUtc(Long seconds) {
        // 获取当前时间戳（以秒为单位）
        long now = Instant.now().getEpochSecond();
        // 计算过期时间的时间戳
        long expirationTime = now + seconds;
        // 将时间戳转换为Instant对象，并格式化为ISO8601格式
        Instant instant = Instant.ofEpochSecond(expirationTime);
        // 定义时区为UTC
        ZoneOffset zone = ZoneOffset.UTC;
        // 将 Instant 转换为 ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        // 定义日期时间格式，例如2023-12-03T13:00:00.000Z
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        // 格式化日期时间
        return zonedDateTime.format(formatter);
    }
}
