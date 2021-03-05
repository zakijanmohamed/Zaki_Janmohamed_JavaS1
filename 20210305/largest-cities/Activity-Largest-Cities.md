# Activity: Largest Cities

## Introduction

In this activity, you will create a program that allows a user to filter city data by population values, as well as map cities to their corresponding states. This will allow you to practice mapping and filtering, two essential skills for Java developers.

## Requirements

Your program must do the following:

- Have properties for `name` and `population`.

- Have `City` variables to hold data.

- Provide key-value pairs for states and their corresponding city objects.

## Instructions

1. Create a class called `City` with the following properties:

   - `name` 

   - `population`

 2. Create `City` variables to hold the below data:


    |       City      |    Population     |
    |-----------------|-------------------|
    | New York        |      8654321      |
    | Los Angeles     |      4563218      |
    | Chicago         |      2716520      |
    | Denver          |       704621      |
    | Des Moines      |       217521      |
    | Atlanta         |       486213      |


3. In the `main` method, create a Map that holds the names of states and their corresponding city objects (State name is the `key`, City object is the `value`).

4. Print the `name` and `population` for each City, along with its corresponding state name, to the screen.

5. Write the tests for a `filterByPopulation`, which takes in a map with string keys and city values and an integer for population, and returns a new map containing only those cities which fall above the population value.

    - **Note:** This method should **not** include the `Scanner` class at all. Any user input should take place in the `main `method.

6. Implement the `filterByPopulation` method.

7. In the main method, print the states with cities that have a population over a given value (which is typed in by the user of the program) to the screen.

   **Hint:** You will have to add code that asks the user for a minimum population as an input. Once you have this value from the user, the program should look through each state/city pair (as you did for #4 above) but only print the information for cities that have a population above the input.

---

© 2021 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
