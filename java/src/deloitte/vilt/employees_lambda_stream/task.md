# Java Collections — List vs Set

A hands-on Java Collections exercise that implements the **same Employee Management requirement in two different ways**:

- **Implementation A:** using `List`
- **Implementation B:** using `Set`

The project is intentionally provided as a **structure-first exercise**. The Java classes contain comments describing what trainees should implement; no solution code is provided.

## Learning Goals

This project combines:

- Java Collections
- `List`
- `ArrayList`
- `Set`
- `HashSet`
- `LinkedHashSet`
- `TreeSet`
- Java Records
- Enums
- Custom exceptions
- Exception handling
- `Comparable`
- `Comparator`
- Collection sorting
- Collection-specific duplicate handling

> **Constraint:** Do not use the Java Streams API in this project.

---

# Business Scenario

Build an Employee Management System.

Each employee has:

- Employee ID
- Name
- Department
- Salary
- Years of experience

The application must support:

1. Adding an employee
2. Removing an employee
3. Finding an employee by ID
4. Displaying all employees
5. Detecting duplicate employees
6. Sorting employees
7. Handling invalid operations using custom exceptions

The important part of this exercise is that the **same requirements must be implemented twice**.

---

# Two Implementations

## A. List Implementation

Use a `List<Employee>` as the underlying collection.

Recommended implementation:

```text
ArrayList
```

Because a List permits duplicates, the implementation must decide how to prevent duplicate employee IDs.

Trainees should explicitly implement the duplicate-ID validation.

---

## B. Set Implementation

Use a `Set<Employee>` as the underlying collection.

Recommended implementations for experimentation:

```text
HashSet
LinkedHashSet
TreeSet
```

The Set implementation should demonstrate how uniqueness is different from List-based storage.

---

# Important Constraint — No Streams

Do **not** use:

```text
Stream
stream()
parallelStream()
filter()
map()
collect()
```

All searching, filtering, iteration and manipulation should be implemented using:

- `for`
- enhanced `for`
- `Iterator`
- collection methods
- `Comparator`
- `Comparable`

This is intentional so that trainees understand the Collection APIs before using the Streams API.

---

# Employee Record

The model should be a Java `record`.

The record should contain:

```text
id
name
department
salary
experience
```

The record should also implement:

```text
Comparable<Employee>
```

The natural ordering should be based on:

```text
Employee ID
```

### Trainee task

Implement `compareTo()` so that employees have a natural ordering based on employee ID.

Also understand the automatically generated:

- constructor
- accessor methods
- `equals()`
- `hashCode()`
- `toString()`

---

# Sorting Enum

Instead of passing strings such as:

```text
"NAME"
"SALARY"
"EXPERIENCE"
```

create an enum representing the supported sorting fields.

Suggested values:

```text
ID
NAME
DEPARTMENT
SALARY
EXPERIENCE
```

The enum should be used by the manager classes to decide which `Comparator<Employee>` must be used.

This prevents magic strings and gives compile-time type safety.

---

# Comparator Design

Create separate Comparator implementations for the supported fields.

Suggested comparators:

```text
EmployeeIdComparator
EmployeeNameComparator
EmployeeDepartmentComparator
EmployeeSalaryComparator
EmployeeExperienceComparator
```

Each comparator should be responsible for comparing employees using one field.

The manager should receive the sorting enum and select the appropriate comparator.

Conceptually:

```text
SortField
   |
   +-- ID          -> ID Comparator
   +-- NAME        -> Name Comparator
   +-- DEPARTMENT  -> Department Comparator
   +-- SALARY      -> Salary Comparator
   +-- EXPERIENCE  -> Experience Comparator
```

Do not put all comparison logic directly into the manager.

---

# Exception Handling

Create custom exceptions for business failures.

## EmployeeAlreadyExistsException

Use this when an employee with the same employee ID already exists.

## EmployeeNotFoundException

Use this when an operation refers to an employee that does not exist.

## InvalidSortFieldException

Optional enhancement for invalid sorting requests.

The application entry point should demonstrate appropriate `try/catch` handling.

---

# Project Structure

```text
java-collections-list-vs-set
│
├── README.md
│
├── pom.xml
│
└── src
    └── main
        └── java
            └── com
                └── example
                    └── employees
                        │
                        ├── Main.java
                        │
                        ├── model
                        │   └── Employee.java
                        │
                        ├── sorting
                        │   ├── SortField.java
                        │   ├── EmployeeIdComparator.java
                        │   ├── EmployeeNameComparator.java
                        │   ├── EmployeeDepartmentComparator.java
                        │   ├── EmployeeSalaryComparator.java
                        │   └── EmployeeExperienceComparator.java
                        │
                        ├── exception
                        │   ├── EmployeeAlreadyExistsException.java
                        │   ├── EmployeeNotFoundException.java
                        │   └── InvalidSortFieldException.java
                        │
                        ├── list
                        │   └── ListEmployeeManager.java
                        │
                        └── set
                            └── SetEmployeeManager.java
```

---

# Class Responsibilities

## `Employee`

**Package:** `model`

Responsibility:

- Represent an employee using a Java record.
- Implement `Comparable<Employee>`.
- Define natural ordering using employee ID.

---

## `SortField`

**Package:** `sorting`

Responsibility:

- Define the supported sorting fields.
- Prevent magic strings from being used for sorting requests.

Suggested enum constants:

```text
ID
NAME
DEPARTMENT
SALARY
EXPERIENCE
```

---

## Comparator Classes

**Package:** `sorting`

Each comparator should have exactly one responsibility.

### `EmployeeIdComparator`

Compare employees using employee ID.

### `EmployeeNameComparator`

Compare employees using employee name.

### `EmployeeDepartmentComparator`

Compare employees using department.

### `EmployeeSalaryComparator`

Compare employees using salary.

### `EmployeeExperienceComparator`

Compare employees using experience.

---

# `ListEmployeeManager`

**Package:** `list`

Use:

```text
List<Employee>
```

Recommended implementation:

```text
ArrayList<Employee>
```

Responsibilities:

- Store employees.
- Add employees.
- Prevent duplicate IDs.
- Find employees by ID.
- Remove employees.
- Display employees.
- Sort employees using the requested `SortField`.

### Important exercise

Because List allows duplicates, implement duplicate-ID validation manually.

Do not rely on the List to prevent duplicates.

### Sorting

The manager should accept:

```text
SortField
```

and select the appropriate Comparator.

Do not use the Streams API.

---

# `SetEmployeeManager`

**Package:** `set`

Use:

```text
Set<Employee>
```

Start with:

```text
HashSet<Employee>
```

Then experiment with:

```text
LinkedHashSet<Employee>
TreeSet<Employee>
```

Responsibilities:

- Store employees.
- Add employees.
- Handle duplicates.
- Find employees by ID.
- Remove employees.
- Display employees.
- Sort or expose employees according to the selected sorting requirement.

### Important exercise

Observe the difference between:

```text
List
```

and:

```text
Set
```

The Set implementation naturally provides uniqueness based on equality semantics.

Because `Employee` is a record, its generated `equals()` and `hashCode()` should be considered when reasoning about duplicate employees.

---

# `Main`

**Package:** root package

Use this class to demonstrate the application.

The demonstration should:

1. Create sample employees.
2. Create the List implementation.
3. Create the Set implementation.
4. Add employees.
5. Attempt to add a duplicate.
6. Find an employee.
7. Attempt to find a missing employee.
8. Remove an employee.
9. Attempt to remove a missing employee.
10. Display employees.
11. Sort by ID.
12. Sort by name.
13. Sort by department.
14. Sort by salary.
15. Sort by experience.
16. Catch and display custom exceptions.

---

# Expected Demonstration

The application should clearly show that both implementations provide the same business functionality.

```text
========================================
LIST IMPLEMENTATION
========================================

Add employee
Add employee
Attempt duplicate
Find employee
Find missing employee
Remove employee
Sort by ID
Sort by NAME
Sort by SALARY
Sort by EXPERIENCE


========================================
SET IMPLEMENTATION
========================================

Add employee
Add employee
Attempt duplicate
Find employee
Find missing employee
Remove employee
Sort by ID
Sort by NAME
Sort by SALARY
Sort by EXPERIENCE
```

---

# Comparable vs Comparator

This project deliberately demonstrates the difference.

## Comparable

`Employee` implements:

```text
Comparable<Employee>
```

Use it to define the employee's **natural ordering**.

For this project:

```text
Employee ID
```

is the natural ordering.

Conceptually:

```text
Employee
   |
   +-- Comparable
          |
          +-- compareTo()
                 |
                 +-- ID
```

---

## Comparator

`Comparator` is used when the caller wants a different ordering.

Examples:

```text
SortField.NAME
SortField.SALARY
SortField.EXPERIENCE
SortField.DEPARTMENT
```

Conceptually:

```text
Employee
   |
   +-- Comparable
   |      |
   |      +-- Natural ordering
   |             |
   |             +-- ID
   |
   +-- Comparator
          |
          +-- Name
          +-- Department
          +-- Salary
          +-- Experience
```

---

# Why Use an Enum for Sorting?

Avoid:

```text
sort("salary")
sort("Salary")
sort("SALARY")
```

These approaches are error-prone because of spelling and casing.

Instead use:

```text
SortField.SALARY
```

Benefits:

- Type safety
- No magic strings
- IDE autocomplete
- Easier refactoring
- Clearly defined supported values

---

# List vs Set — Key Learning

The two implementations intentionally solve the same problem using different collection abstractions.

| Requirement | List | Set |
|---|---|---|
| Duplicate elements | Allowed | Not allowed |
| Index access | Yes | No |
| Insertion order | ArrayList preserves it | LinkedHashSet preserves it |
| Natural sorted collection | No | TreeSet |
| Manual duplicate-ID validation | Required | Collection equality semantics |
| Search by ID | Iterate/search | Iterate/search |
| Custom sorting | Comparator | Comparator |
| Natural sorting | Comparable | Comparable |
| Primary purpose | Ordered sequence | Unique elements |

---

# Trainee Exercises

## Exercise 1 — Basic List Implementation

Complete:

- Employee record
- List manager
- Add
- Find
- Remove
- Display

Do not use Streams.

---

## Exercise 2 — Basic Set Implementation

Complete the same operations using Set.

Compare the duplicate-handling behavior with List.

---

## Exercise 3 — Comparable

Implement natural employee ordering using employee ID.

Test both managers using natural ordering.

---

## Exercise 4 — Comparator

Implement all comparator classes.

Test:

- ID
- Name
- Department
- Salary
- Experience

---

## Exercise 5 — Enum-Based Sorting

Use `SortField` to select the required Comparator.

The manager should not accept arbitrary strings as sorting criteria.

---

## Exercise 6 — Exception Handling

Demonstrate:

- Duplicate employee
- Missing employee
- Invalid sorting request

Handle each exception appropriately in `Main`.

---

## Exercise 7 — Set Implementations

Change the Set implementation between:

```text
HashSet
LinkedHashSet
TreeSet
```

Observe:

- Duplicate behavior
- Iteration order
- Sorting behavior
- Natural ordering
- Comparator behavior

---

# Further Enhancements

After completing the basic project, consider adding:

## 1. Descending Sorting

Allow sorting in:

```text
ASCENDING
DESCENDING
```

using an additional enum or sorting configuration.

---

## 2. Multiple Sorting Criteria

Support:

```text
Department → Salary
Name → Experience
Department → Name → Salary
```

using Comparator chaining.

---

## 3. Case-Insensitive Name Sorting

Names should be sorted without considering case.

---

## 4. Salary Range Search

Find employees whose salaries fall within a given range.

Do this without Streams.

---

## 5. Department Filtering

Find all employees belonging to a department.

---

## 6. Iterator-Based Removal

Use `Iterator` to safely remove matching employees while iterating.

This provides an opportunity to discuss:

```text
ConcurrentModificationException
```

---

## 7. TreeSet Experiment

Create a `TreeSet<Employee>` using:

```text
Comparable
```

and then using:

```text
Comparator
```

Observe how the ordering mechanism can affect which objects TreeSet considers equivalent.

---

## 8. Immutable Collections

Experiment with:

```text
List.of()
Set.of()
List.copyOf()
Set.copyOf()
```

Understand the difference between mutable and unmodifiable collections.

---

## 9. Concurrent Collections

Explore:

```text
CopyOnWriteArrayList
CopyOnWriteArraySet
```

and understand when they are appropriate.

---

# Intentionally Excluded

The following are intentionally **not part of the initial implementation**:

- Java Streams API
- `stream()`
- `parallelStream()`
- Stream collectors
- `filter()`
- `map()`
- `reduce()`
- `groupingBy()`

The goal is to make trainees comfortable with the Collection APIs and traditional iteration first.

---

# Future Collections

Once this project is complete, extend the same Employee Management requirement using:

```text
Map<Integer, Employee>
```

This should become the next major exercise.

The comparison will then be:

```text
List
 ↓
Ordered collection


Set
 ↓
Unique collection


Map
 ↓
Key-based lookup
```

This creates a natural progression through the Java Collections Framework.
