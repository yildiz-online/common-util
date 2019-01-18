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

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Grégory Van den Borre
 */
class PropertiesHelperTest {

    @Test
    void testGetPropertiesFromFile() {
        Properties p =  this.getPropertiesFromFile("test.properties");
        assertEquals(p.getProperty("key1"), "value1");
        assertEquals(p.getProperty("key2"), "value2");
        assertEquals(p.getProperty("key3"), "value3");
    }

    @Test
    void testGetBooleanDefault() {
        Properties p = this.getPropertiesFromFile("test.properties");
        assertFalse(PropertiesHelper.getBooleanValue(p, "notExistingKey", false));
        assertTrue(PropertiesHelper.getBooleanValue(p, "notExistingKey", true));
    }

    private Properties getPropertiesFromFile(String path) {
        Properties p = new Properties();
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(path)) {
            p.load(is);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return p;
    }

}
