Credit Card service comes with adding and retrieving of credit card data in the database using RESTAPIs.

Technologies used:

Database: In-memory H2 database
Database scripts: Flyway
Rest Client: Swagger UI
For mapping DTO's to models: Mapstruct

You might run into an issue while starting the application after building in Eclipse IDE due to mapper implementation.
To resolve it, add the generated sources -> annotations folder present in target folder to your build path.

Since, authentication has been implemented using in memory username and password credentials, you might see a pop up while accessing the APIs.

Sample request for addCreditCard api is:

{
  "creditCardDetails": {
    "amountLimit": null,
    "cardNumber": ""
  },
  "name": "Diya"
}
