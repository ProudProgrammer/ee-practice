package hu.gaborbalazs.practice.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathHelperTest {

	@Test
	public void testAdd() {
		int result = MathHelper.add(2, 3);
		int expected = 5;
		assertEquals(expected, result);
	}
}
