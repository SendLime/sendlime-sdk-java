# SendLime Server SDK for Java

This is the Java Server SDK for SendLime Messaging API v2. To use it you need a SendLime account and an API key from the dashboard.

Full documentation:

- Developer docs: [developer.sendlime.com](https://developer.sendlime.com)
- API reference: [api.sendlime.com/api-docs](https://api.sendlime.com/api-docs)

## Installation

### Gradle

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.SendLime:sendlime-sdk-java:v1.2.0'
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.SendLime</groupId>
    <artifactId>sendlime-sdk-java</artifactId>
    <version>v1.2.0</version>
</dependency>
```

## Constructor

```java
SendLimeClient client = SendLimeClient.build()
    .apiKey("sl_live_your_key_here")
    .build();
```

## Supported APIs

| API          | Supported? |
|--------------|------------|
| SMS API      | Yes        |
| WhatsApp API | Yes        |
| Balance API  | Yes        |
| Verify API   | Legacy / deprecated |

## Send an SMS

Without sender / brand ID:

```java
SendMessageResponse response = client.getSmsClient().sendMessage(TO_NUMBER, "Hello World!");
```

With an approved sender / brand ID:

```java
SendMessageResponse response = client.getSmsClient().sendMessage(BRAND_ID, TO_NUMBER, "Hello World!");
```

```java
if (response.isSuccess()) {
    System.out.println(response.getResult().getMessageId());
} else {
    System.out.println(response.getErrorMessage());
}
```

## Send a WhatsApp message

```java
SendMessageResponse response = client.getSmsClient().sendWhatsAppMessage(TO_NUMBER, "Hello from WhatsApp!");
```

Pass a WhatsApp profile brand ID as the first argument if you need to select a specific approved profile.

```java
SendMessageResponse response = client.getSmsClient().sendWhatsAppMessage(BRAND_ID, TO_NUMBER, "Hello from WhatsApp!");
```

## Check balance

```java
BalanceResponse response = client.getSmsClient().getBalance();

if (response.isSuccess()) {
    System.out.println(response.getResult().getBalance());
} else {
    System.out.println(response.getErrorMessage());
}
```

## Support

[support@sendlime.com](mailto:support@sendlime.com)
