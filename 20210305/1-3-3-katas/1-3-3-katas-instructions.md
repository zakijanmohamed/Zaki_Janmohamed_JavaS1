# 1.3.3 Katas

## Introduction

In these katas, you will practice writing your code and testing it in a real-world scenario.

## Requirements

- Add the code necessary to the `App` class found in the project `U1M3L3Katas`.

- All methods should be `public`.

- Tests can be found in the `test/java` directory.

- Once you have written each class, uncomment the code in the associated test and run it.

### Kata 1

- Create a method called `printKeys` that takes in a `Map` with string keys and string values and iterates through and prints out all keys in the `Map`.

### Kata 2

- Create a method called `printValues` that takes in a `Map` with string keys and string values, and iterates through and prints out all of the values in the `Map`.

### Kata 3

- Create a method called `printKeysAndValues` that takes in a `Map` with string keys and string values, and iterates through the Entry Set of the `Map`.

- Print the keys and values in the `Map` in the following format: `key: value`.

### Kata 4

- Create a method called `mapFun` that does the following:

  - Takes in a `Map` with string keys and integer values.

  - Adds two new entries to the `Map`&mdash;a 2012 Ford Explorer and a 2013 Smart Fortwo.
  
  - Removes the Jeep Wrangler from the `Map.`

  - Returns a new `Map` with string keys and integer values.

- Assume the original `Map `will always contain at least these entries:

  | Key             | Value |
  | --------------- | ----- |
  | Toyota Camry    | 2012  |
  | Chevy Camaro    | 1969  |
  | Hyundai Genesis | 2015  |
  | Jeep Wrangler   | 2003  |
  | Honda Civic     | 2018  |
  | Toyota Supra    | 1995  |
  | Pontiac GTO     | 1964  |

### Kata 5

- Create a method called `listCars`, which takes in a `List` of `Car` objects and does the following:

  - Creates a `List` called `toyotaList` to hold all the `Car` variables with "Toyota" as the make and add them to the list.

  - Creates a `List` called `fordList` to hold all the `Car` variables with "Ford" as the make and add them to the list.
  
  - Creates a `List` called `hondaList` to hold all the `Car` variables with "Honda" as the make and add them to the list.
  
  - Stores all three `List`s in a `Map` with the make as the key.
  
  - Returns the `Map`.

**Hint:** Your key will be a `String`. What will your value be?

---

© 2021 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
