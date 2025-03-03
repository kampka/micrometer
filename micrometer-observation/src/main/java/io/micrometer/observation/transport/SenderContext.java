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
import io.micrometer.observation.Observation;

import java.util.Objects;

/**
 * Context used when sending data over the wire in a fire and forget fashion.
 *
 * @author Marcin Grzejszczak
 * @since 1.0.0
 */
public class SenderContext<C> extends Observation.Context {

    private final Propagator.Setter<C> setter;

    private final Kind kind;

    @Nullable
    private C carrier;

    /**
     * Creates a new instance of {@link SenderContext}.
     * @param setter propagator setter
     * @param kind kind
     */
    public SenderContext(@NonNull Propagator.Setter<C> setter, @NonNull Kind kind) {
        this.setter = Objects.requireNonNull(setter, "Setter must be set");
        this.kind = Objects.requireNonNull(kind, "Kind must be set");
    }

    /**
     * Creates a new instance of a {@link Kind#PRODUCER} {@link SenderContext}.
     * @param setter propagator setter
     */
    public SenderContext(@NonNull Propagator.Setter<C> setter) {
        this(setter, Kind.PRODUCER);
    }

    @Nullable
    public C getCarrier() {
        return carrier;
    }

    public void setCarrier(C carrier) {
        this.carrier = carrier;
    }

    public Propagator.Setter<C> getSetter() {
        return setter;
    }

    public Kind getKind() {
        return kind;
    }

}
