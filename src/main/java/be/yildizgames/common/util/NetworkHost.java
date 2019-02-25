/*
 *
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 * Copyright (c) 2019 Grégory Van den Borre
 *
 * More infos available: https://engine.yildiz-games.be
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 *
 */

package be.yildizgames.common.util;

import be.yildizgames.common.exception.implementation.ImplementationException;

public class NetworkHost {

    public static final NetworkHost LOCALHOST = new NetworkHost("localhost");

    private final String value;

    private NetworkHost(String host) {
        super();
        ImplementationException.throwForNull(host);
        this.value = host;
    }

    public static NetworkHost host(String host) {
        return new NetworkHost(host);
    }

    public static NetworkHost ipv4(int v1, int v2, int v3, int v4) {
        checkIpV4(v1);
        checkIpV4(v2);
        checkIpV4(v3);
        checkIpV4(v4);
        return new NetworkHost(v1 + "." + v2 + "." + v3 + "." + v4);
    }

    private static void checkIpV4(int value) {
        if(value < 0 || value > 255) {
            throw new RuntimeException("Value must be between 0 and 255, current is " + value);
        }
    }

    public final String getValue() {
        return this.value;
    }
}
