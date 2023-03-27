## **Casino Game Backend**

This is a Java/Spring Boot backend for a simple betting game. Players can send a bet and a number between 1 and 100 to the server, which generates a random number and calculates the player's win based on the bet and the difference between the player's number and the generated number.

The code consists of three main components: the controller, the model, and the service.

## Technologies

The following technologies are used in this project:

* Java 11
* Spring Boot
* Mockito
* JUnit
* Maven

## **API Endpoints**

The backend provides the following API endpoints:

* **POST /game**: Play a new game. The request body should be a JSON object with the following fields: 
* * **bet** (required): The amount the player wants to bet.
* * **number** (required): The number the player has chosen, between 1 and 100. 

The response body will be a JSON object with a single field, win, which is the amount the player has won.

## Controller

The **GameController** class is responsible for handling incoming HTTP requests and calling the appropriate service method. It is annotated with **@Controller** and **@RequestMapping("/game")**, which means that it will handle requests that begin with "/game".

There is only one method in the controller, **playGame()**, which is annotated with **@PostMapping** and expects a **Bet** object as the request body. This method calls the **playGame()** method of the **GameService** and returns the resulting win amount as a **ResponseEntity**.

## Model

The **Bet** class represents a user's bet. It has two properties: **bet** and **number**. **bet** is a **Double** value representing the amount the user has bet, and **number** is an **Integer** value representing the number the user has chosen. Both properties have validation constraints using the **javax.validation.constraints annotations**.

## Service

The **GameService** interface defines the contract for the service that simulates the game. It has only one method, **playGame()**, which takes a **Bet** object as an argument and returns a **Double** representing the win amount.

The **GameServiceImpl** class implements the **GameService** interface. It has one method, **playGame()**, which generates a random number between 1 and 100 and compares it to the user's chosen number. If the user's number is greater, it calculates the win amount based on a formula and returns it. Otherwise, it returns 0.

## Example Requests

**Play a Game** <br />
Request:

`POST /game` <br />
`Content-Type: application/json` <br />
`{` <br />
`"bet": 40.5,` <br />
`"number": 50` <br />
`}` <br />

Response:

`HTTP/1.1 200 OK`<br />
`Content-Type: application/json` <br />
`{` <br />
`"win": 80.19` <br />
`}` <br />

**Error Responses** <br />
If the request is missing the bet or number fields, or if the bet or number values are outside the allowed range, the server will return a 400 Bad Request response with an error message in the response body.

Example:

Request:

`POST /game` <br />
`Content-Type: application/json` <br />
`{` <br />
`"bet": 40.5` <br />
`}` <br />

Response:

`HTTP/1.1 400 Bad Request` <br />
`Content-Type: application/json` <br />
`{` <br />
`"error": "Invalid request: missing 'number' field"` <br />
`}` <br />

## Testing <br />

To run the unit and integration tests for the backend, run the following command from the project directory:


`mvn test`
