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

import java.io.Serializable;

/**
 * Utility class to compute a time between 2 calls.
 *
 * @author Grégory Van den Borre
 */
public final class Timer implements Serializable {

    /***/
    private static final long serialVersionUID = -7461204360956063604L;

    /**
     * Time since the last action.
     */
    private long lastTime = 0;

    /**
     * Simple constructor.
     */
    public Timer() {
        super();
    }

    /**
     * Compute the time since the last call.
     *
     * @return The time in millisecond between now and the last use of this
     * method.
     */
    public long getActionTime() {
        final long now = System.currentTimeMillis();
        if (this.lastTime == 0) {
            this.lastTime = now;
        }
        final long time = now - this.lastTime;
        this.lastTime = now;
        return time;
    }

    /**
     * @return the result of {@link Timer#getActionTime()} / 1000.
     */
    public long getActionTimeInSec() {
        final int milliSec = 1000;
        return this.getActionTime() / milliSec;
    }

    /**
     * Reset the timer to 0.
     */
    public void reset() {
        this.lastTime = 0;
    }
}
