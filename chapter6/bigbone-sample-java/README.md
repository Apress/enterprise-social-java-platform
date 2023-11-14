# BigBone Java Samples

## Requirements

Before you start, please make sure you have the following prerequisites installed (or install them now).

- [Java 11](https://adoptium.net/de/temurin/releases/?version=11)
- [Maven](https://maven.apache.org/): version 3.0 or above


## Create an OIDC Application
1. Using a browser (or Mastodon client), open `https://<mastodon.instance>/settings/applications`, where `<mastodon.instance>` is your Mastodon server, e.g. `mastodon.social`.
2. Click `New application`.
3. Fill out the mandatory `Application name`, e.g. "ApressBookDemoApp".
4. Click `Submit`
5. You'll see the `Client key`, `Client secret` and `access token` of your application. Copy `Your access token` and store it in a safe place.

## Start the project

There are two types of sample apps:
1. Public
2. Account Specific

### Public
Use this command to start public samples.

```bash
mvn compile exec:java -Dexec.mainClass="Your main class" -Dexec.args="<mastodon.instance>" -Dexec.cleanupDaemonThreads=false
```

`Your main class` is one of the following:
- `com.apress.entsocjava.bigbone.GetInstanceInfo`
- `com.apress.entsocjava.bigbone.GetPublicTimeline`

### Account Specific
Use this command to start account specific samples.

```bash
mvn compile exec:java -Dexec.mainClass="Your main class" -Dexec.args="<mastodon.instance>, <Your access token>" -Dexec.cleanupDaemonThreads=false
```

`Your main class` is one of the following:
- `com.apress.entsocjava.bigbone.GetConversations`
- `com.apress.entsocjava.bigbone.GetHomeTimelineWithFiltering`

## Links

More Java examples:

* [BigBone Sample Java](https://github.com/andregasser/bigbone/tree/master/sample-java)

## License

MIT License, see [LICENSE](https://opensource.org/license/mit/).
