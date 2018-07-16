# Summer 2018 Project 4: UAPManager

UAPManager is a program that emulates a user of the university environment attempting to access a building on campus in respect to their rights to gain access to the specific building. Students and members of staff are allowed access to their respective departments related buildings, along with their Student accomodation. The program also takes into consideration global buildings such as the Library and lecture centre, which are accessible by any user with an ID, and time constraints for when specific buildings are closed. 

## How it works
1) A member of staff or student registers a new user of the system (Student, Staff) with their respective details such as University ID, password, position, accomodation and department. 
2) After complete registration, the user information is stored on an instance of the MySQL database and is seperated into a table called users.
3) The user has a physical RFID card that has stored their details and uses their universityID to review if they have access to a room around campus. For example, if the user wants to access the library, they will scan their card and the system will check if their is an acceptance match in the database to give rights to access to the library.
4) Since I do not have the resources to RFID cards I will emulate this process by providing an access frame on the program that allows the user to choose which building they want to access.

## UAPManager GUI

![mockup](https://user-images.githubusercontent.com/32743122/42784189-46ed698a-8946-11e8-849f-a4835bf96c18.png)
![3](https://user-images.githubusercontent.com/32743122/42784204-501828a6-8946-11e8-8ff9-fbc795ba92bd.png)
![5](https://user-images.githubusercontent.com/32743122/42784213-5798f3f8-8946-11e8-9136-bf20198f2d1e.png)
