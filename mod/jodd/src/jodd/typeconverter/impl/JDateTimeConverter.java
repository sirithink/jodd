// Copyright (c) 2003-2010, Jodd Team (jodd.org). All Rights Reserved.

package jodd.typeconverter.impl;

import jodd.datetime.JDateTime;
import jodd.datetime.JulianDateStamp;
import jodd.typeconverter.TypeConversionException;
import jodd.typeconverter.TypeConverter;

/**
 * Converts object to {@link JDateTime}.
 */
public class JDateTimeConverter implements TypeConverter<JDateTime> {

	public static JDateTime valueOf(Object value) {
		if (value == null) {
			return null;
		}

		if (value instanceof JDateTime) {
			return (JDateTime) value;
		}
		if (value instanceof Number) {
			return new JDateTime(((Number) value).longValue());
		}
		if (value instanceof String) {
			return new JDateTime((String) value);
		}
		if (value instanceof JulianDateStamp) {
			return new JDateTime((JulianDateStamp) value);
		}

		try {
			return new JDateTime(value);
		} catch (IllegalArgumentException iaex) {
			throw new TypeConversionException(value, iaex);
		}
	}

	public JDateTime convert(Object value) {
		return valueOf(value);
	}
}