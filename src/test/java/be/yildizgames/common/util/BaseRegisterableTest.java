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

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Grégory Van den Borre
 */
class BaseRegisterableTest {

    @Nested
    class Constructor {

        @Test
        void happyFlow() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            assertEquals("test", registerable.getName());
        }

        @Test
        void withNull() {
            assertThrows(AssertionError.class, () -> new BaseRegisterable(null));
        }
    }

    @Nested
    class ToString {

        @Test
        void happyFlow() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            assertEquals("test", registerable.toString());
        }
    }

    @Nested
    class HashCode {

        @Test
        void happyFlow() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            BaseRegisterable registerable2 = new BaseRegisterable("test");
            assertEquals(registerable.hashCode(), registerable2.hashCode());
        }

        @Test
        void different() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            BaseRegisterable registerable2 = new BaseRegisterable("test2");
            assertNotEquals(registerable.hashCode(), registerable2.hashCode());
        }
    }

    @Nested
    class Equals {

        @Test
        void sameInstance() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            assertTrue(registerable.equals(registerable));
        }

        @Test
        void sameValue() {
            assertTrue(new BaseRegisterable("test").equals(new BaseRegisterable("test")));
        }

        @Test
        void differentValue() {
            assertFalse(new BaseRegisterable("test").equals(new BaseRegisterable("test2")));
        }

        @Test
        void differentType() {
            assertFalse(new BaseRegisterable("test").equals("test"));
        }

        @Test
        void withNull() {
            assertFalse(new BaseRegisterable("test").equals(null));
        }
    }
}
