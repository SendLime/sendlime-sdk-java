# SendLime Server SDK for Java

This is the Java Server SDK for SendLime APIs. To use it you will need a SendLime account. Sign up for free at [sendlime.com](https://sendlime.com).

For full API documentation refer to [developer.sendlime.com](https://developer.sendlime.com).

# Table of Content <!-- omit in toc -->

- [Installation](#installation)
    - [Gradle](#gradle)
    - [Maven](#maven)
    - [Version Available](#version-available)
- [Constructor](#constructor)
    - [Properties](#properties)
- [Supported APIs](#supported-apis)
- [SMS](#sms)
    - [Send an SMS](#send-an-sms)
    - [Response](#response)
- [Verify](#verify)
    - [Send a Code](#send-a-code)
        - [Response](#response-1)
    - [Verify a Code](#verify-a-code)
        - [Response](#response-2)
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

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency

```xml
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
| v1.0.11         |


## Constructor

```java
SendLimeClient client = SendLimeClient.build()
                    .apiKey(YOUR_API_KEY)
                    .apiSecret(YOUR_API_SECRET)
                    .build();
```

### Properties

- apiKey - API Key from Sendlime API. (Required)
- apiSecret - API Secret from SendLime API. (Required)


## Supported APIs

The following is a list of SendLime APIs and whether the Node Server SDK provides support for them:

| API        | Supported? |
|------------|------------|
| SMS API    | ✅          |
| Verify API | ✅          |
## SMS
### Send an SMS

Without from (message will be sent from a random number)

```java
SendMessageResponse sendMessageResponse =  client.getSmsClient().sendMessage(TO_NUMBER, "Hello World!");
```
With from (message will be sent from the registered brand or the purchased number you have mentioned)

```java
SendMessageResponse sendMessageResponse =  client.getSmsClient().sendMessage(REGISTERED_BRAND_PHONE, TO_NUMBER, "Hello World!");
```

#### Response

```java
if (sendMessageResponse.isSuccess()) {
    System.out.println("Sent");
} else {
    System.out.println(sendMessageResponse.getErrorMessage());
}
```

## Verify

### Send a Code
```java
SendCodeResponse sendCodeResponse = client.getCodeClient().sendCode(BRAND, TO_NUMBER, LOCALE, CODE_LENGTH);
```

#### Response
```java
if (sendCodeResponse.isSuccess()) {
    System.out.println(sendCodeResponse.getResult().getRequestId());
} else {
    System.out.println(sendCodeResponse.getErrorMessage());
}
```

### Verify a Code
```java
VerifyCodeResponse verifyCodeResponse = client.getCodeClient().verifyCode(REQUEST_ID, CODE);
```

#### Response
```java
if (verifyCodeResponse.isSuccess()) {
    System.out.println("Verified");
} else {
    System.out.println(verifyCodeResponse.getErrorMessage());
}
```

# Support

[support@sendlime.com](mailto:support@sendlime.com)
