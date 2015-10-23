package com.ajanuary.tuple;

/**
 * Represents an immutable pair of values, not necessarily of the same type.
 * <p>
 * Tuples are shallowly immutable; once initialised, the references cannot be changed, but the objects it references may themselves change.
 * <p>
 * Can be extended by other classes to provide sensible naming of the fields for the particular domain.
 * <p>
 * Provides {@link Object#hashCode() hashCode()}, {@link Object#equals(Object) equals(Object)} and {@link Object#toString() toString()} implementations for derived classes.
 * <p>
 * <b>Example</b>
 * <code><pre>
 * public class Result extends Tuple2<Integer, String> {
 *   public Result(Integer code, String msg) { super(code, msg); }
 *   public Integer code() { return first(); }
 *   public String msg() { return second(); }
 * }
 * </pre></code>
 *
 * @param <A> type of the first value
 * @param <B> type of the second value
 */
public abstract class Tuple2<A, B> extends Tuple {
	/**
	 * Creates a pair of values.
	 * @param first the first value
	 * @param second the second value
	 */
	protected Tuple2(A first, B second) {
		super(first, second);
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
}
