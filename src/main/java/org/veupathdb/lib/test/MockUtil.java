package org.veupathdb.lib.test;

import java.util.Arrays;

import org.mockito.Mockito;

public class MockUtil
{
  private static final String DEFAULT_INSTANCE_FIELD = "instance";

  /**
   * Sets the internal field "instance" for a singleton class to a
   * mocked instance.
   *
   * @param type Singleton class to mock
   * @param <T>  Type of the singleton class
   *
   * @return the mock instance of the given singleton type.
   *
   * @throws Exception if an error occurs while attempting to mock or
   *                   reflectively set the internal instance.
   */
  public static < T > T mockSingleton(final Class< T > type) throws Exception {
    return mockSingleton(type, DEFAULT_INSTANCE_FIELD);
  }

  /**
   * Sets the internal field "<code>field</code>" field for a singleton class to a
   * mocked instance.
   *
   * @param type  Singleton class to mock
   * @param field name of the internal instance field in the singleton class.
   * @param <T>   Type of the singleton class
   *
   * @return the mock instance of the given singleton type.
   *
   * @throws Exception if an error occurs while attempting to mock or
   *                   reflectively set the internal instance.
   */
  public static < T > T mockSingleton(final Class< T > type, final String field) throws Exception {
    var out = Mockito.mock(type);

    var ref = type.getDeclaredField(field);
    ref.setAccessible(true);
    ref.set(null, out);

    return out;
  }

  /**
   * Resets the internal field "instance" to a new instance of the actual,
   * non-mock of the given class.
   * <p>
   * This method should only be used on singleton classes with no-arg
   * constructors and an internal instance field named "instance".
   *
   * @param type type of the singleton class to reset.
   *
   * @throws Exception if an error occurs while attempting to construct or
   *                   reflectively set the new singleton instance.
   */
  public static void resetSingleton(final Class< ? > type) throws Exception {
    resetSingleton(type, DEFAULT_INSTANCE_FIELD, new Object[0]);
  }

  /**
   * Resets the internal field "instance" to a new instance of the actual,
   * non-mock of the given class.
   * <p>
   * This method should only be used on singleton classes with an internal
   * instance field named "instance".
   *
   * @param type   type of the singleton class to reset.
   * @param params constructor params to use when creating a new singleton
   *               instance.
   *
   * @throws Exception if an error occurs while attempting to construct or
   *                   reflectively set the new singleton instance.
   */
  public static void resetSingleton(final Class< ? > type, final Object... params)
  throws Exception {
    resetSingleton(type, DEFAULT_INSTANCE_FIELD, params);
  }

  /**
   * Resets the internal field "<code>field</code>" to a new instance of the
   * actual, non-mock of the given class.
   * <p>
   * This method should only be used on singleton classes with a no-arg
   * constructor.
   *
   * @param type  type of the singleton class to reset.
   * @param field name of the internal instance field for the class.
   *
   * @throws Exception if an error occurs while attempting to construct or
   *                   reflectively set the new singleton instance.
   */
  public static void resetSingleton(final Class< ? > type, final String field) throws Exception {
    resetSingleton(type, field, new Object[0]);
  }

  /**
   * Resets the internal field "<code>field</code>" to a new instance of the
   * actual, non-mock of the given class.
   *
   * @param type   type of the singleton class to reset.
   * @param field  name of the internal instance field for the class.
   * @param params constructor arguments to use when creating a new instance of
   *               the singleton class.
   *
   * @throws Exception if an error occurs while attempting to construct or
   *                   reflectively set the new singleton instance.
   */
  public static void resetSingleton(
    final Class< ? > type,
    final String field,
    final Object... params
  ) throws Exception {
    var paramTypes = Arrays.stream(params).map(Object::getClass).toArray(Class[]::new);

    var inst = type.getDeclaredConstructor(paramTypes).newInstance(params);
    var ref  = type.getDeclaredField(field);
    ref.setAccessible(true);
    ref.set(null, inst);
  }
}
