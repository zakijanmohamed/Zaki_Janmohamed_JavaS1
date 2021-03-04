# 1.3.2 Katas

## Introduction

In these katas, you will program to your interface rather than to the concrete class. You will also refactor your code before running your tests. 

## Requirements

- Add the code necessary to the `starter-code` project `U1M3L2Katas`.

- All classes should be part of the `com.company` package.

- Tests can be found in the `test/java` directory.

- Once you have written each class, uncomment the code in the associated test and run it.

- For all of the below, remember to program to the interface rather than to the concrete class (i.e., declare your variables as `List` instead of `ArrayList`).

### Kata 1

1. Locate the `App` class.

2. Refactor the following array methods found in  `App` so that they can use an `ArrayList` instead of a `List`:

    - `total`
    - `totalEven`
    - `swapFirstAndLast`
    - `reverse`
    - `lessThanFive`
    - `splitAtFive` **Challenge**
    - `evensAndOdds` **Challenge**

### Kata 2

1. Create a new class called `LinkedListApp`.

2. In the `LinkedListApp` class, refactor the activities in Kata 1 so that they implement a `LinkedList` instead of an `ArrayList`.

### Kata 3

1. Complete the following steps to create a `List` to hold information about your classmates:

    - Create a `Classmate` class that has the properties `name` and `hairColor`, along with the associated getters/setters.
    
    - Create another class called `ClassmatesList` to hold `Classmate` objects.
    
    - It should have a single private property which is an `ArrayList` of `Classmate` objects.
    
    - Do **not** create getters and setters for this list.

### Kata 4

1. Implement the following public methods in the `ClassmatesList` class:

    - `add` to take in a new `Classmate` and adds it to the list of classmates.

    - `get` to take in an `int` and return the classmate at that index.

    - `getAll` to return the entire list.

### Kata 5

1. Create a new class called `SetIterator` and create a public method called `printSet` which does the following:

    - Returns nothing.

    - Takes in five integers as its arguments.

    - Adds those integers into a new `HashSet`.

    - Uses an `Iterator` to print all members of the `HashSet`.


---

© 2021 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
