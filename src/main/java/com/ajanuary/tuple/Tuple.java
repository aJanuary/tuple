package com.ajanuary.tuple;

import java.util.Arrays;

/**
 * Represents an immutable tuple of objects, not necessarily all of the same type.
 * <p>
 * Tuples are shallowly immutable; once initialised, the references cannot be changed, but the objects it references may themselves change.
 * <p>
 * Designed to be extended by other classes that provide strong typing and sensible naming of the fields for the particular domain.
 * <p>
 * Provides {@link Object#hashCode() hashCode()}, {@link Object#equals(Object) equals(Object)} and {@link Object#toString() toString()} implementations for derived classes.
 * <p>
 * Tuples are considered equal if they are instances of the same class, and all their values are equal.
 * Derived classes may change this behaviour to allow for mixed-type comparisons. 
 * <p>
 * <b>Example</b>
 * <code><pre>
 * public class Employee extends Tuple {
 *   public Employee(String name, Position position, LocalDate dob) { super(name, position, dob); }
 *   public String name() { return get(0); }
 *   public Position position() { return get(1); }
 *   public LocalDate dob() { return get(2); }
 * }
 * </pre></code>
 *
 */
public abstract class Tuple {
	private final Object[] values;
	
	/**
	 * Initialises the tuple with the given values.
	 * @param values values to initialise the tuple with
	 */
	protected Tuple(Object... values) {
		this.values = values;
	}
	
	/**
	 * Returns the value at the specified index.
	 * <p>
	 * This should be used by strongly typed and well named getters in the deriving class.
	 * @param index index of the value to get
	 * @param <T> type of the value. Must match the type of the object passed in at this index during the initialisation of the tuple
	 * @return the value at {@code index}
	 * @throws IndexOutOfBoundsException if {@code index} is < 0 or larger than the number of values the tuple was initialised with
	 */
	protected <T> T get(int index) {
		@SuppressWarnings("unchecked")
		T result = (T) values[index];
		return result;
	}
	
	/**
	 * Returns the number of values this tuple holds.
	 * @return the number of values this tuple holds
	 */
	protected int length() {
		return values.length;
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(values);
	}
		
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (other == this) {
			return true;
		}
		
		if (!canBeEqualTo(other.getClass())) {
			return false;
		}
		
		return Arrays.equals(values, ((Tuple) other).values);
	}
	
	/**
	 * Returns whether this class can be compared for equality with another class.
	 * <p>
	 * The default implementation is to only compare objects for equality if they are the exact same class.
	 * Subclasses may chose to override this behaviour to allow mixed-type comparisons.
	 * <p>
	 * <b>Example</b>
	 * <code><pre>
	 * public class Employee extends Tuple {
	 *   public Employee(String name, LocalDate dob) { super(name, dob); }
	 *   public String name() { return get(0); }
	 *   public LocalDate dob() { return get(1); }
	 
	 *   {@literal @}Override protected boolean canBeEqualTo(Class<?> otherClass) {
	 *     return Employee.class.isAssignableFrom(otherClass);
	 *   }
	 * }
	 * </pre></code>
	 * @param otherClass the class being compared for equality with
	 * @return {@code true} if this class can be compared to {@code otherClass}, otherwise {@code false}
	 */
	protected boolean canBeEqualTo(Class<?> otherClass) {
		return getClass() == otherClass;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null) {
				sb.append("<null>");
			} else {
				sb.append(values[i]);
			}
			if (i != values.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");
		
		return sb.toString();
	}
}
