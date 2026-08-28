# Coding Challenge 1 — Vehicle Service & Polymorphism

## Difficulty

**Intermediate**

## Topics Covered

* Class inheritance
* `extends`
* IS-A relationship
* Method overriding
* `@Override`
* Runtime polymorphism
* Upcasting
* Dynamic method dispatch
* `super`
* Encapsulation
* Parent-class references
* Collections of parent types

---

# 1. Scenario

You are building a simple **Vehicle Management System**.

Your existing application already contains:

```text
Vehicle
   ▲
   │
  Car
   ▲
   │
  Suv
```

The existing classes represent different levels of specialization.

Now the application needs to support a common operation:

> **Every vehicle should be able to display its information and calculate its estimated travel cost.**

However, different vehicle types calculate their travel cost differently.

For example:

* A generic vehicle uses a basic fuel-cost calculation.
* A `Car` has additional efficiency considerations.
* An `Suv` has higher fuel consumption and therefore a different calculation.

Your job is to implement this using **inheritance and polymorphism**.

---

# 2. Learning Objective

By completing this challenge, you should be able to demonstrate:

```text
                    Vehicle
                       ▲
                       │
                      Car
                       ▲
                       │
                      Suv
```

and understand that:

```java
Vehicle vehicle = new Suv(...);
```

is valid because:

```text
Suv IS-A Vehicle
```

You should also demonstrate that when an overridden method is called:

```java
vehicle.calculateTravelCost(...);
```

Java executes the implementation belonging to the **actual object**, not the reference type.

---

# 3. Functional Requirements

## Requirement 1 — Add `calculateTravelCost()`

Add a method to `Vehicle`:

```text
calculateTravelCost(distance, fuelPrice)
```

The method should calculate the estimated fuel cost.

Use:

```text
fuel required = distance / mileage
```

and:

```text
travel cost = fuel required × fuel price
```

For example:

```text
Distance = 300 km
Mileage  = 15 km/l
Fuel     = ₹100/l
```

Then:

```text
Fuel required = 300 / 15
              = 20 litres

Travel cost = 20 × 100
            = ₹2000
```

---

# 4. Requirement 2 — Vehicle Mileage

`Vehicle` should maintain a mileage value.

For example:

```text
Vehicle
---------
brand
model
mileage
```

Mileage should not be directly accessible from outside the class.

Apply appropriate **encapsulation**.

---

# 5. Requirement 3 — Override the Calculation in `Car`

`Car` should override:

```text
calculateTravelCost()
```

The `Car` implementation should apply a **5% additional cost** compared with the basic vehicle calculation.

For example:

```text
Vehicle calculation = ₹2000

Car calculation:

₹2000 + 5%
= ₹2100
```

Use method overriding.

The implementation should be marked with:

```java
@Override
```

---

# 6. Requirement 4 — Override Again in `Suv`

`Suv` should override:

```text
calculateTravelCost()
```

An SUV should have a **15% additional cost** compared with the base calculation.

For example:

```text
Vehicle calculation = ₹2000

Suv calculation:

₹2000 + 15%
= ₹2300
```

The important point is that `Suv` should have its own implementation.

---

# 7. Requirement 5 — Use `super`

Your `Car` implementation should use the parent implementation instead of duplicating the entire calculation.

Conceptually:

```text
Car
 │
 └── calculateTravelCost()
          │
          ├── call Vehicle calculation
          │
          └── add 5%
```

Similarly, `Suv` should use the appropriate inherited behavior and then apply its additional cost.

The purpose of this requirement is to demonstrate:

```java
super.calculateTravelCost(...)
```

rather than duplicating logic.

---

# 8. Requirement 6 — Demonstrate Upcasting

In `Main`, create an SUV:

```text
Suv suv = ...
```

Then create a parent reference:

```text
Vehicle vehicle = suv;
```

Do **not** create another SUV.

Both references should point to the same object.

Demonstrate:

```text
Suv reference
       │
       ▼
   ┌─────────┐
   │   Suv   │
   └─────────┘
       ▲
       │
Vehicle reference
```

---

# 9. Requirement 7 — Demonstrate Runtime Polymorphism

Using:

```text
Vehicle vehicle = new Suv(...);
```

call:

```text
calculateTravelCost(...)
```

The output must use the **`Suv` implementation**.

Do not explicitly cast the object back to `Suv`.

The objective is to demonstrate:

> The reference type is `Vehicle`, but the actual object is `Suv`.

Therefore Java performs dynamic method dispatch.

---

# 10. Requirement 8 — Vehicle Collection

Create several vehicles:

```text
Vehicle
Car
Suv
```

Store them in:

```text
List<Vehicle>
```

For example:

```text
vehicles
 ├── Vehicle
 ├── Car
 ├── Suv
 ├── Car
 └── Suv
```

Iterate over the collection and call:

```text
calculateTravelCost()
```

on every object.

You should **not** write:

```text
if object is Car
    call Car method

else if object is Suv
    call Suv method
```

The polymorphic method call should automatically select the correct implementation.

---

# 11. Expected Concept

Your code should demonstrate this:

```text
List<Vehicle>
      │
      ├── Vehicle ──→ Vehicle.calculateTravelCost()
      │
      ├── Car ──────→ Car.calculateTravelCost()
      │
      ├── Suv ──────→ Suv.calculateTravelCost()
      │
      ├── Car ──────→ Car.calculateTravelCost()
      │
      └── Suv ──────→ Suv.calculateTravelCost()
```

Even though every object is referenced as:

```text
Vehicle
```

the appropriate overridden implementation executes.

---

# 12. Sample Input

Use the following test data:

```text
Vehicle:
Brand: Tata
Model: Ace
Mileage: 20 km/l

Car:
Brand: Honda
Model: City
Mileage: 18 km/l

Suv:
Brand: Toyota
Model: Fortuner
Mileage: 12 km/l

Distance: 300 km
Fuel Price: ₹100/litre
```

---

# 13. Expected Base Calculations

For the `Vehicle`:

```text
300 / 20 = 15 litres

15 × 100 = ₹1500
```

For the `Car`:

```text
300 / 18 = 16.67 litres

16.67 × 100
≈ ₹1666.67

5% additional cost
≈ ₹1750
```

For the `Suv`:

```text
300 / 12 = 25 litres

25 × 100
= ₹2500

15% additional cost
= ₹2875
```

Your implementation may format the numbers differently, but the calculations should be equivalent.

---

# 14. Expected Output

Your program should produce output similar to:

```text
===== Vehicle Travel Cost =====

Tata Ace
Mileage: 20 km/l
Travel Cost: ₹1500.00


===== Car Travel Cost =====

Honda City
Mileage: 18 km/l
Travel Cost: ₹1750.00


===== SUV Travel Cost =====

Toyota Fortuner
Mileage: 12 km/l
Travel Cost: ₹2875.00
```

When demonstrating polymorphism, the output should make it clear that the correct implementation was selected.

For example:

```text
Reference Type : Vehicle
Actual Type    : Suv
Calculation    : Suv.calculateTravelCost()
Travel Cost    : ₹2875.00
```

---

# 15. Important Constraints

These constraints are part of the challenge.

### Constraint 1

Do **not** create unrelated vehicle classes.

Use the existing hierarchy:

```text
Vehicle
   ↓
Car
   ↓
Suv
```

### Constraint 2

Do not duplicate the complete travel-cost calculation in every class.

Use:

```text
super
```

where appropriate.

### Constraint 3

Do not use:

```text
instanceof
```

to determine which calculation to execute.

### Constraint 4

Do not use:

```text
if (vehicle instanceof Car)
```

or:

```text
if (vehicle instanceof Suv)
```

for polymorphic behavior.

### Constraint 5

Do not use static methods for:

```text
calculateTravelCost()
```

The challenge is specifically about **runtime polymorphism**.

---

# 16. Questions to Think About

Before coding, answer these questions.

### Question 1

Why is this valid?

```text
Vehicle vehicle = new Suv(...);
```

---

### Question 2

If:

```text
Vehicle vehicle = new Suv(...);
```

and both `Vehicle` and `Suv` have:

```text
calculateTravelCost()
```

which implementation executes?

---

### Question 3

Why doesn't Java simply execute:

```text
Vehicle.calculateTravelCost()
```

because the reference type is `Vehicle`?

---

### Question 4

What is the difference between:

```text
Vehicle vehicle = new Suv(...);
```

and:

```text
Suv vehicle = new Suv(...);
```

---

### Question 5

Why is this preferable:

```text
List<Vehicle>
```

over:

```text
List<Suv>
```

if the application needs to process multiple vehicle types?

---

# 17. Bonus Challenge

Add another subclass:

```text
ElectricCar
```

It should extend:

```text
Car
```

and override:

```text
calculateTravelCost()
```

For an electric vehicle, instead of fuel:

```text
energy consumed = distance / efficiency
```

where efficiency is:

```text
km/kWh
```

and:

```text
energy cost = energy consumed × electricity price
```

Then add it to:

```text
List<Vehicle>
```

without changing the existing processing loop.

The existing code should automatically work:

```text
for each Vehicle
    calculateTravelCost()
```

This is the real test of whether your design demonstrates polymorphism correctly.

---

# 18. Skills Being Evaluated

| Concept              | What the trainee must demonstrate                     |
| -------------------- | ----------------------------------------------------- |
| Inheritance          | `Car extends Vehicle`, `Suv extends Car`              |
| IS-A                 | `Suv` is a `Car` and `Vehicle`                        |
| Encapsulation        | Mileage/state appropriately protected                 |
| Overriding           | Each specialized class provides its behavior          |
| `@Override`          | Correctly used                                        |
| `super`              | Parent implementation reused                          |
| Upcasting            | `Vehicle v = new Suv(...)`                            |
| Runtime polymorphism | Correct method executes at runtime                    |
| Dynamic dispatch     | No type-checking required                             |
| Collections          | `List<Vehicle>` handles multiple subclasses           |
| Open/closed thinking | New subclasses work without changing processing logic |

---

## Deliverable

The trainee should submit:

```text
src/
└── com/
    └── example/
        └── inheritance/
            ├── Vehicle.java
            ├── Car.java
            ├── Suv.java
            └── Main.java
```

plus, if attempting the bonus:

```text
            └── ElectricCar.java
```

The important part isn't simply getting the numerical output. **The solution should demonstrate the OOP concepts explicitly through the existing inheritance hierarchy.**

---
