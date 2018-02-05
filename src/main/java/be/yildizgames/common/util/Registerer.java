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

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Register objects to be retrieved by their name.
 *
 * @param <T> Type to register.
 * @author Grégory Van den Borre
 */
public final class Registerer<T extends Registerable> {

    /**
     * Map containing the Registerable elements, the key is the name and the
     * value is the element.
     */
    private final Map<String, T> list = new HashMap<>();
    /**
     * Behavior to call when no result is found for a given name.
     */
    private final NoResult<T> noResult;

    /**
     * Default constructor, use the default NoResult behavior when no result is
     * found(throw an İnvalidParameterException). Private to be used only by the
     * factory.
     */
    private Registerer() {
        super();
        this.noResult = new DefaultNoResult();
    }

    /**
     * Full constructor, use a given NoResult behavior when no result is found.
     * Private to be used only by the factory.
     *
     * @param noResultBehavior Given NoResult to use when no result is found.
     */
    private Registerer(final NoResult<T> noResultBehavior) {
        super();
        this.noResult = noResultBehavior;
    }

    /**
     * Factory to build a new Registerer instance, default NoResult is
     * applied(throw InvalidParameterException).
     *
     * @param <T> Type to use in the registerer.
     * @return A new Registerer instance with default NoResult behavior.
     */
    public static <T extends Registerable> Registerer<T> newRegisterer() {
        return new Registerer<>();
    }

    /**
     * Factory to build a new Registerer instance.
     *
     * @param <T>      Type to use in the registerer.
     * @param noResult Behavior to use when no result is found for a given name.
     * @return A new Registerer instance.
     */
    public static <T extends Registerable> Registerer<T> newRegisterer(final NoResult<T> noResult) {
        return new Registerer<>(noResult);
    }

    /**
     * Retrieve an element from its name, if nothing matches, the NoResult
     * behavior is called.
     *
     * @param name Name of the object to retrieve.
     * @return The object matching the name.
     */
    public T get(final String name) {
        T result = this.list.get(name);
        if (result == null) {
            return this.noResult.resultNotFound(name);
        }
        return result;
    }

    /**
     * Search for an element from its name.
     *
     * @param name Name of the object to search for.
     * @return An optional result.
     */
    public Optional<T> find(final String name) {
        return Optional.ofNullable(this.list.get(name));
    }

    /**
     * Register a new element, if the element name is already registered, an
     * İnvalıidParameterExeption is thrown.
     *
     * @param element Object to insert.
     */
    public void register(final T element) {
        if (this.list.containsKey(element.getName())) {
            throw new InvalidParameterException(this.getClass().getTypeParameters()[0].getGenericDeclaration().getSimpleName()
                    + " associated with name " + element.getName() + " already exists.");
        }
        this.list.put(element.getName(), element);
    }

    /**
     * Unregister an element.
     *
     * @param element Object to remove.
     */
    public void remove(final T element) {
        this.list.remove(element.getName());
    }

    /**
     * Default behavior when no result is found.
     */
    private final class DefaultNoResult implements NoResult<T> {

        /**
         * Simple constructor.
         */
        private DefaultNoResult() {
            super();
        }

        @Override
        public T resultNotFound(final String name) {
            throw new InvalidParameterException(name + " not found");
        }

    }
}
