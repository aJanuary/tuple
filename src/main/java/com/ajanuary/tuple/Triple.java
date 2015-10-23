package com.ajanuary.tuple;

/**
 * Represents an immutable triple of values, not necessarily of the same type.
 * <p>
 * Triples are shallowly immutable; once initialised, the references cannot be changed, but the objects it references may themselves change.
 * <p>
 * To provide sensible naming for the fields in a particular domain, consider creating a class that extends {@link Tuple3}.
**/
public final class Triple<A, B, C> extends Tuple3<A, B, C> {
	/**
	 * Creates a triple of values
	 * @param first the first value
	 * @param second the second value
	 * @param third the third value
	 */
	public Triple(A first, B second, C third) {
		super(first, second, third);
	}
	
	@Override
	public A first() {
		return super.first();
	}
	
	/**
	 * Return a copy of this triple with a new first value.
	 * @param first the new first value
	 * @return a copy of this triple, but with {@code first} as the new first value
	 */
	public Triple<A, B, C> withFirst(A first) {
		return new Triple<A, B, C>(first, second(), third());
	}
	
	@Override
	public B second() {
		return super.second();
	}
	
	/**
	 * Return a copy of this triple with a new second value.
	 * @param first the new second value
	 * @return a copy of this triple, but with {@code second} as the new second value
	 */
	public Triple<A, B, C> withSecond(B second) {
		return new Triple<A, B, C>(first(), second, third());
	}

	@Override
	public C third() {
		return super.third();
	}
	
	/**
	 * Return a copy of this triple with a new third value.
	 * @param first the new third value
	 * @return a copy of this triple, but with {@code third} as the new third value
	 */
	public Triple<A, B, C> withThird(C third) {
		return new Triple<A, B, C>(first(), second(), third);
	}
}
