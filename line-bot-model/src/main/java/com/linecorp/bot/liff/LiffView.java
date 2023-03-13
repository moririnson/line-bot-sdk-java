/*
 * Copyright 2023 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.bot.liff;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class LiffView {
    public enum Type {
        /**
         * 50% of the screen height of the device. This size can be specified only for the chat screen.
         */
        @JsonProperty("compact")
        COMPACT,

        /**
         * 80% of the screen height of the device. This size can be specified only for the chat screen.
         */
        @JsonProperty("tall")
        TALL,

        /**
         * 100% of the screen height of the device. This size can be specified for any screens in the LINE app.
         */
        @JsonProperty("full")
        FULL,
    }

    /**
     * Size of the LIFF app view. Specify one of the following values:
     */
    Type type;

    /**
     * URL of the LIFF app. The URL scheme must be https.
     */
    URI url;

    @JsonCreator
    public LiffView(@JsonProperty("type") Type type,
                    @JsonProperty("url") URI url) {
        this.type = type;
        this.url = url;
    }
}
