## LDTS_<08><05> - UNO

>For this project, we decided to implement the famous game of Uno. We play the game against one where the classic rules of UNO apply.

This project was developed by André Santos (up202108658@fe.up.pt), António Rama (up202108801@fe.up.pt) and José Veiga (up202108753@fe.up.pt) for LDTS 2022/2023.

### IMPLEMENTED FEATURES

**Cards** - We have implemented classes and methods to create the various Cards that compose a Uno Deck.

**Decks** - There are 3 different types of Decks: Player, Played and Stack, all with their own attributes and methods. The Decks Handler class creates a randomly ordered Deck of cards and draws the cards both for the CPU and the Player, storing them on the Player Deck. The Played Deck stores the cards that have been already played.

**GUI** - There's some basic Lanterna features in LanternaBasics class to get the visuals up and running.

**Tests** - There are some tests implemented to check the quality of the code.

### PLANNED FEATURES

> Our planned features are essentially to get the game to its full form. These include:
- The ability to play the Cards.
- The CPU logic and the visuals to go alongside it.
- Create a main menu where one is able to create a new game and change some basic settings like the sound, the game mode or see the rules.

<<<<<<< Updated upstream
=======
### DESIGN![img.png](img.png)
>>>>>>> Stashed changes

- **MVC Architectural Pattern** In order to better organise the various different parts of our game, we have decided to use the MVC architectural pattern. In both states, we have a model which holds the game/menu information, a controller which, as the name says, controls said information, and a viewer that draws such information.

- **State Pattern** To switch up between the menu and the game itself, we have decided to ue a State Pattern, in which the controllers and viewers to be ran are chosen depending on which model we are currently using.


![png](images/uml.png)



#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

> The main smell we encountered was the overuse of ifs in the viewer. We also have the duplicate code smell throughot different classes and there are classes which are overcrowded with attributes, mainly the GUI class.

>In terms of the refactoring that has been done, we have switched the Architectural Pattern to the MVC completely, thus cleaning up the code a lot. We have also implemented various different classes in the controller to facilitate the smooth running of the game rules and we have removed every single logic step that was present in the game model.


### TESTING

> There are tests on the Stack Deck [here](src/test/java/com/l08gr05/uno/decks_cards/StackDeckTest.java).

![png](images/test1.png)

> And tests on the Decks Handler [here](src/test/java/com/l08gr05/uno/gamelogic/DecksHandlerTest.java).

![png](images/test2.png)
### SELF-EVALUATION

> All of us worked well for this project and did most of the code in a group call.