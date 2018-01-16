/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 * Copyright (c) 2017 Grégory Van den Borre
 *
 * More infos available: https://www.yildiz-games.be
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 */

package be.yildizgames.common.util;


/**
 * Check various conditions, return <code>true</code> if the check is
 * successful, <code>false</code> otherwise.
 *
 * @author Grégory Van den Borre
 */
public final class Checker {

    private static final String GREATER_OR_EQUALS = "Value should be greater or equals to zero. Value is ";

    private Checker() {
        super();
    }

    /**
     * Check if 2 arrays have the same length.
     *
     * @param array1 First array.
     * @param array2 Second array.
     * @return <code>true</code> if both have same length.
     */
    public static boolean arraysSameSize(final float[] array1, final float[] array2) {
        return array1.length == array2.length;
    }

    /**
     * Check if a value is in an array range.
     *
     * @param index Value to check.
     * @param array Array to use.
     * @return true if the value is greater than 0 and smaller than array
     * length.
     */
    public static boolean inArrayRange(final int index, final Object[] array) {
        return index >= 0 && index < array.length;
    }

    /**
     * check if a float value is between 2 other float values.
     *
     * @param value     Value to check.
     * @param lowLimit  Lower limit.
     * @param highLimit Upper limit.
     * @return true if value is higher than lowLimit and lower than highLimit.
     */
    public static boolean inRange(final float value, final float lowLimit, final float highLimit) {
        return value >= lowLimit && value <= highLimit;
    }

    /**
     * check if an int value is between 2 other int values.
     *
     * @param value     Value to check.
     * @param lowLimit  Lower limit.
     * @param highLimit Upper limit.
     * @return true if value is higher than lowLimit and lower than highLimit.
     */
    public static boolean inRange(final int value, final int lowLimit, final int highLimit) {
        return value >= lowLimit && value <= highLimit;
    }

    /**
     * Check if a double value is positive.
     *
     * @param toCheck Double value to check.
     * @return <code>true</code> if the value is greater or equal to 0.
     */
    public static boolean isPositive(final double toCheck) {
        return toCheck >= 0.0;
    }

    /**
     * Check if a float value is positive.
     *
     * @param toCheck Float value to check.
     * @return <code>true</code> if the value is greater or equal to 0.
     */
    public static boolean isPositive(final float toCheck) {
        return toCheck >= 0.0f;
    }

    /**
     * Check if an int value is positive.
     *
     * @param toCheck Int value to check.
     * @return <code>true</code> if the value is greater or equal to 0.
     */
    public static boolean isPositive(final int toCheck) {
        return toCheck >= 0;
    }

    /**
     * Check if a long value is positive.
     *
     * @param toCheck Long value to check.
     * @return <code>true</code> if the value is greater or equal to 0.
     */
    public static boolean isPositive(final long toCheck) {
        return toCheck >= 0L;
    }

    /**
     * Throw an exception if the parameter is not greater or equal to 0.
     *
     * @param value Parameter to check.
     */
    public static void exceptionNotPositive(final long value) {
        if (!isPositive(value)) {
            throw new AssertionError(GREATER_OR_EQUALS + value);
        }
    }

    /**
     * Throw an exception if the parameter is not greater or equal to 0.
     *
     * @param value Parameter to check.
     */
    public static void exceptionNotPositive(final int value) {
        if (!isPositive(value)) {
            throw new AssertionError(GREATER_OR_EQUALS + value);
        }
    }

    /**
     * Throw an exception if the parameter is not greater or equal to 0.
     *
     * @param value Parameter to check.
     */
    public static void exceptionNotPositive(final float value) {
        if (!isPositive(value)) {
            throw new AssertionError(GREATER_OR_EQUALS + value);
        }
    }

    /**
     * Check if the provided value is greater than 0.
     *
     * @param value Value to check.
     * @throws IllegalArgumentException If the value is 0 or lower.
     */
    public static void exceptionNotGreaterThanZero(final int value) {
        if (value <= 0) {
            throw new AssertionError("Value should be greater than zero. Value is " + value);
        }
    }

    /**
     * Check if the provided value is greater than 0.
     *
     * @param value Value to check.
     * @throws IllegalArgumentException If the value is 0 or lower.
     */
    public static void exceptionNotGreaterThanZero(final float value) {
        if (value <= 0.0f) {
            throw new AssertionError("Value should be greater than zero. Value is " + value);
        }
    }

}
