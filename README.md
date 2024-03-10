## Draw Canvas

This repository contains a simple drawing program built in Maven, compile in Java 8 with Junit 4.12 and Lombok plugins, which can be installed at root folder/lombok-1.18.4.jar if you are using Eclipse. It uses annotation to generate boilerplate code, such as getter and setter for clean code practices.

The source code is in the `src` folder, and test cases are located in `src/test` folder.

`DrawCanvas` contains `factory` folder which uses Factory Pattern to instantiate subclasses. `graphics` folder contains the primitive shapes classes for drawing canvas. `command` folder uses Command Pattern and contains command classes for drawing each shapes. It also contains logic to validate the user input.
`exception` folder contains all the error codes that are used in `DrawCanvasException`.

## How to use
### Prerequisite
Built in Maven, compile in Java 8 with Junit 4.12 and Lombok plugins. Please install the following

### Building the program and running the tests

The program can be compiled by running ```mvn compile```.

The program can be built by running `mvn clean package`, which will also run the test cases. 

### Compile and run DrawCanvas

Option 1:
Navigate to the root directory e.g. `draw-canvas` and execute the following command:
`mvn compile exec:java -Dexec.mainClass="com.drawcanvas.App"` 

Option 2: Navigate to target folder e.g. `draw-canvas/target` folder and run the following command:
`java -jar draw-canvas-1.0-SNAPSHOT.jar` 


### Commands
The lists of commands are available here. 

```shell
Welcome to the DrawCanvas help menu.


1. C w h:          Should create a new canvas of width w and height h.
2. L x1 y1 x2 y2:  Should create a new line from (x1,y1) to (x2,y2). Currently only
                   horizontal or vertical lines are supported. Horizontal and vertical lines
                   will be drawn using the 'x' character.
3. R x1 y1 x2 y2:  Should create a new rectangle, whose upper left corner is (x1,y1) and
                   lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                   using the 'x' character.
4. B x y c:        Should fill the entire area connected to (x,y) with "colour" c. The
                   behaviour of this is the same as that of the "bucket fill" tool in paint
                   programs.
5. O:              Clear the canvas.
6. H:              Show the help menu.
7. Q               Should quit the program.
```

#### Create Canvas
Canvas has to be created first before drawing any shapes in the canvas. Using the command `C w h`, specifying the dimensions of the canvas. `w` is an integer specifying the width of the canvas and `h` is an integer specifying the height of the canvas. The point on the canvas `(x,y)` where `x` stands for the horizontal coordinate going rightwards and `y` stands for the vertical coordinate going downwards. The range for both `w` and `h` is 1 to 80. Any point `(x,y)` that exceeds the range, will be considered as out of canvas boundary. 

#### Draw A Line
Horizontal and vertical lines can be drawn on the current canvas by using command `L x1 y1 x2 y2`. `L` is the identifier of this command. `x1` and `y1` are integers forming the coordinate of the starting point of the line. `x2` and `y2` are integers forming the coordinate of the end point of the line. In order for the line to be drawn, both points must be within the canvas boundary. Diagonal line is supported.

#### Draw A Rectangle
A rectangle can be drawn on the current canvas by using command `R x1 y1 x2 y2`. `x1` and `y1` are integers forming the coordinate of the top left point of the rectangle. `x2` and `y2` are integers forming coordinate of the bottom right point of the rectangle. In order for a rectangle to be drawn, the points of a rectangle has to be within the canvas boundary.

#### Bucket Fill
All the points connected to a specific point can be filled with a color by using command `B x y c`. `x` and `y` are integers forming the coordinate a point and color `c` is an alphabet letter (case insensitive) that is used to paint on that point. The command will replace the color of target area at point `x` and `y` with the new color `c`.

#### Clear Canvas
Canvas can be cleared using the command `O`. A new canvas will be created with current canvas's width and height `w h`.

#### Help
Display the help menu.