package com.ajanuary.tuple;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {
	@Test
	public void canChangeFirstValue() {
		Pair<String, String> p1 = new Pair<String, String>("A", "B");
		Pair<String, String> p2 = p1.withFirst("C");
		assertEquals(new Pair<String, String>("C", "B"), p2);
	}
	
	@Test
	public void canChangeSecondValue() {
		Pair<String, String> p1 = new Pair<String, String>("A", "B");
		Pair<String, String> p2 = p1.withSecond("C");
		assertEquals(new Pair<String, String>("A", "C"), p2);
	}
}
