# TrademeAPI
TrademeAPI is a simple Test Automation suite demonstrating the basic usage of RestAssured, JUnit and Java for testing REST APIs.
The target application is the [Trademe Sandbox](https://www.tmsandbox.co.nz/) website.

## Prerequisites
1. Trademe Sandbox account
2. Trademe sandbox Oauth tokens (for the sake of executing these tests, I included my tokens in a tokens.properties file)

## Tools 
The following tools/libraries were used in this project.

1. Eclipse IDE (or any IDE of your choice)
2. Gradle build tool (by default, this is included in Eclipse) 
3. Git Bash (optional, Git is already integrated with Eclipse)
4. JUnit 4.12 - defined in build.gradle file
5. RestAssured 4.3 - defined in build.gradle
6. ScribeJava 2.5.3. This is used for Oauth. Anything above 2.5.x returns an AbstractRequest [issue](https://github.com/rest-assured/rest-assured/issues/880)

## Usage
1. Clone this repo

```console
$ git clone https://github.com/sniperblack20/TrademeAPI.git
```

2. Navigate to where the project was downloaded.

3. Build 

For eclipse users:

```console
$ ./gradlew cleanEclipse eclipse
```

Get dependencies and build the project:

```console
$ ./gradlew build
```

The output should look like (will take longer on first build):

```console
BUILD SUCCESSFUL in 2s
5 actionable tasks: 5 up-to-date
```

If you wanted to run the tests:

```console
$ ./gradlew test
```

## Reports
A detailed html report will be generated when this suite is used via Eclipse. It can be found under build/reports/test.

## Contributing
Pull requests are not welcome. This repo is for my personal consumption only. It may be removed without prior notice.

