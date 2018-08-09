Project: foxes-and-rabbits-v1
Authors: Michael Kolling and David J. Barnes

This project is part of the material for chapter 10 of the book

   Objects First with Java - A Practical Introduction using BlueJ
   David J. Barnes and Michael Kolling
   Pearson Education, 2002

A predator-prey simulation involving foxes and rabbits in
an enclosed rectangular field.

This is the base version of the simulation. It provides 
an adequate simulation of the changes in population size
of foxes and rabbits in a field. However, it has been written
without making use of inheritance.

Within the chapter, this version is adapted to introduce
further abstraction techniques.

How to start:
    Create a Simulator object.
    Then call one of:
        + simulateOneStep - for a single step.
        + simulate - and supply a number of weeks (say 10) for that many steps.
        + runLongSimulation - for a simulation of 500 weeks.
