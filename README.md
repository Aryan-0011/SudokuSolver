# Sudoku Solver

## Project Overview
A Java-based Sudoku puzzle solver with a graphical user interface that allows users to input and solve Sudoku puzzles interactively.

## STAR Format Description

### Situation
- Sudoku puzzles require logical deduction and can be challenging to solve manually
- Many people enjoy solving Sudoku puzzles but may get stuck on difficult puzzles
- There was a need for an efficient and user-friendly Sudoku solving application

### Task
- Create a Sudoku solver that could:
  - Handle standard 9x9 Sudoku puzzles
  - Validate puzzle inputs
  - Solve puzzles efficiently
  - Provide a user-friendly interface for input and interaction

### Action
- Implemented a backtracking algorithm for solving Sudoku puzzles
- Created a robust validation system that checks:
  - Row constraints
  - Column constraints
  - 3x3 box constraints
- Developed a graphical user interface using Java Swing featuring:
  - A 9x9 grid of input cells
  - Visual separation of 3x3 boxes
  - Input validation (only numbers 1-9 allowed)
  - Solve and Clear functionality
  - User feedback through dialog boxes

### Result
- Successfully created a fully functional Sudoku solver with:
  - Efficient puzzle solving capabilities
  - Intuitive user interface
  - Input validation and error handling
  - Clear visual feedback
  - Easy-to-use controls

## Technical Details
- Built with Java
- Uses Java Swing for the GUI
- Implements backtracking algorithm for puzzle solving
- Features input validation and error handling

## How to Use
1. Run the application
2. Enter numbers (1-9) in the cells where you want to place them
3. Click "Solve" to solve the puzzle
4. Click "Clear" to reset the board

## Features
- Interactive 9x9 grid interface
- Input validation
- Visual separation of 3x3 boxes
- Solve and Clear functionality
- Success/error feedback
- Efficient puzzle solving algorithm
