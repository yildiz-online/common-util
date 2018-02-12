/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
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

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Grégory Van den Borre
 */
final class StringUtilTest {

    @Nested
    class ArrayToString {

        @Test
        void happyFlowObject() {
            Object[] array = {"az", 5};
            String result = StringUtil.arrayToString(array);
            assertNotNull(result);
            assertEquals("az|5", result);
        }

        @Test
        void emptyObject() {
            Object[] array = {};
            String result = StringUtil.arrayToString(array);
            assertNotNull(result);
            assertEquals("", result);
        }

        @Test
        void happyFlowFloats() {
            float[] array = {};
            String result = StringUtil.arrayToString(array);
            assertNotNull(result);
            assertEquals("", result);
        }

        @Test
        void emptyFloats() {
            float[] array = {1f,1.2f,5f};
            String result = StringUtil.arrayToString(array);
            assertNotNull(result);
            assertEquals("1.0|1.2|5.0", result);
        }
    }

    @Nested
    class BuildRandom {

        @Test
        void happyFlow() {
            String s = StringUtil.buildRandomString("base");
            String s2 = StringUtil.buildRandomString("base");
            assertNotEquals(s, s2);
            assertTrue(s.startsWith("base"));
            assertTrue(s2.startsWith("base"));
        }

        @Test
        void fromNull() {
            assertThrows(AssertionError.class, () -> StringUtil.buildRandomString(null));
        }
    }

    @Nested
    class FillVariable {

        @Test
        void happyFlow() {
            String base = "hello ${0} !";
            String[] replacement = {"world"};
            assertEquals("hello world !", StringUtil.fillVariable(base, replacement));
        }

        @Test
        void empty() {
            String base = "hello ${0} !";
            String[] replacement = {};
            assertEquals("hello ${0} !", StringUtil.fillVariable(base, replacement));
        }

        @Test
        void withSeveralBase() {
            String base = "hello ${0} ${0} !";
            String[] replacement = {"world"};
            assertEquals("hello world world !", StringUtil.fillVariable(base, replacement));
        }

        @Test
        void withNullBase() {
            String[] replacement = {"test"};
            assertThrows(NullPointerException.class, () -> StringUtil.fillVariable(null, replacement));
        }

        @Test
        void withNullReplacement() {
            assertEquals("base", StringUtil.fillVariable("base", null));
        }

        @Test
        void withTooManyReplacement() {
            String base = "hello ${0} !";
            String[] replacement = {"world", "you", "all"};
            assertEquals("hello world !", StringUtil.fillVariable(base, replacement));
        }

        @Test
        void withNotEnougReplacement() {
            String base = "hello ${0} ${1} ${2} ${4} !";
            String[] replacement = {"world", "you", "all"};
            assertEquals("hello world you all ${4} !", StringUtil.fillVariable(base, replacement));
        }

        @Test
        void withReplacementContainingNull() {
            String base = "hello ${0} ${1} !";
            String[] replacement = {"world", null};
            assertThrows(NullPointerException.class, () -> StringUtil.fillVariable(base, replacement));
        }

    }

    @Test
    void testRemoveChar() {
        String s = "abcdef";
        int pos = 2;
        assertEquals("abdef", StringUtil.removeChar(s, pos));
    }

    @Test
    void testRemoveLastCharString() {
        String s = "bla14";
        assertEquals("bla1", StringUtil.removeLastChar(s));
        s = "";
        assertEquals("", StringUtil.removeLastChar(s));
    }

    @Test
    void testRemoveLastCharStringBuilder() {
        StringBuilder s = new StringBuilder("bla14");
        assertEquals("bla1", StringUtil.removeLastChar(s));
        s = new StringBuilder();
        assertEquals("", StringUtil.removeLastChar(s));
    }

    @Test
    void testToString() {
        Object[] l = {"test", 5, 'x', new Object()};
        for (Object o : l) {
            assertEquals(o.toString(), StringUtil.toString(o));
        }
        assertEquals("null", StringUtil.toString(null));
    }

}
