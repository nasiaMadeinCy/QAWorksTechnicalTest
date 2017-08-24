Technical Test Project for QAWorks 24/08/2017

GENERAL USAGE
-------------
Operating System: Windows 7 
System Type: 64-bit
Java Version: 1.8.0_144
Chrome Version: 60.0.3112.101 (Official Build) (64-bit)
Firefox Version: 52.3.0 (64-bit)



Deliverables:

	- The source code of the project.
	
	
Instructions:	

All you have to do is cd to the projects file and execute:
	mvn clean verify
This will execute the tests with Firefox.
For cross browser compatibility you can execute:
	mvn clean verify -Dbrowser=chrome
This will execute the tests with Chrome.
You can run the tests with either Firefox or Chrome at the moment.

Alternative ways (Using IDE):
	1. Open project with IDE
	2. Right click on the  "ContactUsPage.feature" file and Run
	OR Right click on the runner file "ContactUsPageTest.java" and Run

Report can be found at \target\cucumber\index.html after the execution of the 
tests.

*Assumptions: You already have Java 8 installed with Maven. Your browser 
versions are compatible with the drivers in the browserDrivers folder. 
Please refer to GENERAL USAGE of this document for details.


===================================================================
Contact Information:
E-mail: herodotou.anastasia@gmail.com
Voice: +30 699 88 33 677