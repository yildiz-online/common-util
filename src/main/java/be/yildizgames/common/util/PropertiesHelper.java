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

import java.util.Properties;

/**
 * Provide utility methods to use property easily.
 *
 * @author Grégory Van den Borre.
 */
public interface PropertiesHelper {

    /**
     * Get a boolean value from a properties.
     *
     * @param properties Properties to extract the value.
     * @param key        Key associated to the value.
     * @return The boolean value found.
     * @throws PropertiesException If the key is not found.
     * @throws PropertiesException If the value cannot be parsed into a boolean.
     */
    //@Requires("properties != null")
    //@Requires("key != null")
    static boolean getBooleanValue(final Properties properties, final String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            PropertiesHelper.keyNotFoundError(key);
        }
        if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
            return Boolean.valueOf(value);
        }
        throw new PropertiesException("Only true or false value allowed, found " + value);
    }

    /**
     * Get a boolean value from a properties.
     *
     * @param properties   Properties to extract the value.
     * @param key          Key associated to the value.
     * @param defaultValue Default value if it does not exists in the properties.
     * @return The boolean value found.
     * @throws PropertiesException If the key is not found.
     * @throws PropertiesException If the value cannot be parsed into a boolean.
     */
    //@Requires("properties != null")
    //@Requires("key != null")
    static boolean getBooleanValue(final Properties properties, final String key, final boolean defaultValue) {
        String value = properties.getProperty(key);
        if (value == null) {
            return defaultValue;
        }
        if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
            return Boolean.valueOf(value);
        }
        throw new PropertiesException("Only true or false value allowed, found " + value);
    }

    /**
     * Get a int value from a properties.
     *
     * @param properties Properties to extract the value.
     * @param key        Key associated to the value.
     * @return The integer value found.
     * @throws PropertiesException If the key is not found.
     * @throws PropertiesException If the value cannot be parsed into a int.
     */
    //@Requires("properties != null")
    //@Requires("key != null")
    static int getIntValue(final Properties properties, final String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            PropertiesHelper.keyNotFoundError(key);
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new PropertiesException("Value " + value + " for key " + key + " is not a valid integer.");
        }
    }

    /**
     * Get a String value from a properties.
     *
     * @param properties Properties to extract the value.
     * @param key        Key associated to the value.
     * @return The value found.
     * @throws PropertiesException If the key is not found.
     */
    //@Requires("properties != null")
    // @Requires("key != null")
    //@Ensures ("result != null")
    static String getValue(final Properties properties, final String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            PropertiesHelper.keyNotFoundError(key);
        }
        return value;
    }


    /**
     * Error for a key not found.
     *
     * @param key Key not found.
     */
    static void keyNotFoundError(final String key) {
        throw new PropertiesException("Key " + key + " not found in the properties.");
    }

    static int getPortValue(Properties properties, String s) {
        int port = getIntValue(properties, s);
        if(port < 0 || port > 65635) {
            throw new PropertiesException("Port must be between 0 and 65635");
        }
        return port;
    }
}
