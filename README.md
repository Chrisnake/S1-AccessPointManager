# Summer 2018 Project 4: UAPManager

UAPManager is a program that emulates a user of the university environment accepting or declining their rights to gain access to access points around campus. 

## How it works
1) A member of staff registers a new user of the system (Student, Staff) with their respective details such as University ID, password, position, accomodation and department. 
2) After complete registration, the user information is stored on an instance of the MySQL database and is seperated into different tables.
3) The user has a physical RFID card that has stored their details and uses their universityID to review if they have access to a room around campus. For example, if the user wants to access the library, they will scan their card and the system will check if their is an acceptance match in the database to give rights to access to the library.
4) Since I do not have the resources to RFID cards I will emulate this process by providing an access frame on the program that allows the user to choose which building they want to access.

## Starting JFrames for UAPManager

<img width="445" alt="screen shot 2018-07-11 at 23 22 00" src="https://user-images.githubusercontent.com/32743122/42602418-4bac9b1e-8561-11e8-9c0e-6315e09cdea1.png">
<img width="444" alt="screen shot 2018-07-11 at 23 23 01" src="https://user-images.githubusercontent.com/32743122/42602442-63b7b6b2-8561-11e8-9bff-05164947ac78.png">
