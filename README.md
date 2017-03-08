# file-uploader-app
This is a RESTFul API spring-boot application which has the following APIs to do different functionalities:
   1. [POST] _/fileupload_: API to upload a file with a few meta-data fields. Persist meta-data in persistence store (In memory DB- H2 DB)
   2. [GET] _/fileupload_: API to get all the file meta-data stored in the in-memory database
   3. [GET] _/filestream/{streamId}_: API to download content of the file which was uploaded at 1.
   4. [GET] _/fileupload/{id}_: API to get the meta-data of a file based on the provided {id} stored in the in-memory database
   
##How to run the application (Maven execution)
---------------


1. To run the application from command, make sure you have maven (3.x+) in your classpath, then lunch from the app base directory using:

			 mvn spring-boot:run

2. To run just the tests for the app :

			 mvn clean test
By default, application listens at 8080. If you want to change it to different then add below value in application.properties:
### server.port = 8090

### Sample Request/response
#### [POST]http://localhost:8080/fileupload 
![ScreenShot](https://github.com/yadab4u/file-uploader-app/blob/master/post.jpg)

#### [GET]http://localhost:8080/fileupload
![ScreenShot](https://github.com/yadab4u/file-uploader-app/blob/master/get-contents.jpg)

#### [GET] http://localhost:8080/fileupload/4
![ScreenShot](https://github.com/yadab4u/file-uploader-app/blob/master/get-fileid.jpg)

#### [GET]http://localhost:8080/filestream/2
![ScreenShot](https://github.com/yadab4u/file-uploader-app/blob/master/get-contents.jpg)
