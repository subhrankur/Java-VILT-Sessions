# Coding Challenge 2 — Designing an Abstract Vehicle System

## Difficulty

**Intermediate → Advanced**

## Topics Covered

* Abstract classes
* Abstract methods
* Concrete methods in abstract classes
* Constructors in abstract classes
* `extends`
* Method overriding
* Runtime polymorphism
* Upcasting
* `super`
* Encapsulation
* Template-style design
* `List<Vehicle>`
* Designing for specialization

---

# 1. Scenario

You are extending the **Vehicle Management System** from Challenge 1.

The system currently supports:

```text
Vehicle
   ▲
   │
  Car
   ▲
   │
  Suv
```

The development team has identified a design problem.

A generic `Vehicle` should contain common information and behavior such as:

* brand
* model
* mileage
* starting/stopping
* displaying basic information

However, the system cannot define a meaningful generic implementation for some operations.

For example:

> How should a generic vehicle calculate its travel cost?

A petrol vehicle, diesel vehicle, hybrid vehicle, and electric vehicle may all calculate their costs differently.

Therefore, the team wants `Vehicle` to become an **abstract class**.

---

# 2. Learning Objective

Your task is to redesign the existing hierarchy so that:

```text
                    Vehicle
                << abstract >>
                       ▲
                       │
              ┌────────┴────────┐
              │                 │
             Car          ElectricCar
              ▲
              │
             Suv
```

`Vehicle` provides the **common structure**, while subclasses provide specialized behavior.

The most important question this challenge addresses is:

> **When should a class be abstract?**

---

# 3. Requirement 1 — Make `Vehicle` Abstract

Change the existing `Vehicle` class into:

```text
abstract class Vehicle
```

The class should still contain common properties such as:

```text
brand
model
mileage
```

It should also retain appropriate constructors and common methods.

---

# 4. Requirement 2 — Prevent Direct Vehicle Creation

Because `Vehicle` is now abstract, the following should no longer be possible:

```text
new Vehicle(...)
```

Your design should force developers to create a concrete vehicle type instead.

For example:

```text
new Car(...)
new Suv(...)
```

The purpose is to communicate:

> `Vehicle` is a general abstraction, not a specific vehicle that should be instantiated directly.

---

# 5. Requirement 3 — Create an Abstract Method

Add an abstract method to `Vehicle`:

```text
calculateTravelCost(distance)
```

The method should have **no implementation in `Vehicle`**.

Conceptually:

```text
Vehicle
│
├── brand
├── model
├── mileage
│
├── start()
├── stop()
├── displayInfo()
│
└── calculateTravelCost()   ← abstract
```

The abstract method represents behavior that every concrete vehicle must provide, but which cannot be meaningfully implemented generically.

---

# 6. Requirement 4 — Car Must Implement the Abstract Method

`Car` extends `Vehicle`.

Therefore, `Car` must provide an implementation of:

```text
calculateTravelCost()
```

Use the same basic fuel calculation from Challenge 1:

```text
fuel required = distance / mileage
```

and:

```text
fuel cost = fuel required × fuel price
```

For the `Car`, apply an additional **5% operational cost**.

---

# 7. Requirement 5 — SUV Must Specialize the Calculation

`Suv` extends `Car`.

The SUV should override:

```text
calculateTravelCost()
```

and apply an additional **15% operational cost** to the base fuel calculation.

You should demonstrate that the SUV's implementation is different from the generic `Car` implementation.

---

# 8. Requirement 6 — Use `super`

Don't unnecessarily duplicate the calculation logic.

For example, your design should allow the SUV to conceptually do:

```text
Suv calculation
       │
       ▼
Car calculation
       │
       ▼
base calculation
       │
       ▼
apply SUV-specific adjustment
```

Use:

```text
super
```

where appropriate.

The goal is to demonstrate how a subclass can extend existing behavior instead of completely rewriting it.

---

# 9. Requirement 7 — Add a Concrete `ElectricCar`

Create a new class:

```text
ElectricCar
```

which extends:

```text
Vehicle
```

An electric car should **not** extend `Car`.

Why?

Because for this exercise:

```text
Car
```

represents a fuel-powered car.

Instead:

```text
Vehicle
├── Car
│   └── Suv
│
└── ElectricCar
```

The hierarchy becomes:

```text
                    Vehicle
                << abstract >>
                       ▲
                       │
              ┌────────┴────────┐
              │                 │
             Car          ElectricCar
              ▲
              │
             Suv
```

---

# 10. ElectricCar Calculation

`ElectricCar` should implement:

```text
calculateTravelCost()
```

using:

```text
energy consumed = distance / efficiency
```

where efficiency is measured in:

```text
km/kWh
```

Then:

```text
energy cost =
energy consumed × electricity price
```

For example:

```text
Distance: 300 km

Efficiency: 6 km/kWh

Electricity price: ₹10/kWh
```

Calculation:

```text
300 / 6
= 50 kWh
```

Therefore:

```text
50 × ₹10
= ₹500
```

---

# 11. Requirement 8 — Different Implementations, Same Contract

Now you have:

```text
Vehicle
   │
   ├── Car
   │    └── Suv
   │
   └── ElectricCar
```

All concrete vehicles must provide:

```text
calculateTravelCost()
```

But the calculation differs:

```text
Car
 ↓
Fuel-based calculation

Suv
 ↓
Fuel-based + SUV adjustment

ElectricCar
 ↓
Electricity-based calculation
```

This is a perfect demonstration of **polymorphism**.

---

# 12. Requirement 9 — Use a Parent Reference

In `Main`, create:

```text
Vehicle car = new Car(...);

Vehicle suv = new Suv(...);

Vehicle electricCar =
        new ElectricCar(...);
```

Notice that all three references have the same type:

```text
Vehicle
```

but point to different objects.

```text
Vehicle car
      │
      ▼
     Car

Vehicle suv
      │
      ▼
     Suv

Vehicle electricCar
      │
      ▼
 ElectricCar
```

---

# 13. Requirement 10 — Demonstrate Runtime Polymorphism

Call:

```text
calculateTravelCost()
```

through the `Vehicle` reference.

For example:

```text
car.calculateTravelCost(...)

suv.calculateTravelCost(...)

electricCar.calculateTravelCost(...)
```

The correct implementation must execute based on the **actual object**.

You should not use:

```text
instanceof
```

to decide which implementation to execute.

---

# 14. Requirement 11 — Use `List<Vehicle>`

Create:

```text
List<Vehicle>
```

and add:

```text
Car
Suv
ElectricCar
```

For example:

```text
vehicles
│
├── Car
├── Suv
├── ElectricCar
├── Car
└── Suv
```

Iterate through the list and invoke:

```text
calculateTravelCost()
```

The processing code should not care about the concrete vehicle type.

Conceptually:

```text
for each Vehicle
        │
        ▼
calculateTravelCost()
        │
        ├── Car → Car implementation
        │
        ├── Suv → Suv implementation
        │
        └── ElectricCar → ElectricCar implementation
```

---

# 15. Requirement 12 — Add a Concrete Method to `Vehicle`

The abstract class should not contain only abstract methods.

Add a concrete method such as:

```text
displayBasicInfo()
```

It should display:

```text
Brand
Model
```

and any other common information you consider appropriate.

This demonstrates an important property of abstract classes:

> An abstract class can contain both **abstract behavior** and **implemented behavior**.

---

# 16. Requirement 13 — Constructor in the Abstract Class

`Vehicle` should have a constructor responsible for initializing the common state.

For example:

```text
Vehicle
---------
brand
model
mileage
```

When a `Car` or `ElectricCar` is created, the parent constructor should be invoked.

Demonstrate constructor chaining:

```text
ElectricCar constructor
        ↓
Vehicle constructor
```

and:

```text
Suv constructor
        ↓
Car constructor
        ↓
Vehicle constructor
```

Use:

```text
super(...)
```

appropriately.

---

# 17. Expected Hierarchy

Your final class hierarchy should look approximately like this:

```text
                         Vehicle
                     << abstract >>
                            ▲
                            │
                   ┌────────┴────────┐
                   │                 │
                  Car          ElectricCar
                   ▲
                   │
                  Suv
```

The key difference from Challenge 1 is that `Vehicle` is no longer a concrete class.

---

# 18. Sample Data

Use:

### Car

```text
Brand: Honda
Model: City
Mileage: 18 km/l
```

### SUV

```text
Brand: Toyota
Model: Fortuner
Mileage: 12 km/l
```

### ElectricCar

```text
Brand: Tata
Model: Nexon EV
Efficiency: 6 km/kWh
```

Use:

```text
Distance = 300 km
Fuel Price = ₹100/litre
Electricity Price = ₹10/kWh
```

---

# 19. Expected Calculations

## Car

Base fuel consumption:

```text
300 / 18
≈ 16.67 litres
```

Base cost:

```text
16.67 × ₹100
≈ ₹1666.67
```

With 5% operational cost:

```text
≈ ₹1750
```

---

## SUV

Fuel consumption:

```text
300 / 12
= 25 litres
```

Base cost:

```text
25 × ₹100
= ₹2500
```

15% operational cost:

```text
₹2500 + ₹375
= ₹2875
```

---

## Electric Car

Energy consumption:

```text
300 / 6
= 50 kWh
```

Energy cost:

```text
50 × ₹10
= ₹500
```

---

# 20. Expected Output

Your output should be similar to:

```text
========================================
        VEHICLE TRAVEL COST
========================================

Car
----------------------------------------
Brand       : Honda
Model       : City
Mileage     : 18 km/l
Travel Cost : ₹1750.00


SUV
----------------------------------------
Brand       : Toyota
Model       : Fortuner
Mileage     : 12 km/l
Travel Cost : ₹2875.00


Electric Car
----------------------------------------
Brand       : Tata
Model       : Nexon EV
Efficiency  : 6 km/kWh
Travel Cost : ₹500.00
```

---

# 21. Demonstrate Polymorphism Clearly

Add a section in `Main` that demonstrates:

```text
Vehicle vehicle = new Suv(...);
```

Then invoke:

```text
vehicle.calculateTravelCost(...);
```

Your output should make it obvious that the SUV implementation executes.

Then repeat with:

```text
Vehicle vehicle =
        new ElectricCar(...);
```

and demonstrate that the electric-car implementation executes.

---

# 22. Important Constraints

## Constraint 1 — `Vehicle` must be abstract

Do not leave it as:

```text
class Vehicle
```

It should be:

```text
abstract class Vehicle
```

---

## Constraint 2 — `calculateTravelCost()` must be abstract

Don't provide a generic implementation in `Vehicle`.

The point of the exercise is that every concrete vehicle must decide how the calculation works.

---

## Constraint 3 — No `instanceof`

Do not write:

```text
if (vehicle instanceof Car)
```

or:

```text
if (vehicle instanceof ElectricCar)
```

Polymorphism must handle the behavior.

---

## Constraint 4 — Don't duplicate common state

`brand` and `model` should remain part of the common `Vehicle` abstraction.

Don't redefine them unnecessarily in:

```text
Car
Suv
ElectricCar
```

---

## Constraint 5 — Don't duplicate common methods

If `displayBasicInfo()` belongs naturally to every vehicle, implement it once in `Vehicle`.

Don't copy it into every subclass.

---

# 23. Questions for the Trainee

Before implementing, answer these.

### Question 1

Why should `Vehicle` be abstract?

---

### Question 2

Why does `calculateTravelCost()` make sense as an abstract method?

---

### Question 3

Can an abstract class have a constructor?

Explain why.

---

### Question 4

Can an abstract class contain concrete methods?

Give an example from this challenge.

---

### Question 5

Why should `ElectricCar` extend `Vehicle` rather than `Car`?

---

### Question 6

Why is this valid?

```text
Vehicle vehicle = new ElectricCar(...);
```

---

### Question 7

What happens when this executes?

```text
Vehicle vehicle = new Suv(...);

vehicle.calculateTravelCost(...);
```

Which method executes and why?

---

### Question 8

What is the difference between:

```text
abstract method
```

and:

```text
concrete method
```

in an abstract class?

---

# 24. Bonus Challenge — Template Method

If the trainee finishes early, introduce a more advanced requirement.

Add a common method to `Vehicle`:

```text
estimateTripCost(distance)
```

The method should perform common steps such as:

```text
1. Validate distance
2. Display vehicle information
3. Calculate travel cost
4. Display result
```

But the actual calculation should be delegated to:

```text
calculateTravelCost()
```

which remains abstract.

Conceptually:

```text
Vehicle
│
├── estimateTripCost()       ← common algorithm
│       │
│       └── calculateTravelCost()
│                    ↑
│                    │
│             abstract method
│                    │
│       ┌────────────┼────────────┐
│       │            │            │
│      Car          Suv     ElectricCar
```

This is a simple introduction to the **Template Method design pattern**.

Don't implement this bonus unless the trainee understands the basic abstract-class challenge first.

---

# 25. Skills Being Evaluated

| Concept                 | Expected Demonstration                   |
| ----------------------- | ---------------------------------------- |
| Abstract class          | `Vehicle` is abstract                    |
| Abstract method         | `calculateTravelCost()`                  |
| Concrete method         | `displayBasicInfo()`                     |
| Constructor             | Common state initialized by `Vehicle`    |
| `super()`               | Parent constructor invocation            |
| Inheritance             | `Car`, `Suv`, `ElectricCar`              |
| Method overriding       | Specialized cost calculations            |
| Runtime polymorphism    | `Vehicle` references                     |
| Upcasting               | `Vehicle v = new Suv()`                  |
| Encapsulation           | Vehicle state protected                  |
| Collection polymorphism | `List<Vehicle>`                          |
| Specialization          | Different cost algorithms                |
| Design                  | Common behavior centralized in `Vehicle` |

---

# Deliverable

The trainee should have approximately:

```text
src/
└── com/
    └── example/
        └── inheritance/
            ├── Vehicle.java
            ├── Car.java
            ├── Suv.java
            ├── ElectricCar.java
            └── Main.java
```

The trainee should **not modify the existing architecture unnecessarily**. The goal is to evolve the existing project from:

```text
Concrete Vehicle
      ↓
Inheritance
      ↓
Polymorphism
```

into:

```text
Abstract Vehicle
      ↓
Abstract behavior
      ↓
Concrete implementations
      ↓
Polymorphism
```