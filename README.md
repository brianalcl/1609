[![Foto.png](https://i.postimg.cc/5tKVWSzT/Foto.png)](https://postimg.cc/yJR5F9vy)

1609 is a set of games implemented in Java.

As a strong restriction for this project, it was decided to take a compact map of:
- 16x9 cells for vertical games.
- 9x16 cells for horizontal games.

All games share a set of logical and visual functions.

A focus was put on inheritance to avoid repeating code between different games, the use of design patterns was also contemplated.
The code is written in English (variables, methods, classes...) and is organized as follows:
- Inside the "src" folder are the different packages with code. Now let's look at each root package.
- The "abstractFactory" package contains an abstract factory and two specific factories.
- The "assets" package contains images, fonts and any external content that is added to the project.
- The "games" package contains the implementation of all the games.
- The "gamesData" package contains files that are read in some games.
- The "general" package contains all the general or common implementations of the project.
- The "gui" package contains the classes related to the GUI.
- The "main" package contains the class with the main method that allows executing the project.
- The "sound" package contains the classes related to the sound.

The project runs in a resolution of 1280x720 in windowed mode, it can be set to 1920x1080 in windowed mode by changing two parameters in the "Launcher" class.

At the time of updating this information, 1609 has 9 games, among which stand out: Snake, Tetris, Minesweeper, Sudoku and 2048.
