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
package org.openspaces.persistency.cassandra;

import org.openspaces.persistency.cassandra.meta.conversion.ColumnFamilyNameConverter;
import org.openspaces.persistency.cassandra.meta.mapping.filter.FlattenedPropertiesFilter;
import org.openspaces.persistency.cassandra.meta.types.dynamic.PropertyValueSerializer;

/**
 * 
 *  A configurer for creating {@link CassandraSpaceSynchronizationEndpoint} instances.
 *
 * @since 9.1.1
 * @author Dan Kilman
 */
public class CassandraSpaceSynchronizationEndpointConfigurer {

    protected PropertyValueSerializer fixedPropertyValueSerializer;
    protected PropertyValueSerializer dynamicPropertyValueSerializer;
    protected FlattenedPropertiesFilter flattenedPropertiesFilter;
    protected ColumnFamilyNameConverter columnFamilyNameConverter;
    protected CassandraClient cassandraClient;

    /**
     * Optional. If set, all fixed properties with a type that is not primitive nor a common
     * java type will be serialized using {@link org.openspaces.persistency.cassandra.meta.types.dynamic.PropertyValueSerializer#toByteBuffer(Object)}
     * Note: This property must correspond to the property set on {@link CassandraSpaceDataSource}.
     * (default: Java object serialization)
     * @param fixedPropertyValueSerializer the {@link org.openspaces.persistency.cassandra.meta.types.dynamic.PropertyValueSerializer} to use.
     * @return {@code this} instance.
     */
    public CassandraSpaceSynchronizationEndpointConfigurer fixedPropertyValueSerializer(
            PropertyValueSerializer fixedPropertyValueSerializer) {
        this.fixedPropertyValueSerializer = fixedPropertyValueSerializer;
        return this;
    }

    /**
     * Optional. If set, all dynamic properties will be serialized using
     * {@link org.openspaces.persistency.cassandra.meta.types.dynamic.PropertyValueSerializer#fromByteBuffer(java.nio.ByteBuffer)}.
     * Note: This property must correspond to the property set on
     * {@link CassandraSpaceSynchronizationEndpoint}.
     * (default {@link org.openspaces.persistency.cassandra.meta.types.dynamic.DynamicPropertyValueSerializer})
     * @param dynamicPropertyValueSerializer the {@link org.openspaces.persistency.cassandra.meta.types.dynamic.PropertyValueSerializer} to use.
     * @return {@code this} instance.
     */
    public CassandraSpaceSynchronizationEndpointConfigurer dynamicPropertyValueSerializer(
            PropertyValueSerializer dynamicPropertyValueSerializer) {
        this.dynamicPropertyValueSerializer = dynamicPropertyValueSerializer;
        return this;
    }

    /**
     * Optional.
     * @param flattenedPropertiesFilter the {@link org.openspaces.persistency.cassandra.meta.mapping.filter.FlattenedPropertiesFilter} to use.
     * (default: {@link org.openspaces.persistency.cassandra.meta.mapping.filter.DefaultFlattenedPropertiesFilter})
     * @see org.openspaces.persistency.cassandra.meta.mapping.filter.FlattenedPropertiesFilter
     * @return {@code this} instance.
     */
    public CassandraSpaceSynchronizationEndpointConfigurer flattenedPropertiesFilter(
            FlattenedPropertiesFilter flattenedPropertiesFilter) {
        this.flattenedPropertiesFilter = flattenedPropertiesFilter;
        return this;
    }

    /**
     * Optional.
     * @param columnFamilyNameConverter The {@link org.openspaces.persistency.cassandra.meta.conversion.ColumnFamilyNameConverter} to use.
     * (default: {@link org.openspaces.persistency.cassandra.meta.conversion.DefaultColumnFamilyNameConverter})
     * @see org.openspaces.persistency.cassandra.meta.conversion.ColumnFamilyNameConverter
     * @return {@code this} instance.
     */
    public CassandraSpaceSynchronizationEndpointConfigurer columnFamilyNameConverter(
            ColumnFamilyNameConverter columnFamilyNameConverter) {
        this.columnFamilyNameConverter = columnFamilyNameConverter;
        return this;
    }

    /**
     * @param cassandraClient an instance of {@link HectorCassandraClient}.
     * @return {@code this} instance.
     */
    public CassandraSpaceSynchronizationEndpointConfigurer cassandraClient(
            CassandraClient cassandraClient) {
        this.cassandraClient = cassandraClient;
        return this;
    }

    /**
     * @return An instance of {@link CassandraSpaceSynchronizationEndpoint}
     * matching this configurer configuration.
     */
    public CassandraSpaceSynchronizationEndpoint create() {
        return new CassandraSpaceSynchronizationEndpoint(fixedPropertyValueSerializer,
                                                         dynamicPropertyValueSerializer,
                                                         flattenedPropertiesFilter,
                                                         columnFamilyNameConverter,
                                                         cassandraClient);
    }
    
}
