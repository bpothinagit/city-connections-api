# city-connections-api
This is a Spring Boot App to determine if two given cities are connected using a REST endpoint.

## What you'll need to run and test this app
<ul>
<li>JDK 1.8 or above</li>
<li>Maven 3 or above</li>
</ul>

## Details about the REST end point
<ul>
<li><b>Endpoint:</b> /connected</li>
<li><b>Request Parameters:</b> origin, destination</li>
<li><b>Possible Outputs:</b> 'yes' or 'no'</li>
<li><b>Description:</b> For the given origin and destination cities, this app will determine whether a connection exists between them based on the list of available roads. </br>
      App will return 'yes' if the cities are connected, else 'no' is returned.
</li>
</ul>

## Steps to run and test this Spring Boot App
1. Clone this Github Repository https://github.com/bpothinagit/city-connections-api <br/>
2. Navigate to the cloned project: <i>cd city-connections-api</i><br/>
3. Default port for Spring Boot App is 8080. </br>
   If you wish to run this on the port of your choice, mention the <i>server.port</i> property in application.properties file and accordingly use the new port in the URLs and Swagger URLs.
4. Install your app: <i>mvn clean install</i><br/>
5. Run the Spring Boot App: <i>mvn spring-boot:run</i>
6. On successful startup of the application, access the following end point to test different use cases:<br/>
	[Boston_Newark](http://localhost:8080/connected?origin=Boston&destination=Newark) (Expected Output: yes)<br/>
	[Boston_Philadelphia](http://localhost:8080/connected?origin=Boston&destination=Philadelphia) (Expected Output: yes)<br/>
	[Philadelphia_Albany](http://localhost:8080/connected?origin=Philadelphia&destination=Albany) (Expected Output: no)<br/>

## Swagger Documentation
[Swagger UI (HTML)](http://localhost:8080/swagger-ui.html)</br>
[Swagger API Docs (JSON)](http://localhost:8080/v2/api-docs)