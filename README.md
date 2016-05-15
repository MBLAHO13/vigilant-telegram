# vigilant-telegram
Project for CS 360, Software Design. Good design is not about the product, it is the journey.

Mark Blaho
CS 350 Part 3 -- Now with 100% less code binging!

Issues:
	- When you edit the correct answer for a test, it loses all notions of a correct answer. I've debugged it to hell and back, but the answer results become null after editing somehow and mess everything up.
	- Tabulations act strangely sometimes. The HashMap I'm using sometimes doesn't recognize duplicates 100% of the time, so it doesn't count answers properly. I've overridden equals() and hashVal() but to no avail.


Program Strengths:
	- Solid Serialization: Object in, Object out. There's really no way you can hose that up as long as you don't touch the JSON. And if you touch the JSON, you deserve the angry errors.
	- No Crashing: Main traps and dumps exceptions, then keeps on going.
	- State-Menu: You can navigate the menus all over the place without losing work.
	- Grade Results are saved in ./Grades, Tabulations are saved in ./Tabulations.
	- I did not have to rip this apart to accomodate new functionality. In fact, all the methods worked nicely together. Quelle surprise.


Mark Blaho
CS 350 Part 2

 - Method for saving to File: 

	 - Google's GSON library. Hands down, my favorite library for any programming language. Even better than Flask.

	 - Abstract way of looking at it: 
		Object -> GSON serializes -> String written to file -> GSON deserializes -> (Cast) Object  ; where Object == (Cast) Object

		And that's all there is to it. All file methods are in the IOUtilities class, plus some other general-use functions/constants. 



 - Files are located in the ./Storage folder. Dumps are in the ./Dumps folder. Nice and easy.



 - Issues:
	- Code structure: I started strong, but fatigue and the short deadline took its toll on the codebase. Things are heavily encapsulated, but I'm still not satisfied with some of it.
	- Grading Structure: There's a non-zero possibility I'm going to have to shred a LOT of this to hook in the grading. I've done my best to program with an eye to the future. 
	- Wetware failures: I've been marathon programming on sleep deprivation. I'm probably overlooking a lot of stupid things, but it all works, and it doesn't crash.



 - Program Strengths:
	- Solid Serialization: Object in, Object out. There's really no way you can hose that up as long as you don't touch the JSON. And if you touch the JSON, you deserve the angry errors.
	- No Crashing: Main traps and dumps exceptions, then keeps on going.
	- State-Menu: You can navigate the menus all over the place without losing work.
