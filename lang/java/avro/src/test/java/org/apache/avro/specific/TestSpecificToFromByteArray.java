<<<<<<< HEAD
/**
=======
/*
>>>>>>> 1.9.2
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
<<<<<<< HEAD
 *     http://www.apache.org/licenses/LICENSE-2.0
=======
 *     https://www.apache.org/licenses/LICENSE-2.0
>>>>>>> 1.9.2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.avro.specific;

<<<<<<< HEAD
import org.apache.avro.Conversions;
import org.apache.avro.LogicalTypes;
import org.apache.avro.data.TimeConversions;
=======
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;

import org.apache.avro.Conversions;
import org.apache.avro.LogicalTypes;
import org.apache.avro.data.JodaTimeConversions;
>>>>>>> 1.9.2
import org.apache.avro.message.MissingSchemaException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;
<<<<<<< HEAD
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;

import static org.junit.Assert.assertEquals;
=======
>>>>>>> 1.9.2

public class TestSpecificToFromByteArray {
  @Test
  public void testSpecificToFromByteBufferWithLogicalTypes() throws IOException {
<<<<<<< HEAD
    TestRecordWithLogicalTypes record = new TestRecordWithLogicalTypes(
        true,
        34,
        35L,
        3.14F,
        3019.34,
        null,
        LocalDate.now(),
        LocalTime.now(),
        DateTime.now().withZone(DateTimeZone.UTC),
        new BigDecimal("123.45")
    );
=======
    TestRecordWithLogicalTypes record = new TestRecordWithLogicalTypes(true, 34, 35L, 3.14F, 3019.34, null,
        LocalDate.now(), LocalTime.now(), DateTime.now().withZone(DateTimeZone.UTC), new BigDecimal("123.45"));
>>>>>>> 1.9.2

    ByteBuffer b = record.toByteBuffer();
    TestRecordWithLogicalTypes copy = TestRecordWithLogicalTypes.fromByteBuffer(b);

    assertEquals(record, copy);
  }

  @Test
  public void testSpecificToFromByteBufferWithoutLogicalTypes() throws IOException {
<<<<<<< HEAD
    TestRecordWithoutLogicalTypes record = new TestRecordWithoutLogicalTypes(
        true,
        34,
        35L,
        3.14F,
        3019.34,
        null,
        new TimeConversions.DateConversion().toInt(LocalDate.now(), null, null),
        new TimeConversions.TimeConversion().toInt(LocalTime.now(), null, null),
        new TimeConversions.TimestampConversion().toLong(
            DateTime.now().withZone(DateTimeZone.UTC), null, null),
        new Conversions.DecimalConversion().toBytes(
            new BigDecimal("123.45"), null, LogicalTypes.decimal(9, 2))
    );
=======
    TestRecordWithoutLogicalTypes record = new TestRecordWithoutLogicalTypes(true, 34, 35L, 3.14F, 3019.34, null,
        new JodaTimeConversions.DateConversion().toInt(LocalDate.now(), null, null),
        new JodaTimeConversions.TimeConversion().toInt(LocalTime.now(), null, null),
        new JodaTimeConversions.TimestampConversion().toLong(DateTime.now().withZone(DateTimeZone.UTC), null, null),
        new Conversions.DecimalConversion().toBytes(new BigDecimal("123.45"), null, LogicalTypes.decimal(9, 2)));
>>>>>>> 1.9.2

    ByteBuffer b = record.toByteBuffer();
    TestRecordWithoutLogicalTypes copy = TestRecordWithoutLogicalTypes.fromByteBuffer(b);

    assertEquals(record, copy);
  }

  @Test(expected = MissingSchemaException.class)
  public void testSpecificByteArrayIncompatibleWithLogicalTypes() throws IOException {
<<<<<<< HEAD
    TestRecordWithoutLogicalTypes withoutLogicalTypes = new TestRecordWithoutLogicalTypes(
        true,
        34,
        35L,
        3.14F,
        3019.34,
        null,
        new TimeConversions.DateConversion().toInt(LocalDate.now(), null, null),
        new TimeConversions.TimeConversion().toInt(LocalTime.now(), null, null),
        new TimeConversions.TimestampConversion().toLong(
            DateTime.now().withZone(DateTimeZone.UTC), null, null),
        new Conversions.DecimalConversion().toBytes(
            new BigDecimal("123.45"), null, LogicalTypes.decimal(9, 2))
    );
=======
    TestRecordWithoutLogicalTypes withoutLogicalTypes = new TestRecordWithoutLogicalTypes(true, 34, 35L, 3.14F, 3019.34,
        null, new JodaTimeConversions.DateConversion().toInt(LocalDate.now(), null, null),
        new JodaTimeConversions.TimeConversion().toInt(LocalTime.now(), null, null),
        new JodaTimeConversions.TimestampConversion().toLong(DateTime.now().withZone(DateTimeZone.UTC), null, null),
        new Conversions.DecimalConversion().toBytes(new BigDecimal("123.45"), null, LogicalTypes.decimal(9, 2)));
>>>>>>> 1.9.2

    ByteBuffer b = withoutLogicalTypes.toByteBuffer();
    TestRecordWithLogicalTypes.fromByteBuffer(b);
  }

  @Test(expected = MissingSchemaException.class)
  public void testSpecificByteArrayIncompatibleWithoutLogicalTypes() throws IOException {
<<<<<<< HEAD
    TestRecordWithLogicalTypes withLogicalTypes = new TestRecordWithLogicalTypes(
        true,
        34,
        35L,
        3.14F,
        3019.34,
        null,
        LocalDate.now(),
        LocalTime.now(),
        DateTime.now().withZone(DateTimeZone.UTC),
        new BigDecimal("123.45")
    );
=======
    TestRecordWithLogicalTypes withLogicalTypes = new TestRecordWithLogicalTypes(true, 34, 35L, 3.14F, 3019.34, null,
        LocalDate.now(), LocalTime.now(), DateTime.now().withZone(DateTimeZone.UTC), new BigDecimal("123.45"));
>>>>>>> 1.9.2

    ByteBuffer b = withLogicalTypes.toByteBuffer();
    TestRecordWithoutLogicalTypes.fromByteBuffer(b);
  }
}
