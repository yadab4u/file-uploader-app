# file-uploader-app
This is a RESTFul API spring-boot application which have the following APIs to do different functionalities functionalities:
   1. [POST] _/fileupload_: API to upload a file with a few meta-data fields. Persist meta-data in persistence store (In memory DB- H2 DB)
   2. [GET] _/fileupload_: API to get all the file meta-data stored in the in-memory database
   3. [GET] _/filestream/{streamId}_: API to download content of the file which was uploaded at 1.
   4. [GET] _/fileupload/{id}_: API to get the eta-data of a file based on the provided {id} stored in the in-memory database
   
##How to run the application (Maven execution)
---------------


1. To run the application from command, make sure you have maven (3.x+) in your classpath, then lunch from the app base directory using:

			 mvn spring-boot:run

2. To run just the tests for the app :

			 mvn clean test
