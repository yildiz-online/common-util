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

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Grégory Van Den Borre
 */
final class UtilTest {

    private static final float EPSILON = 0.0000000001f;

    /***/
    @Test
    void testEqualFloat() {
        float f1 = 5.00001f;
        float f2 = 549.654516545f;
        float result1 = f1 + f2;
        float result2 = f1 + f2;
        float f = result1 - result2;
        assertTrue(f == 0.0 || f > -UtilTest.EPSILON && f < UtilTest.EPSILON);
        assertTrue(Util.equalFloat(result1, result2));
        float t1 = result2 += 0.1f;
        float t2 = result1 -= 0.1f;
        assertFalse(Util.equalFloat(result1, t1));
        assertFalse(Util.equalFloat(t2, result2));
    }

    @Test
    void testGetRandom() {
        final int testLength = 1000;
        int[] tab = new int[testLength];
        for (int i = 0; i < testLength; i++) {
            tab[i] = Util.getRandom();
        }
        for (int i = 0; i < testLength; i++) {
            for (int j = 0; j < testLength; j++) {
                if (i != j) {
                    assertFalse(tab[i] == tab[j]);
                }
            }
        }
    }

    /***/
    @Test
    void testGreaterThanZero() {
        assertThrows(InvalidParameterException.class, () -> Util.greaterThanZero(0));
        assertThrows(InvalidParameterException.class, () -> Util.greaterThanZero(-5));
        Util.greaterThanZero(0.001f);
    }
}
