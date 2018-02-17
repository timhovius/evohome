# Evohome (Spring Boot) Java Library
[![Build Status](https://travis-ci.org/timhovius/evohome.svg?branch=master)](https://travis-ci.org/timhovius/evohome)
[![](https://jitpack.io/v/timhovius/evohome.svg)](https://jitpack.io/#timhovius/evohome)

This is a library which you can use for your Evohome Thermostat.

## How to start

### Maven
Add `jitpack.io` to your repositories section

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Add the dependency

```xml
<dependency>
    <groupId>com.github.timhovius</groupId>
    <artifactId>evohome</artifactId>
    <version>0.1.0</version>
</dependency>
```
### Gradle
Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

```groovy
dependencies {
    compile 'com.github.timhovius:evohome:0.1.0'
}
```

## How to use
You can use the [ThermostatService](src/main/java/com/evohome/thermostat/service/ThermostatService.java)
to access your thermostat. It needs a username and password in application.yml

Example application.yml

```yaml
honeywell:
  evohome:
    username: username
    password: password
```