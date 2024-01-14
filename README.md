# CloudBeesAssessment2
Test Assessment for CloudBees

###Requirement given in the Email
- I want to board a train from London to France. The train ticket will cost $20.
- Create API where you can submit a purchase for a ticket. Details included in the receipt are: From, To, User , price paid.
- User should include first and last name, email address
- The user is allocated a seat in the train. Assume the train has only 2 sections, section A and section B.
- An API that shows the details of the receipt for the user
- An API that lets you view the users and seat they are allocated by the requested section
- An API to remove a user from the train
- An API to modify a user's seat

Solution Developed using IntelliJ IDE

- Created User class for given requirement
- Created Ticket class for which has static From station, To station, ticket cost, train seat and train section which inherits User class
- Created Booking Class which has the App implementation. 
	- Took booking object Map based on user email which tracks all the bookings.
	- Taken two booking object array assuing has 10 seats per section.
	- Scanners for user input.
	- Input validation is done for each APIs.
	- Developed algorithm for finding next empty seat.
	- Has error handling for each cases.
	- Created test cases for each class and function.
