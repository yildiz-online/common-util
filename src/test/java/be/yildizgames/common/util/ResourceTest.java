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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class ResourceTest {

    @Nested
    public class Load {

        @Test
        public void happyFlow() {
            DummyResource r = new DummyResource();
            Assertions.assertEquals(0, r.loadNumber);
            r.load();
            Assertions.assertEquals(1, r.loadNumber);
            r.load();
            Assertions.assertEquals(1, r.loadNumber);

        }
    }

    @Nested
    public class ToString {

        @Test
        public void happyFlow() {
            Resource r = new DummyResource();
            Assertions.assertEquals(r.getName(), r.toString());
        }
    }

    @Nested
    public class Equals {

        @Test
        public void sameName() {
            Resource r = new DummyResource();
            Resource r2 = new DummyResource();
            Assertions.assertEquals(r, r2);
        }

        @Test
        public void loaded() {
            Resource r = new DummyResource();
            r.load();
            Resource r2 = new DummyResource();
            r2.load();
            Assertions.assertEquals(r, r2);
        }

        @Test
        public void notLoaded() {
            Resource r = new DummyResource();
            r.load();
            Resource r2 = new DummyResource();
            Assertions.assertNotEquals(r, r2);
        }

        @Test
        public void differentName() {
            Resource r = new DummyResource();
            Resource r2 = new DummyResource("tt");
            Assertions.assertNotEquals(r, r2);
        }
    }

    @Nested
    public class HashCode {

        @Test
        public void same() {
            Resource r = new DummyResource();
            Resource r2 = new DummyResource();
            Assertions.assertEquals(r.hashCode(), r2.hashCode());
        }

        @Test
        public void notSame() {
            Resource r = new DummyResource();
            Resource r2 = new DummyResource("tt");
            Assertions.assertNotEquals(r.hashCode(), r2.hashCode());
        }

    }

    private final class DummyResource extends Resource {

        private int loadNumber;

        /**
         * Full constructor.
         */
        private DummyResource() {
            super("test");
        }

        private DummyResource(String name) {
            super(name);
        }

        @Override
        protected void loadImpl() {
            this.loadNumber++;
        }
    }

}
