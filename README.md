NodePath project:
You have a Graphical user interface in which you open and insert a txt file with:

- room numbers;
- coordinate X;
- coordinate Y;
- floor;
- type room - transit/room;
for instance - " 432, 10, 22, 4, room; "
-----------------------------
- from room;
- to room;
- type transition;
- cost for every step;
- if its BiDirectional - true/false or yes/no;
for instance - " 400, 432, walk, 2, yes; "
for instance - " 400, 432, climb, 2, yes; "
for instance - " 400, 432, lift, 2, yes; "

In this user interface you have two text fields in which you type from which room to wihch you want to go;
You have 3 buttons bellow:
  - first button avoids stairs /if there are any/;
  - second button finds the shortes path from room A to B; sadly it doesn't work;
  - third button finds the path from A to B, but if you incounter stairs - the cost for passing through is doubled;
  - fourth button is the 'insert file' button where you choose the file you want the program to read;
  
  After you choose an option the path will start printing below and will show you if it has a PATH or NOT.
