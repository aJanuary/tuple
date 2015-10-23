package com.ajanuary.tuple;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TripleTest {
	@Test
	public void canChangeFirstValue() {
		Triple<String, String, String> t1 = new Triple<String, String, String>("A", "B", "C");
		Triple<String, String, String> t2 = t1.withFirst("D");
		assertEquals(new Triple<String, String, String>("D", "B", "C"), t2);
	}
	
	@Test
	public void canChangeSecondValue() {
		Triple<String, String, String> t1 = new Triple<String, String, String>("A", "B", "C");
		Triple<String, String, String> t2 = t1.withSecond("D");
		assertEquals(new Triple<String, String, String>("A", "D", "C"), t2);
	}
	
	@Test
	public void canChangeThirdValue() {
		Triple<String, String, String> t1 = new Triple<String, String, String>("A", "B", "C");
		Triple<String, String, String> t2 = t1.withThird("D");
		assertEquals(new Triple<String, String, String>("A", "B", "D"), t2);
	}

}
