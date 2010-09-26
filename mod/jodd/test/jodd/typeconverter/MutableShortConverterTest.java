// Copyright (c) 2003-2010, Jodd Team (jodd.org). All Rights Reserved.

package jodd.typeconverter;

import jodd.mutable.MutableShort;
import junit.framework.TestCase;
import jodd.mutable.MutableInteger;

public class MutableShortConverterTest extends TestCase {

	public void testConversion() {
		assertNull(MutableShortConverter.valueOf(null));

		assertEquals(new MutableShort((short)1), MutableShortConverter.valueOf(new MutableShort(1)));
		assertEquals(new MutableShort((short)1), MutableShortConverter.valueOf(Integer.valueOf(1)));
        assertEquals(new MutableShort((short)1), MutableShortConverter.valueOf(Short.valueOf((short) 1)));
		assertEquals(new MutableShort((short)1), MutableShortConverter.valueOf(Double.valueOf(1.0D)));
		assertEquals(new MutableShort((short)1), MutableShortConverter.valueOf("1"));

		try {
			MutableShortConverter.valueOf("a");
			fail();
		} catch (TypeConversionException ignore) {
		}
	}
}
