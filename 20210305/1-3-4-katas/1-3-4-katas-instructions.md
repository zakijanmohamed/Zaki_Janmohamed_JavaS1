# 1.3.4 Katas

## Introduction

In this kata, you will revise the provided code so that it handles the below exceptions regarding the data type of a user input. This type of code is used in hundreds of thousands of online programs to ensure that user forms do not throw exceptions.

## Requirements

- Add the code necessary to the `Application` class found in the `starter-code` project `U1M3L4Katas`.

- Tests can be found in the `test/java` directory.

## Instructions

Handle the following exceptions:

- When a user enters a non-integer value, display "Please enter a valid number."

- When a user chooses a value not present in the array, display "Please choose an available pet."

- If the file does not exist, display the message "The following file does not exist:" along with the output from the Exception `.getMessage()`.

- If there was trouble writing the file, display "Something went wrong while writing your file."

- Regardless of success or exceptions, tell the user to "Have a nice day!"

**Note:** The test will delete `pets.txt`, so you may need to recreate it in the root of your project directory.

---

© 2021 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.


