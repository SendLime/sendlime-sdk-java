# SendLime Server SDK for Java

This is the Java Server SDK for SendLime APIs. To use it you will need a SendLime account. Sign up for free at [sendlime.com](https://sendlime.com).

For full API documentation refer to [developer.sendlime.com](https://developer.sendlime.com).

# Table of Content <!-- omit in toc -->

- [SendLime Server SDK for Java](#sendlime-server-sdk-for-Java)
    - [Installation](#installation)
    - [Constructor](#constructor)
        - [Properties](#properties)
    - [Send SMS](#send-sms)
    - [Response](#response)
- [Support](#support)

## Installation

### Gradle

Step 1. Add the JitPack repository to your build file .

```gradle
    allprojects {
        repositories {
            maven { url 'https://jitpack.io' }
        }
    }
```

Step 2. Add the dependency.

```gradle
   dependencies {
	        implementation 'com.github.SendLime:sendlime-sdk-java:{LATEST_RELEASE}'
	}
```

### Maven

Step 1. Add the JitPack repository to your build file

```maven
    	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

Step 2. Add the dependency

```maven
   	<dependency>
	    <groupId>com.github.SendLime</groupId>
	    <artifactId>sendlime-sdk-java</artifactId>
	    <version>{LATEST_RELEASE}</version>
	</dependency>
```

---

### Version available

| Latest Release |
| ------------- |
| v1.0.6         |


## Constructor

```java
    SendLimeClient client = SendLimeClient.build()
                        .apiKey("YOUR_API_KEY")
                        .apiSecret("YOUR_API_SECRET")
                        .build();
```

### Properties

- apiKey - API Key from Sendlime API. (Required)
- apiSecret - API Secret from SendLime API. (Required)

## Send SMS

Without from

```java
    SubmitTextResponse networkResponse = client.getSmsClient()
                                                .sendMessage("TO_NUMBER", "Hello from  SendLime");
```
With from

```java
    SubmitTextResponse networkResponse = client.getSmsClient()
                                                .sendMessage("FROM_NUMBER", TO_NUMBER", "Hello from  SendLime");
```

## Response

```java
    if (networkResponse.isSuccess()) {
        System.out.println("Message sent successfully");
    } else {
        System.out.println("Message failed with error: " + networkResponse.getErrorMessage());
    }
```

# Support

[support@sendlime.com](mailto:support@sendlime.com)
