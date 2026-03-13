# IdeaPad

## Aim of the Project

The aim of this project is to build a simple command-line application in Java that allows users to store, organize, and manage their ideas efficiently. The program enables users to add new ideas, view existing ones, search through saved ideas, and delete ideas they no longer need. It also ensures that ideas are stored in a file so they remain available even after the program is closed.

---

## Concepts Used

This project demonstrates the use of several core Java concepts:

- ArrayList for dynamic storage of ideas
- File handling for persistent data storage
- BufferedReader and BufferedWriter for efficient file reading and writing
- Scanner for user input
- Conditional statements and loops
- Menu-driven program design
- Exception handling using try-catch blocks
- Basic indexing and list manipulation

---

## Features

- Menu-driven command-line interface
- Add new ideas quickly
- View all stored ideas
- Search for specific ideas using keywords
- Delete unwanted ideas
- Automatically saves ideas to a file
- Loads previously saved ideas when the program starts
- Allows multiple operations without restarting the program

---

## How It Works & What It Solves

The application provides a simple menu interface where users can select different options to manage their ideas.

When the program starts, it loads previously saved ideas from a file using `BufferedReader`. These ideas are stored in an `ArrayList` during program execution.

Users can then perform various actions:

1. **Add Idea** – A new idea is added to the list and saved to the file.
2. **View Ideas** – Displays all stored ideas with index numbers.
3. **Search Idea** – Allows users to find ideas containing specific keywords.
4. **Delete Idea** – Removes an idea from the list based on its index.
5. **Exit** – Ends the program.

Whenever a change is made, the updated list of ideas is written back to the file using `BufferedWriter`, ensuring data persistence.

This project solves a common problem of quickly capturing and managing ideas without needing complex software.

---

## Challenges Faced

One challenge in this project was implementing file handling to ensure ideas persist even after the program closes. Understanding how to properly read from and write to files using `BufferedReader` and `BufferedWriter` required careful handling of input and output streams.

Another challenge was managing user input in a menu-driven system, especially when switching between `nextInt()` and `nextLine()`, which required handling leftover newline characters to prevent skipped inputs.

---

## Author

Evangeline Maddela
