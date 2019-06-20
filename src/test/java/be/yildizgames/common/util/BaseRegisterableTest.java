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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Grégory Van den Borre
 */
public class BaseRegisterableTest {

    @Nested
    public class Constructor {

        @Test
        public void happyFlow() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            assertEquals("test", registerable.getName());
        }

        @Test
        public void withNull() {
            assertThrows(AssertionError.class, () -> new BaseRegisterable(null));
        }
    }

    @Nested
    public class ToString {

        @Test
        public void happyFlow() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            assertEquals("test", registerable.toString());
        }
    }

    @Nested
    public class HashCode {

        @Test
        public void happyFlow() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            BaseRegisterable registerable2 = new BaseRegisterable("test");
            assertEquals(registerable.hashCode(), registerable2.hashCode());
        }

        @Test
        public void different() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            BaseRegisterable registerable2 = new BaseRegisterable("test2");
            assertNotEquals(registerable.hashCode(), registerable2.hashCode());
        }
    }

    @Nested
    public class Equals {

        @Test
        public void sameInstance() {
            BaseRegisterable registerable = new BaseRegisterable("test");
            assertEquals(registerable, registerable);
        }

        @Test
        public void sameValue() {
            assertEquals(new BaseRegisterable("test"), new BaseRegisterable("test"));
        }

        @Test
        public void differentValue() {
            assertNotEquals(new BaseRegisterable("test"), new BaseRegisterable("test2"));
        }

        @Test
        public void differentType() {
            assertNotEquals("test", new BaseRegisterable("test"));
        }

        @Test
        public void withNull() {
            assertNotEquals(null, new BaseRegisterable("test"));
        }
    }
}
