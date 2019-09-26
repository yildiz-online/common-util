/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.common.util;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.Random;

/**
 * Utility class to provide basic services.
 *
 * @author Grégory Van den Borre
 */
public class Util {

    /**
     * Random used to generate numbers.
     */
    private static final Random RANDOM = new Random();

    /**
     * Private constructor to prevent instantiation.
     */
    private Util() {
        super();
    }

    /**
     * Test equality on two float.
     *
     * @param d1 float to test.
     * @param d2 Other float to test.
     * @return True is f1 and f2 are considered equals.
     */
    public static boolean equalFloat(final float d1, final float d2) {
        return Float.compare(d1, d2) == 0;
    }

    /**
     * Run an external application from a given directory.
     *
     * @param applicationName  Full application name, with its extension.
     * @param workingDirectory Root is considered as calling application working directory.
     * @throws IOException Exception thrown from the runtime exec method.
     */
    public static void execute(final String applicationName, final String workingDirectory) throws IOException {
        Runtime.getRuntime().exec(new String[]{Paths.get(workingDirectory, applicationName).toAbsolutePath().toString()}, null,
                Paths.get(workingDirectory).toFile().getAbsoluteFile());
    }

    /**
     * Compute a random number.
     *
     * @return A random number.
     */
    public static int getRandom() {
        return Util.RANDOM.nextInt();
    }

    /**
     * Compute a random number with max value.
     *
     * @param maxIncluded Max value to use(included in result).
     * @return A random number.
     */
    public static int getRandom(final int maxIncluded) {
        return Util.RANDOM.nextInt(maxIncluded + 1);
    }

    /**
     * Check if a parameter is greater than 0, if not, an InvalidParameterException is
     * thrown.
     *
     * @param param Parameter to check
     */
    public static void greaterThanZero(final float param) {
        if (param <= 0) {
            throw new InvalidParameterException("Parameter cannot be <= 0, current value is " + param);
        }
    }

    /**
     * @return true if the current operating system is Linux.
     */
    public static boolean isLinux() {
        return "linux".equalsIgnoreCase(System.getProperty("os.name"));
    }

    /**
     * @return true If the platform is X86.
     */
    public static boolean isX86() {
        return "x86".equals(System.getProperty("os.arch"));
    }

    /**
     * Check if a value is not bigger than its allowed limit.
     *
     * @param value    Value to check.
     * @param maxValue Maximum value.
     * @return The value if it is smaller than the maximum, else return the
     * maximum.
     */
    public static float setLimitedValue(final float value, final float maxValue) {
        return Math.min(value, maxValue);
    }

    /**
     * Return a value or 0 if negative.
     *
     * @param value Value to check.
     * @return The value.
     */
    public static float setPositiveValue(final float value) {
        if (value < 0) {
            return 0;
        }
        return value;
    }

    /**
     * Return a value in a range.
     *
     * @param value Value to check.
     * @param min   Minimum value.
     * @param max   Maximum value.
     * @return The value.
     */
    public static float setValue(final float value, final float min, final float max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        }
        return value;
    }

    /**
     * Return a value in a range.
     *
     * @param value Value to check.
     * @param min   Minimum value.
     * @param max   Maximum value.
     * @return The value.
     */
    public static int setValue(final int value, final int min, final int max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        }
        return value;
    }

    /**
     * @return The application PID value.
     */
    public static long getPid() {
        return ProcessHandle.current().pid();
    }

    /**
     * Check that every float in the first array are bigger than the second at
     * the same index. i.e: a[3] = 4 and b[3] = 2 will return
     * <code>false</code>.
     *
     * @param a First array to check.
     * @param b Second array to check.
     * @return <code>true</code> if all element at same index of first array are
     * bigger than in second array.
     */
    public static boolean checkBiggerOrEqual(final float[] a, final float[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }
}
