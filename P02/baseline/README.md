# Assignment P02

## Full Credit and Bonus

FIRST, write the ``Pitch`` enum and the ``Note`` class as specified in the requirements. You cannot compile the code in this directory without them!

**You may NOT modify Song.java!**

THEN, once those two types are correctly defined, use the build.xml ant file in this directory to build them with the provided Song.java file using the ``ant`` command.

WHEN DEFINED CORRECTLY, ``java Song`` should print the notes to the classic children's song, "Mary Had a Little Lamb", the music world's equivalent to "Hello, World!".

Here is an example run for successfully completing this assignment.

ricegf@antares:~/cse1325/full_credit$ ls
build.xml  Note.java  Pitch.java  Song.java
ricegf@antares:~/cse1325/full_credit$ ant
Buildfile: /home/ricegf/cse1325/full_credit/build.xml

build:
    [javac] Compiling 3 source files

BUILD SUCCESSFUL
Total time: 0 seconds
ricegf@antares:~/cse1325/full_credit$ java Song 
B A G A B B B   A A A   B D1 D1   B A G A B B B B A A G Gb G   
ricegf@antares:~/cse1325/full_credit$ 

## Extreme Bonus

For the Extreme Bonus, you are allowed to modify the Song class, as you'll need to add note.play() to play the notes. In addition, you may need to tell the program to ignore exceptions (which we'll cover in Lecture 05).

The Requirements PDF includes hints for the Extreme Bonus!

