package com.example.kzh.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValueConstants {
    public static final ZoneId ZONE_ID = ZoneId.of("UTC+00:00");
}
