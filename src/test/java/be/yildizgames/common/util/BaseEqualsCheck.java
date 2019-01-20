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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Grégory Van den Borre
 */
public class BaseEqualsCheck<T>{

    private final T baseObject;
    private final T same;
    private final T different;

    public BaseEqualsCheck(T baseObject, T same, T different) {
        super();
        this.baseObject = baseObject;
        this.same = same;
        this.different = different;
    }

    public void all() {
        equalsSame();
        equalsSameInstance();
        equalsDifferent();
        equalsDifferentType();
        equalsNull();
        hashcodeSame();
        hashcodeDifferent();
    }

    public void equalsSame() {
        assertTrue(baseObject.equals(same));
    }

    public void equalsSameInstance() {
        assertTrue(baseObject.equals(baseObject));
    }

    public void equalsDifferent() {
        assertFalse(baseObject.equals(different));
    }

    public void equalsNull() {
        assertFalse(baseObject.equals(null));
    }

    public void equalsDifferentType() {
        assertFalse(baseObject.equals("ok"));
    }

    public void hashcodeSame() {
        assertEquals(baseObject.hashCode(), same.hashCode());
    }

    public void hashcodeDifferent() {
        assertNotEquals(baseObject.hashCode(), different.hashCode());
    }

}
