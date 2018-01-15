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
 * Registerable mean the object can used with a Registerer, its name must be
 * unique for the used Registerer.
 *
 * @author Grégory Van den Borre
 */
public class BaseRegisterable implements Registerable {

    /**
     * The Registerer key.
     */
    private final String name;

    /**
     * Class is immutable, so hash code is computed only once.
     */
    private final int hashcode;

    /**
     * Full constructor. This class is only meant to be extended, the
     * constructor is protected.
     *
     * @param registerableName Name associated to the registerable, must be unique by
     *                         Registerer.
     */
    protected BaseRegisterable(final String registerableName) {
        super();
        assert registerableName != null;
        this.name = registerableName;
        this.hashcode = 31 * this.name.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        BaseRegisterable other = (BaseRegisterable) obj;
        return this.name.equals(other.name);
    }

    /**
     * @return The registerable name.
     */
    @Override
    public final String getName() {
        return this.name;
    }

    /**
     * Simple implementation based on the name.
     *
     * @return The name hashcode.
     */
    @Override
    public int hashCode() {
        return this.hashcode;
    }

    /**
     * Base implementation, just return the name.
     *
     * @return The name.
     */
    @Override
    public String toString() {
        return this.name;
    }

}
