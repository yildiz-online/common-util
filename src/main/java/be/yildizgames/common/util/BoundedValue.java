/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 * Copyright (c) 2017 Grégory Van den Borre
 *
 * More infos available: https://www.yildiz-games.be
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 */

package be.yildizgames.common.util;

/**
 * A value is composed of a value and a max value, it cannot be lower than 0.
 *
 * @author Grégory Van den Borre
 */
public final class BoundedValue {

    /**
     * Value, will always be between 0 and max(it will be recomputed if max is
     * updated).
     */
    private float value;

    /**
     * Max value, this is the maximum for the value field.
     */
    private float max;

    public BoundedValue(float value, float max) {
        super();
        this.value = value;
        this.max = max;
    }

    public BoundedValue() {
        super();
    }

    /**
     * @return The value.
     */
    public int getValue() {
        return (int) this.value;
    }

    /**
     * Update the value, if parameter is smaller than 0, 0 will be used, if
     * parameter is higher than this max field, max will be used.
     *
     * @param value New value to set.
     */
    public void setValue(final float value) {
        if (value < 0) {
            this.value = 0;
        } else if (value > this.max) {
            this.value = max;
        } else {
            this.value = value;
        }
    }

    /**
     * @return The maximum.
     */
    public int getMax() {
        return (int) this.max;
    }

    /**
     * Update max value, if parameter is smaller than 0, 0 will be set. If new
     * max is lower than the value field, the value field will be updated to fit
     * it.
     *
     * @param max New value for max.
     */
    public void setMax(final float max) {
        if (max < 0) {
            this.max = 0;
        } else {
            this.max = max;
        }
        this.setValue(this.value);
    }

    /**
     * Add to this value.
     *
     * @param toAdd Value to add.
     */
    public void add(final float toAdd) {
        this.setValue(this.value + toAdd);
    }

    /**
     * @return <code>true</code> if this value is zero, <code>false</code>
     * otherwise.
     */
    public boolean isZero() {
        return this.getValue() == 0;
    }

    /**
     * @return The ratio between the max and the value.
     */
    public float getRatio() {
        return this.max / this.value;
    }

    @Override
    public String toString() {
        return this.getValue() + "/" + this.getMax();
    }

    public void setValueAndMax(final int max) {
        this.setMax(max);
        this.setValue(max);
    }

    public boolean isMoreThan(float value) {
        return this.value >= value;
    }
}
