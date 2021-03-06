/*******************************************************************************
 * Copyright (c) 2012 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openspaces.persistency.cassandra.meta.types.dynamic;

import java.nio.ByteBuffer;

/**
 * An interface used for conversion of objects to/from {@link java.nio.ByteBuffer}.
 * @since 9.1.1
 * @author Dan Kilman
 */
public interface PropertyValueSerializer {

    /**
     * @param value The object to serialize.
     * @return A {@link java.nio.ByteBuffer} holding a serialized form of the value argument.
     */
    ByteBuffer toByteBuffer(Object value);

    /**
     * @param byteBuffer Holds the bytes as originally serialized
     * using {@link PropertyValueSerializer#toByteBuffer(Object)}.
     * @return The deserialized object value.
     */
    Object fromByteBuffer(ByteBuffer byteBuffer);
    
}
