## LDTS_<08><05> - <Uno>

>For this project, we decided to create the famous game of Uno. We are in the battle against the CPU where the first one to play all of their cards wins. Each card played must have the same color or numbers as the one thats's on top of stack of played cards or is must be a black color card. There are cards with special abbilities such as Block, Draw 2, Draw 4, Reverse and Change Color.

### IMPLEMENTED FEATURES

>We have implemented classes and methods to create the various cards that compose a Uno Deck.

>We have also implemented the Deck Handler Deck, which creates a randomized Deck Stack and draws the cards both for the CPU and Player. Along side this, there's the played card stack, being that the first card put on the "table" is randomized and it must be a number card. Each of these 3 types of decks has it's own specific Class with different methods and private members.

>In terms of GUI, there's some basic Lanterna to get the visuals up and running.

### PLANNED FEATURES

> The rest of the planned features are basically get the game to it's full form. These include the ability to play the Cards itself, the CPU logic and the visuals to go along side it. We also to create a main menu where one is able to create a new instance of the game and change some basic settings (eg: the volume of the Sound).

### DESIGN

- **Problem in Context.** We have 3 different types of Decks. The first one is the one that's shuffled and all the cards are drawn from. The second one is the played cards stack and the third one is the one that the players have. We intented to make a class with some main methods and attributes that are then extended for each different type. However, each type of deck has different variables and methods. For example, the let's call it "shuffled" main deck should be a Deque, as we are only interested in taking cards from the ends, there's no need in removing or add cards from the middle for example. That is not the case with the Player Decks, where a List is optimal.

- **The Pattern.** Thus, the option we chose was to make 3 different classes. It was the most optimal solution has now each type of deck can have the most time/space efficient methods for each one. A Structure like implementation was considered, although there was not a significant enough ammount of similar methods to be worth consider an interface.

- **Implementation.** As stated before, we're going to have a different class for each type of deck. These will then be linked to the main loop through the class DeckHandler, in which each Deck is created and the various methods are used to created the randomized stacks of cards needed to play the game.

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

> The main smell we could notice was when it comes to the main game loop. We are worried we're doing too much GUI in there and in the near future we'll be moving that part into newer classes, as we can see in the UML. For example, we plan to correlate a class such as Card Viewer and have it be called an object in DeckHandler, where all the card decks that must be shown will be located.

**Example of such a subsection**:

------

#### DATA CLASS

The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. This is problematic because […].

A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%