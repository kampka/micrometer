/*
 * Copyright 2022 VMware, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.observation.transport;

import io.micrometer.common.lang.NonNull;
import io.micrometer.common.lang.Nullable;

/**
 * Context used when receiving data over the wire with confirmation to be sent to sender
 * of the data.
 *
 * @author Marcin Grzejszczak
 * @since 1.0.0
 */
public class RequestReplyReceiverContext<C, RES> extends ReceiverContext<C> {

    @Nullable
    private RES response;

    /**
     * Creates a new instance of {@link RequestReplyReceiverContext}.
     * @param getter propagator getter
     * @param kind kind
     */
    public RequestReplyReceiverContext(@NonNull Propagator.Getter<C> getter, @NonNull Kind kind) {
        super(getter, kind);
    }

    /**
     * Creates a new instance of {@link Kind#SERVER} {@link RequestReplyReceiverContext}.
     * @param getter propagator getter
     */
    public RequestReplyReceiverContext(@NonNull Propagator.Getter<C> getter) {
        this(getter, Kind.SERVER);
    }

    @Nullable
    public RES getResponse() {
        return response;
    }

    public void setResponse(RES response) {
        this.response = response;
    }

}
