#User Story Documentation

##Functional Area
Meal Selection and Booking

##User Story
4 - Escolha e marcação de uma refeição – para um dia e refeição específico. Almoço pode ser reservado até 10h e jantar até as 16h, com actualização do saldo do utente e do
              número de refeições disponíveis daquele prato.
##Pre-Conditions
* Lunch Meal Type can only be booked until 10am of the same day
* Dinner Meal Type can only be booked until 04pm of the same day

##Pos-Conditions
* Must update user balance
* Must update the number of available meals

##Open Questions:
* **Question 1:** Should the system ommit meal types that are no longer available?
  * **Answer:** Yes
* **Question 2:** Should the system ommit meals for which the user does not have credit?
  * **Answer:** ?
* **Question 3:** Should the list display all meals for the day or only for the specified meal type?
  * **Answer:** Displaying all meals for choosen day.
* **Question 4:** Should the system ommit meals that are no longer available?
  * **Answer:** Yes. Listing all and displaying message if not available.