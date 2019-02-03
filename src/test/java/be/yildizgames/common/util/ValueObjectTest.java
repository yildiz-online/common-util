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

/**
 * @author Grégory Van den Borre
 */
public class ValueObjectTest {

    @Nested
    public class Constructor {

       @Test
       public void happyFlow() {
           ValueObject v = new ValueObject(5);
           assertEquals(5, v.value);
       }
    }

    @Nested
    public class HashCodeEquals {

        @Test
        public void sameValue() {
            ValueObject v = new ValueObject(5);
            ValueObject v2 = new ValueObject(5);
            assertEquals(v, v2);
        }

        @Test
        public void differentValue() {
            ValueObject v = new ValueObject(5);
            ValueObject v2 = new ValueObject(6);
            assertNotEquals(v, v2);
        }

        @Test
        public void base() {
            BaseEqualsCheck<ValueObject> b = new BaseEqualsCheck<>(new ValueObject(5), new ValueObject(5), new ValueObject(6));
            b.all();
        }
    }

}