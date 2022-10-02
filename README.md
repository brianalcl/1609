1609 is a set of games implemented in Java.

As a strong restriction for this project, it was decided to take a compact map of:
- 16x9 cells for vertical games.
- 9x16 cells for horizontal games.

All games share a set of logical and visual functions.

A focus was put on inheritance to avoid repeating code between different games, the use of design patterns was also contemplated.
The code is written in English (variables, methods, classes...) and is organized as follows:
- Inside the "src" folder are the different packages with code. Now let's look at each root package.
- The "assets" package contains images, fonts and any external content that is added to the project.
- The "games" package contains the implementation of all the games.
- The "general" package contains all the general or common implementations of the project.
- The "factory" package contains an abstract and a specific factory
- The "main" package contains the class with the main method that allows executing the project.
- There is a folder called "gamesData" which contains files that are read or written in some games.

The project runs in a resolution of 1280x720 in windowed mode, it can be set to 1920x1080 in windowed mode by changing two parameters in the "Launcher" class.

The project is not finished yet. New games, changes and improvements will be added over time.
At the time of updating this information, 1609 has 5 games, among which stand out: Snake, Minesweeper, Sudoku and 2048.
