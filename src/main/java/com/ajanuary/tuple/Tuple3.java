package com.ajanuary.tuple;

/**
 * Represents a triple of values, not necessarily of the same type.
 * <p>
 * Tuples are shallowly immutable; once initialised, the references cannot be changed, but the objects it references may themselves change.
 * <p>
 * Can to be extended by other classes to provide sensible naming of the fields for the particular domain.
 * <p>
 * <b>Example</b>
 * <code><pre>
 * public class Segment extends Tuple3<String, Integer, Integer> {
 *   public Segment(String label, Long start, Long end) { super(label, start, end); }
 *   public String label() { return first(); }
 *   public Long start() { return second(); }
 *   public Long end() { return third(); }
 * }
 * </pre></code>
 *
 * @param <A> type of the first value
 * @param <B> type of the second value
 * @param <C> type of the third value
 */
public abstract class Tuple3<A, B, C> extends Tuple {
	/**
	 * Creates a triple of values.
	 * @param first the first value
	 * @param second the second value
	 * @param third the third value
	 */
	protected Tuple3(A first, B second, C third) {
		super(first, second, third);
	}
	
	/**
	 * Returns the first value.
	 * @return the first value
	 */
	@SuppressWarnings("unchecked")
	protected A first() {
		return (A) get(0);
	}
	
	/**
	 * Returns the second value.
	 * @return the second value
	 */
	@SuppressWarnings("unchecked")
	protected B second() {
		return (B) get(1);
	}
	
	/**
	 * Returns the third value.
	 * @return the third value
	 */
	@SuppressWarnings("unchecked")
	protected C third() {
		return (C) get(2);
	}
}
