package com.ajanuary.tuple;

import static org.junit.Assert.*;

import org.junit.Test;

public class TupleTest {
	class TestTupleA extends Tuple {
		public TestTupleA(int a, int b) {
			super(a, b);
		}
	}
	
	class TestTupleB extends Tuple {
		public TestTupleB(int a, int b) {
			super(a, b);
		}
	}
	
	class TestTupleC extends TestTupleA {
		public TestTupleC(int a, int b) {
			super(a, b);
		}
	}
	
	class TestTupleD extends Tuple {
		public TestTupleD(int a, int b) {
			super(a, b);
		}
		
		@Override
		protected boolean canBeEqualTo(Class<?> otherClass) {
			return TestTupleD.class.isAssignableFrom(otherClass);
		}
	}
	
	class TestTupleE extends TestTupleD {
		public TestTupleE(int a, int b) {
			super(a, b);
		}
	}
	
	class TestTupleF extends Tuple {
		public TestTupleF(String a, int b, boolean c) {
			super(a, b, c);
		}
		
		public <T> T get(int index) {
			return super.get(index);
		}
	}
	
	@Test
	public void canCompareEquality() {
		TestTupleA t1 = new TestTupleA(10, 20);
		TestTupleA t2 = new TestTupleA(10, 20);
		TestTupleA t3 = new TestTupleA(20, 10);
		
		assertTrue("t1 equals itself", t1.equals(t1));
		assertTrue("t1 and t2 are equal", t1.equals(t2));
		assertFalse("t1 and t3 are not equal", t1.equals(t3));
		assertFalse("t1 and null are not equal", t1.equals(null));
	}
	
	@Test
	public void tuplesWithSameTypeParametersArentEqual() {
		// Just because they're both <int, int> tuples doesn't mean they should be equal
		TestTupleA ta = new TestTupleA(10, 20);
		TestTupleB tb = new TestTupleB(10, 20);
		
		assertFalse("ta and tb are not equal", ta.equals(tb));
	}
	
	@Test
	public void tuplesCanOverrideComparisonType() {
		TestTupleD td = new TestTupleD(10, 20);
		TestTupleE te = new TestTupleE(10, 20);
		
		assertTrue("td and te are equal", td.equals(te));
		assertTrue("te and td are equal", te.equals(td));
	}
	
	@Test
	public void identicalTuplesHaveIdenticalHashcodes() {
		TestTupleA t1 = new TestTupleA(10, 20);
		TestTupleA t2 = new TestTupleA(10, 20);
		
		assertTrue("t1.hashCode() and t2.hashCode() are equal", t1.hashCode() == t2.hashCode());
	}
	
	@Test
	public void canMakeAStringRepresentation() {
		TestTupleF t = new TestTupleF(null, 10, false);
		assertEquals("(<null>, 10, false)", t.toString());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void gettingItemCanThrowIndexOutOfBounds() {
		new TestTupleF(null, 10, false).get(4);
	}
}
