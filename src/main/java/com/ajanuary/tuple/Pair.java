package com.ajanuary.tuple;

/**
 * Represents an immutable pair of values, not necessarily of the same type.
 * <p>
 * Pairs are shallowly immutable; once initialised, the references cannot be changed, but the objects it references may themselves change.
 * <p>
 * To provide sensible naming for the fields in a particular domain, consider creating a class that extends {@link Tuple2}.
**/
public final class Pair<A, B> extends Tuple2<A, B> {
	/**
	 * Creates a pair of values
	 * @param first the first value
	 * @param second the second value
	 */
	public Pair(A first, B second) {
		super(first, second);
	}
	
	@Override
	public A first() {
		return super.first();
	}
	
	/**
	 * Return a copy of this pair with a new first value.
	 * @param first the new first value
	 * @return a copy of this pair, but with {@code first} as the new first value
	 */
	public Pair<A, B> withFirst(A first) {
		return new Pair<A, B>(first, second());
	}
	
	@Override
	public B second() {
		return super.second();
	}

	/**
	 * Return a copy of this pair with a new second value.
	 * @param second the new second value
	 * @return a copy of this pair, but with {@code second} as the new second value
	 */
	public Pair<A, B> withSecond(B second) {
		return new Pair<A, B>(first(), second);
	}
}
