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

  /**
   * Generate and return a new 36 digit random UUID string.
   *
   * @return new 36 digit random UUID string.
   */
  public static String randString() {
    return UUID.randomUUID().toString();
  }

  /**
   * Generate and return a new random integer value.
   *
   * @return new random integer value.
   */
  public static int randInt() {
    return rand.nextInt();
  }

  /**
   * Generate and return a new random integer value between the given
   * <code>min</code> and <code>max</code> values.
   *
   * @param min lower bound for the random int value
   * @param max upper bound for the random int value
   *
   * @return new random integer value between <code>min</code> and
   * <code>max</code>
   */
  public static int randInt(final int min, final int max) {
    return min + rand.nextInt() * (max - min);
  }

  /**
   * Generate and return a new random integer greater than or equal to the
   * given <code>minimum</code> value.
   *
   * @param minimum lower bound for the random int value
   *
   * @return a new random integer greater than or equal to <code>minimum</code>
   */
  public static int randMinInt(final int minimum) {
    return randInt(minimum, Integer.MAX_VALUE);
  }

  /**
   * Generate and return a new random integer less than the given
   * <code>maximum</code> value.
   *
   * @param maximum upper bound for the random int value
   *
   * @return a new random integer less than <code>maximum</code>
   */
  public static int randMaxInt(final int maximum) {
    return randInt(Integer.MIN_VALUE, maximum);
  }

  /**
   * Generate and return a new random long value.
   *
   * @return new random long value.
   */
  public static long randLong() {
    return rand.nextLong();
  }

  /**
   * Generate and return a new random long value between the given
   * <code>min</code> and <code>max</code> values.
   *
   * @param min lower bound for the random long value
   * @param max upper bound for the random long value
   *
   * @return new random long value between <code>min</code> and <code>max</code>
   */
  public static long randLong(final long min, final long max) {
    return min + rand.nextLong() * (max - min);
  }

  /**
   * Generate and return a new random long greater than or equal to the given
   * <code>minimum</code> value.
   *
   * @param minimum lower bound for the random long value
   *
   * @return a new random long greater than or equal to <code>minimum</code>
   */
  public static long randMinLong(final long minimum) {
    return randLong(minimum, Long.MAX_VALUE);
  }

  /**
   * Generate and return a new random long less than the given
   * <code>maximum</code> value.
   *
   * @param maximum upper bound for the random long value
   *
   * @return a new random long less than <code>maximum</code>
   */
  public static long randMaxLong(final long maximum) {
    return randLong(Long.MIN_VALUE, maximum);
  }

  /**
   * Generates a new <code>OffsetDateTime</code> instance from a random long
   * value.
   *
   * @return a new random <code>OffsetDateTime</code> value
   */
  public static OffsetDateTime randOffsetDateTime() {
    return OffsetDateTime.ofInstant(Instant.ofEpochMilli(randLong()), ZoneId.systemDefault());
  }

  /**
   * Generates a new <code>LocalDateTime</code> instance from a random long
   * value.
   *
   * @return a new random <code>LocalDateTime</code> value
   */
  public static LocalDateTime randLocalDateTime() {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(randLong()), ZoneId.systemDefault());
  }

  /**
   * Generates a new <code>Date</code> instance from a random long value.
   *
   * @return a new random <code>Date</code> value
   */
  public static Date randDate() {
    return Date.from(Instant.ofEpochMilli(randLong()));
  }
}
