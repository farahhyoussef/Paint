# Paint
-Developed a desktop paint application that allows users to draw, edit, color, drag, drop, undo, redo and delete shapes and drawings.   -Utilized GUI, design patterns, OOP, Swing, data structures.  
OOP Principles
Implementation Description
1-Draw
When Draw toggle button is clicked, the action parameter is set to be ‘P’, so that the program stays in drawing mode.
Each shape clicked has its own index to be sent to the ‘Factory’, to decide which shape to draw the color and the state of whether it’s filled or not is sent to the Factory too.
Firstly, when pressing the mouse on the area where the desired shape will be drawn, the current parameters of the x and y coordinates of the mouse position is sent to the ‘Factory’, and x2 and y2 are updated when the mouse is dragged.
Following, the shape is finally added to the Array list, and the whole array is printed, each shape is drawn using its ‘draw’ method which is an abstract method in the Parent Class Shape, and inherited to all the children.
2-Clear Area
By clicking the Clear Area button, the elements in the Arraylist which stores all the existing shapes are deleted, so when repainting, no shapes are there to draw.
3-Delete Clicked
When Clicking the Delete Clicked Button, the action parameter is set to be ‘D’, so that the program stays in deleting mode.
When clicking on a specific shape to delete, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, it is removed from the arraylist of shapes, so that when repaint() occurs, the shape is not drawn.
4-Move
By pressing the Move toggle button, the action parameter is set to be ‘M’ , so that the program stays in moving mode.
When clicking on a specific shape to move, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, its coordinates get updated when the mouse is dragged, so that when repaint() occurs, the shape will be drawn with the new coordinates.
5-Resize
By pressing the Resize toggle button, the action parameter is set to be ‘Z , so that the program stays in resizing mode.
When clicking on a specific shape to resize, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, its x2 & y2 coordinates get updated when the mouse is dragged, and in case the shape is instanceof Triangle, x1 & y1 are also updated, so that when repaint() occurs, the shape will be drawn with the new coordinates.
6-Copy Clicked
By pressing the Copy Clicked toggle button, the action parameter is set to be ‘C’ , so that the program stays in copying mode.
When clicking on a specific shape to copy, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, its related information are stored in variable copied to be used later then the coordinates of the found shape get updated with a shift so the copied shape appears else where on the screen not on top of the original shape, then this updated shape is added
to the end of the arraylist shapesInArea and variable copied is inserted in the arraylist in the index where the original shape was found , so that when repaint() occurs, the copied shape will be drawn with the shifted coordinates.
7-Repaint
By clicking the Repaint button, the action parameter is set to be ‘F’ , and they new color to be used is stored.
When clicking on a specific shape to repaint, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, changeFill() method is called to change value of isFilled variable to true if it was false, then color of selected shape is changed to the new color that was stored previously, so that when repaint() occurs, the repainted shape will be drawn with the new color.
8-Undo
The undo action is implemented using the data structure ‘stack’, as the last in is the first to pop ’LIFO’ .
After each action in our design, the action and all the parameters used to do the action are saved and added as an object to the undo stack.
When clicking on the undo button, the top of the stack, which is the last element pushed into it is popped, and the reverse action is done to undo the previous saved action. Ex: if the last action was Draw, then its inverse would be Delete, and vise versa.
The object popped is then pushed into the redo stack.
9-Redo
The redo action is implemented using the data structure ‘stack’, as the last in is the first to pop ’LIFO’ .
Implementation Description
1-Draw
When Draw toggle button is clicked, the action parameter is set to be ‘P’, so that the program stays in drawing mode.
Each shape clicked has its own index to be sent to the ‘Factory’, to decide which shape to draw the color and the state of whether it’s filled or not is sent to the Factory too.
Firstly, when pressing the mouse on the area where the desired shape will be drawn, the current parameters of the x and y coordinates of the mouse position is sent to the ‘Factory’, and x2 and y2 are updated when the mouse is dragged.
Following, the shape is finally added to the Array list, and the whole array is printed, each shape is drawn using its ‘draw’ method which is an abstract method in the Parent Class Shape, and inherited to all the children.
2-Clear Area
By clicking the Clear Area button, the elements in the Arraylist which stores all the existing shapes are deleted, so when repainting, no shapes are there to draw.
3-Delete Clicked
When Clicking the Delete Clicked Button, the action parameter is set to be ‘D’, so that the program stays in deleting mode.
When clicking on a specific shape to delete, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, it is removed from the arraylist of shapes, so that when repaint() occurs, the shape is not drawn.
4-Move
By pressing the Move toggle button, the action parameter is set to be ‘M’ , so that the program stays in moving mode.
When clicking on a specific shape to move, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, its coordinates get updated when the mouse is dragged, so that when repaint() occurs, the shape will be drawn with the new coordinates.
5-Resize
By pressing the Resize toggle button, the action parameter is set to be ‘Z , so that the program stays in resizing mode.
When clicking on a specific shape to resize, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, its x2 & y2 coordinates get updated when the mouse is dragged, and in case the shape is instanceof Triangle, x1 & y1 are also updated, so that when repaint() occurs, the shape will be drawn with the new coordinates.
6-Copy Clicked
By pressing the Copy Clicked toggle button, the action parameter is set to be ‘C’ , so that the program stays in copying mode.
When clicking on a specific shape to copy, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, its related information are stored in variable copied to be used later then the coordinates of the found shape get updated with a shift so the copied shape appears else where on the screen not on top of the original shape, then this updated shape is added
to the end of the arraylist shapesInArea and variable copied is inserted in the arraylist in the index where the original shape was found , so that when repaint() occurs, the copied shape will be drawn with the shifted coordinates.
7-Repaint
By clicking the Repaint button, the action parameter is set to be ‘F’ , and they new color to be used is stored.
When clicking on a specific shape to repaint, the x and y parameters of the mouse are recognized, and sent to pass on each element in the array to check whether the x and y exist in the boundaries of the shape or not using the isSelected() method of return type Boolean. When the specific shape is found, changeFill() method is called to change value of isFilled variable to true if it was false, then color of selected shape is changed to the new color that was stored previously, so that when repaint() occurs, the repainted shape will be drawn with the new color.
8-Undo
The undo action is implemented using the data structure ‘stack’, as the last in is the first to pop ’LIFO’ .
After each action in our design, the action and all the parameters used to do the action are saved and added as an object to the undo stack.
When clicking on the undo button, the top of the stack, which is the last element pushed into it is popped, and the reverse action is done to undo the previous saved action. Ex: if the last action was Draw, then its inverse would be Delete, and vise versa.
The object popped is then pushed into the redo stack.
9-Redo
The redo action is implemented using the data structure ‘stack’, as the last in is the first to pop ’LIFO’ .
