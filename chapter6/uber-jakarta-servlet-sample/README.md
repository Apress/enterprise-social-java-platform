# Uber Rides Java SDK Jakarta Servlet Sample

Official Java SDK (beta) to support the Uber Rides API.

## Running the sample

First, add your client ID and secret retrieved from developer.uber.com to `src/main/resources/secrets.properties`.

To run the command line sample, run `$ mvn clean package exec:java -Dexec.mainClass="Your main class"`. You
may need to add the redirect URL to your application (at developer.uber.com) for OAuth2 to succeed.

Running the sample will store user credentials in your home directory under `.uber_credentials` for future executions.

For full documentation, visit the Uber [Developer Site](https://developer.uber.com).

## Getting help

Uber developers actively monitor the [uber tag](http://stackoverflow.com/questions/tagged/uber-api) on StackOverflow.
If you need help installing or using the library, you can ask a question there.  Make sure to tag your question
with `uber-api` and `java`!