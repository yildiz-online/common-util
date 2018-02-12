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

package be.yildizgames.common.util.language;

import java.util.stream.Stream;

/**
 * Enumeration for possible languages.
 * Immutable class.
 *
 * @author Grégory Van den Borre
 *         specfield description:String:LanguageValue translated in its own language.
 *         specfield value:int:LanguageValue unique index value.
 */
//@Invariant description != null.
//@Invariant value >= 0.
public enum LanguageValue implements Language {

    /**
     * English language.
     */
    EN("en", "English", 0),

    /**
     * French language.
     */
    FR("fr", "Français", 1);

    /**
     * LanguageValue name in its own translation.
     */
    public final String description;

    /**
     * LanguageValue short name.
     */
    public final String shortName;

    /**
     * Associated value.
     */
    public final int value;

    LanguageValue(final String shortName, final String description, final int value) {
        this.shortName = shortName;
        this.description = description;
        this.value = value;
        assert this.invariant();
    }

    public static Language fromShortName(String name) {
        return Stream.of(LanguageValue.values())
                .filter(v -> v.shortName.equalsIgnoreCase(name))
                .findFirst()
                .orElse(LanguageValue.EN);
    }

    @Override
    public int getId() {
        return value;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getShortName() {
        return this.shortName;
    }

    /**
     * Invariant, only called if assertions are enabled.
     *
     * @return <code>true</code>.
     * @throws AssertionError if the invariant is broken in any way.
     */
    private boolean invariant() {
        if (this.shortName == null) {
            throw new AssertionError("short name is null");
        }
        if (this.description == null) {
            throw new AssertionError("description is null");
        }
        if (this.value < 0) {
            throw new AssertionError("value < 0");
        }
        return true;
    }
}
