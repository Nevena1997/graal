/*
 * Copyright (c) 2018, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.truffle.regex.util;

import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.MessageResolution;
import com.oracle.truffle.api.interop.Resolve;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.regex.RegexLanguageObject;

public final class TruffleNull implements RegexLanguageObject {

    public static final TruffleNull INSTANCE = new TruffleNull();

    private TruffleNull() {
    }

    @Override
    public ForeignAccess getForeignAccess() {
        return TruffleNullMessageResolutionForeign.ACCESS;
    }

    public static boolean isInstance(TruffleObject object) {
        return object instanceof TruffleNull;
    }

    @MessageResolution(receiverType = TruffleNull.class)
    static class TruffleNullMessageResolution {

        @Resolve(message = "IS_NULL")
        abstract static class TruffleNullIsNullNode extends Node {

            @SuppressWarnings("unused")
            public boolean access(TruffleNull obj) {
                return true;
            }
        }
    }
}
