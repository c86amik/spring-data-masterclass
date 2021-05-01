# spring-data-masterclass

## A good understanding of the usage of spring-data with REST Service and using Mongo as local Database

### Software Required
* [Java 1.8](https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)
* [Spring tool Suite](https://spring.io/tools) or [Eclipse](https://www.eclipse.org/downloads/packages/release/helios/sr1/eclipse-ide-java-developers)
* [Apache Maven](https://maven.apache.org/download.cgi)
* [Git Bash](https://gramfile.com/git-bash-download/)
* [MongoDB](https://www.mongodb.com/try/download/community) - Download the Community Edition
* [Robo 3T](https://robomongo.org/download) - MongoDB Client. Download Robo 3T Only
* [Postman](https://www.postman.com/downloads/)


### Steps to clone and run the application
* Open Git Bash in your machine
* Clone the application from github.com as   
<code>git clone https://github.com/c86amik/spring-data-masterclass.git</code>
* Open either <strong>STS</strong> or <strong>Eclipse</strong> and import the application as <strong>Maven</strong> project
* After the application got successfully imported in either <strong>STS</strong> or <strong>Eclipse</strong>
* Right Click on the application, select the <strong>Run As</strong> option, and then select <strong>Spring Boot App</strong>
* The application will start in the port <strong>7111</strong>
* Open the Postman and test the REST Endpoints

### Testing using Postman
* <strong>Get All Users</strong> - localhost:7111/allUsers
* <strong>Save an User</strong> - localhost:7111/saveUser
* <strong>Update an User</strong> - localhost:7111/updateUser/{id}. Here <strong>{id}</strong> is the id of the record stored in MongoDB
* <strong>Delete an User</strong> - localhost:7111/deleteUser/{id}
* <strong>Get user by firstName</strong> - localhost:7111/getUserByFirstName/{firstName}
* <strong>Get user by lastName</strong> - localhost:7111/getUserByLastName/{lastName}
* <strong>Get user by mobileNo</strong> - localhost:7111/getUserByMobileNo/{mobileNo}
* <strong>Get user by Email</strong> - localhost:7111/getUserByEmail/{email}
* <strong>Get user by panNo</strong> - localhost:7111/getUserByPan/{panNo}
* <strong>Get user by name</strong> - localhost:7111/getUserByName/{firstName}/{lastName}. Here <strong>name</strong> is the combination of <strong>firstName</strong> and <strong>lastName</strong>