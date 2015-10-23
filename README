# tuple

A Java library providing tuples.

Tuples are immutable and heterogeneous value containers. They are shallowly immutable, meaning which objects they contain cannot change, but those contained objects may themselves change.

## Classes
All classes are in the `com.ajanuary.tuple` namespace.

### Tuple
The base class is the `Tuple` class, which can contain any number of values. It is abstract, with the intention that derived classes provide strong typing and sensible naming of the fields for their particular domain.

It provides an implementation of `hashCode`, `equals` and `toString` for derived classes.

```java
public class Employee extends Tuple {
    public Employee(String name, Position position, LocalDate dob) {
        super(name, position, dob);
    }
    
    public String name() { return get(0); }
    public Position position() { return get(1); }
    public LocalDate dob() { return get(2); }
}
```

The `get` method does not check the type it is casting to; it is up to the deriving class to ensure the types line up to avoid a `ClassCastException` being thrown.

### Tuple2 and Tuple3
Because it is so common to use tuples of size 2 and 3, the `Tuple2` and `Tuple3` classes are provided to add stronger typing. Like `Tuple`, these should be extended to provide sensible naming of the fields.

```java
public class Result extends Tuple2<Integer, String> {
    public Result(Integer code, String msg) {
        super(code, msg);
    }
    
    public Integer code() { return first(); }
    public String msg() { return second(); }
}
```

### Pair and Triple
In some scenarios there is little value in creating new classes with named fields. For these cases, the library provides the `Pair` and `Triple` classes, which are concrete implementations of `Tuple2` and `Tuple3`.

```java
public static void main(String[] args) {
    Pair<String, Integer> best = new Pair<String, Integer>();
    for (String candidate : getCandidates()) {
        int candidateScore = score(candidate);
        if (candidateScore > best.second()) {
            best = new Pair<String, Integer>(candidate, candidateScore);
        }
    }
    System.out.println(best.first());
}
```

It is recommended the `Pair` and `Triple` classes are limited to internal code where the meaning of `first()` and `second()` can be easily derived from context.

## Equality
Tuple objects are considered equal if their values are equal. By default, they are only equal if they are also instances of the same class. If a derived class needs to implement mixed-type comparisons, it can do so by overriding the `canBeEqualTo` method.

```java
public class Vehicle extends Tuple2<String, Integer> {
    public Vehicle(String brand, Integer numWheels) {
        super(brand, numWheels);
    }
    
    public String brand() { return first(); }
    public Integer numWheels() { return second(); }
    
    @Override
    protected boolean canBeEqualTo(Class<?> otherClass) {
        return Vehicle.class.isAssignableFrom(otherClass);
    }
}

public class Bike extends Vehicle {
    public Bike(String brand) {
        super(brand, 2);
    }
}

public class App(String[] args) {
    Vehicle trekVehicle = new Vehicle("Trek", 2);
    Bike trekBike = new Bike("Trek");
    
    System.out.println(trekVehicle.equals(trekBike)); // true
}
```
