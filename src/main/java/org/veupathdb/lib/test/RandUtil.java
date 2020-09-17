package org.veupathdb.lib.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandUtil
{
  private static final Random rand = new Random();

  public static String randString() {
    return UUID.randomUUID().toString();
  }

  public static int randInt() {
    return rand.nextInt();
  }

  public static int randInt(final int min, final int max) {
    return min + rand.nextInt() * (max - min);
  }

  public static int randMinInt(final int minimum) {
    return randInt(minimum, Integer.MAX_VALUE);
  }

  public static int randMaxInt(final int maximum) {
    return randInt(Integer.MIN_VALUE, maximum);
  }

  public static long randLong() {
    return rand.nextLong();
  }

  public static long randLong(final long min, final long max) {
    return min + rand.nextLong() * (max - min);
  }

  public static long randMinLong(final long minimum) {
    return randLong(minimum, Long.MAX_VALUE);
  }

  public static long randMaxLong(final long maximum) {
    return randLong(Long.MIN_VALUE, maximum);
  }

  public static OffsetDateTime randOffsetDateTime() {
    return OffsetDateTime.ofInstant(Instant.ofEpochMilli(randLong()), ZoneId.systemDefault());
  }

  public static LocalDateTime randLocalDateTime() {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(randLong()), ZoneId.systemDefault());
  }

  public static Date randDate() {
    return Date.from(Instant.ofEpochMilli(randLong()));
  }
}
