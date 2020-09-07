

## Prerequisite
1. JDK 1.8 or above
2. MongoDB 4.0.1
3. Apache Maven 3
4. IDE - STS (Spring Tool Suite preferred)


## Application Stracture
1. Database - MongoDB NoSQL database to store and retrieve data.
2. RestController Layer - To control requests and responses.
3. Repository Layer - To store and retrieve data from database.
4. Product - The product that want to access the API resource.


## Steps to Run the project 

## Step 1: Create database and collection in MongoDB

 ```
      use users_db
 ```
 
 Create collection in the DB
 
 
 ```
      db.createCollection("product");
 ```
 
 Insert given mock data to collection product 

 Refer Mock data - (https://api.jsonbin.io/b/5ebe673947a2266b1478d892)
 

 
 ## Step 2: Download and run the project
 
1. Download The Project
2. Go to the project folder
3. Run following command
      ```
      mvn eclipse:eclipse
      ```
      ```
      mvn clean compile
      ```
      ```
      mvn spring-boot:run
      ```
      

 
 
 
