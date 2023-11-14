# Open ID authentication with Jakarta EE 10, Security 3.0, and Google

## Requirements

Before you start, please make sure you have the following prerequisites installed (or install them now).

- [Java 11](https://adoptium.net/de/temurin/releases/?version=17): or use [Java 11](https://adoptium.net/de/temurin/releases/?version=11) (minimum version for Jakarta EE 10)
- [HTTPie](https://httpie.org/doc#installation): a simple tool for making HTTP requests from a Bash shell
- [Maven](https://maven.apache.org/) installed, version 3.0 or above

## Start the project

Use this command to start the project.

```bash
./mvn wildfly:run
```

Using a browser, open `http://localhost:8080/protected`. You should be prompted to log in.

## Links

This example uses the following open source libraries:

* [WildFly](https://www.wildfly.org/)

## License

Apache 2.0, see [LICENSE](LICENSE.txt).
