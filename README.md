# Simple Pacman

A small console-based Pac-Man style game written in Java. The player controls Pacman on a 5x5 grid, earns points by surviving each turn, and tries to avoid a ghost that automatically chases them.

## Features

- Console-based gameplay
- 5x5 game board
- Move Pacman using keyboard controls
- Ghost follows Pacman with simple chase logic
- Score increases every turn
- Game ends when the ghost catches Pacman

## Project Structure

The project is contained in a single Java file:

- `SimplePacman.java` — contains all classes and game logic

### Classes Included

- `GameObject` — base class for objects with `x` and `y` coordinates
- `Pacman` — player character with movement and scoring logic
- `Ghost` — enemy character that moves toward Pacman
- `SimplePacman` — main class that runs the game loop and draws the board

## How the Game Works

1. Pacman starts at the top-left corner of the board.
2. The ghost starts at the bottom-right corner.
3. Each turn:
   - The board is displayed
   - The player enters a move
   - Pacman moves
   - The ghost moves toward Pacman
   - The score increases by 10
4. The game ends when the ghost reaches Pacman.

## Controls

Use the following keys to move:

- `W` - Up
- `A` - Left
- `S` - Down
- `D` - Right
- `Q` - Quit the game

## Requirements

- Java Development Kit (JDK) 8 or later

## How to Compile and Run

### Compile

```bash
javac SimplePacman.java
```

### Run

```bash
java SimplePacman
```

## Example Board Output

```text
P . . . .
. . . . .
. . . . .
. . . . .
. . . . G
```

- `P` represents Pacman
- `G` represents the ghost
- `.` represents an empty space

## Notes

- Pacman cannot move outside the board boundaries.
- The ghost uses simple movement logic and moves closer to Pacman every turn.
- The score increases by 10 after each valid turn.
- This project is a beginner-friendly example of object-oriented programming in Java.

## Possible Improvements

- Add food pellets instead of scoring every turn
- Add walls or obstacles
- Add multiple ghosts
- Add win conditions
- Improve ghost AI
- Add graphical interface using Java Swing or JavaFX

## License

This project is open for learning and personal use.
