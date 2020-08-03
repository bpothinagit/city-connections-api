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
<li><b>Description:</br>
</b> This endpoint:</br>
      returns 'yes' if the app determines the origin and destination cities are connected.</br>
      returns 'no' if there exists no connection between the origin and destination cities
</li>
</ul>


## Steps to run and test this Spring Boot App
1. Clone this Github Repository https://github.com/bpothinagit/city-connections-api <br/>
2. Navigate to the cloned project: <i>cd city-connections-api</i><br/>
3. Install your app: <i>mvn clean install</i><br/>
3. Run the Spring Boot App: <i>mvn spring-boot:run</i>
4. On successful startup of the application, access the following endpoint to test different use cases:<br/>
	http://localhost:8080/connected?origin=Boston&destination=Newark (Expected Output: yes)<br/>
	http://localhost:8080/connected?origin=Boston&destination=Philadelphia (Expected Output: yes)<br/>
	http://localhost:8080/connected?origin=Philadelphia&destination=Albany (Expected Output: no)<br/>

