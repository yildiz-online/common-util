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


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValueTest {

    @Test
    void testValue() {
        BoundedValue v = new BoundedValue();
        assertEquals(0, v.getMax());
        assertEquals(0, v.getValue());
    }

    @Test
    void testGetSetValue() {
        BoundedValue v = new BoundedValue();
        v.setValue(15);
        assertEquals(0, v.getValue());
        v.setMax(100);
        v.setValue(15);
        assertEquals(15, v.getValue());
        v.setValue(150);
        assertEquals(100, v.getValue());
        v.setValue(-150);
        assertEquals(0, v.getValue());
    }

    @Test
    void testGetSetMax() {
        BoundedValue v = new BoundedValue();
        assertEquals(0, v.getMax());
        v.setMax(100);
        assertEquals(100, v.getMax());
        v.setMax(-100);
        assertEquals(0, v.getMax());
        v.setMax(100);
        v.setValue(50);
        v.setMax(10);
        assertEquals(10, v.getValue());
    }

    @Test
    void testAdd() {
        BoundedValue v = new BoundedValue();
        v.setMax(100);
        v.setValue(15);
        v.add(10);
        assertEquals(25, v.getValue());
        v.add(80);
        assertEquals(100, v.getValue());
        v.add(-200);
        assertEquals(0, v.getValue());
    }

    @Test
    void testIsZero() {
        BoundedValue v = new BoundedValue();
        v.setMax(100);
        v.setValue(15);
        assertFalse(v.isZero());
        v.setValue(0);
        assertTrue(v.isZero());
    }

    @Test
    void testGetRatio() {
        BoundedValue v = new BoundedValue();
        v.setMax(100);
        v.setValue(15);
        assertEquals(100.0f / 15.0f, v.getRatio(), 0.001f);
    }

    @Test
    void testToString() {
        BoundedValue v = new BoundedValue();
        v.setMax(100);
        v.setValue(15);
        assertEquals("15/100", v.toString());
    }

    @Test
    void testSetValueAndMax() {
        BoundedValue v = new BoundedValue();
        v.setValueAndMax(50);
        assertEquals(50, v.getValue());
        assertEquals(50, v.getMax());
        v.setValueAndMax(-10);
        assertEquals(0, v.getValue());
        assertEquals(0, v.getMax());
    }

    @Test
    void testIsMoreThan() {
        BoundedValue v = new BoundedValue();
        v.setValueAndMax(50);
        assertTrue(v.isMoreThan(10));
        assertTrue(v.isMoreThan(50));
        assertFalse(v.isMoreThan(51));
    }

}
