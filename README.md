# Snake Game 🐍

A classic Snake game implementation in Java using Swing graphics. Control the snake to eat food, grow longer, and avoid collisions!

## Features

- **Classic Snake Gameplay**: Navigate the snake around the screen to collect food
- **Growing Mechanics**: Snake grows longer each time it eats food
- **Collision Detection**: Game ends when snake hits walls or itself
- **Smooth Animation**: Runs at 7 FPS for optimal gameplay experience
- **Keyboard Controls**: WASD keys for directional movement

## How to Play

1. Use **WASD** keys to control the snake:
   - **W**: Move up
   - **A**: Move left
   - **S**: Move down
   - **D**: Move right

2. Guide the snake to eat the red food squares
3. Each food eaten makes the snake grow longer
4. Avoid hitting the walls or the snake's own body
5. Try to achieve the highest score possible!

## Game Mechanics

- **Grid Size**: 35x35 tiles
- **Tile Size**: 20x20 pixels
- **Game Speed**: 7 FPS
- **Food Spawning**: Random locations on the grid
- **Growth**: Snake length increases by 1 segment per food eaten

## Project Structure

```
src/
├── Main/
│   ├── Main.java           # Entry point and window setup
│   └── GamePanel.java      # Main game loop and rendering
├── Entity/
│   ├── Entity.java         # Base entity class
│   ├── Snake.java          # Snake logic and behavior
│   └── Food.java           # Food generation and consumption
└── KeyHandler/
    └── KeyHandler.java     # Keyboard input handling
```

## Class Overview

### Main Classes
- **`Main`**: Creates the game window and starts the application
- **`GamePanel`**: Handles the game loop, rendering, and coordinates game objects

### Entity Classes
- **`Entity`**: Base class for game objects with position and length properties
- **`Snake`**: Implements snake movement, growth, and collision detection
- **`Food`**: Manages food placement and consumption logic

### Input Handling
- **`KeyHandler`**: Processes keyboard input for snake movement

## Requirements

- Java 8 or higher
- No external dependencies (uses built-in Java Swing)

## Installation & Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/snake-game.git
   cd snake-game
   ```

2. **Compile the Java files**:
   ```bash
   javac -d bin src/**/*.java
   ```

3. **Run the game**:
   ```bash
   java -cp bin Main.Main
   ```

Alternatively, if using an IDE like Eclipse or IntelliJ IDEA:
1. Import the project
2. Run the `Main.java` file

## Game Screenshots

The game features:
- Green background playing field
- Black snake segments
- Red food squares
- Clean, minimalist graphics

## Technical Details

- **Graphics**: Java 2D Graphics (Graphics2D)
- **Game Loop**: Fixed timestep at 7 FPS
- **Collision Detection**: Grid-based collision system
- **Memory Management**: Efficient tail management using ArrayList

## License

This project is open source and available under the MIT License.

## Author

Created as a learning project to demonstrate Java game development concepts using Swing.

---

Enjoy playing Snake! 🎮
