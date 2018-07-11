package eu.twino.dw;

import eu.twino.exception.TwinoException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TableTest {

	@Test
	public void arrayEquals_Success() {
		String[][] array = {
				{"11", "12"},
				{"21", "22"}
		};

		Dataware dataware = new Table(2, 2);
		dataware.put(1, 1, "11");
		dataware.put(1, 2, "21");
		dataware.put(2, 1, "12");
		dataware.put(2, 2, "22");

		assertArrayEquals(((Table) dataware).getTable(), array);

	}

	@Test
	public void putAndGet_Success() {
		Dataware dataware = new Table(2,2);

		String put = dataware.put(2, 2, "1");
		assertNull(put); // пердыдущее значение было null

		String get = dataware.get(2, 2);
		assertEquals("1", get); // заменили на '1', должно получиться '1';
	}

	@Test
	public void put_Failure() {
		Dataware dataware = new Table(2,2);

		try {
			dataware.put(3, 2, "test");
			Assert.fail();
		} catch (TwinoException e) {
			assertEquals("Некорректно задано значение столбца", e.getMessage());
		}

		try {
			dataware.put(2, 3, "test");
			Assert.fail();
		} catch (TwinoException e) {
			assertEquals("Некорректно задано значение строки", e.getMessage());
		}

		try {
			dataware.put(3, 3, "test");
			Assert.fail();
		} catch (TwinoException e) {
			assertEquals("Некорректно заданы значения строки и столбца", e.getMessage());
		}
	}

	@Test
	public void get_Failure() {
		Dataware dataware = new Table(2,2);

		try {
			dataware.get(3, 2);
			Assert.fail();
		} catch (TwinoException e) {
			assertEquals("Некорректно задано значение столбца", e.getMessage());
		}

		try {
			dataware.get(2, 3);
			Assert.fail();
		} catch (TwinoException e) {
			assertEquals("Некорректно задано значение строки", e.getMessage());
		}

		try {
			dataware.get(3, 3);
			Assert.fail();
		} catch (TwinoException e) {
			assertEquals("Некорректно заданы значения строки и столбца", e.getMessage());
		}
	}
}
