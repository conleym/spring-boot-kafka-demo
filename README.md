# Spring Boot Kafka Demo

Incredibly basic Spring Boot Kafka demo.
Uses [Kafka autoconfiguration](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/kafka/KafkaAutoConfiguration.java).

Assumes Kafka is running on localhost on the standard port (9092). You can get this going by following their [quickstart guide](https://kafka.apache.org/quickstart),
although you might want to download the latest version rather than the slightly-dated version they specify.

## What it does

The app will create a topic, called `demo`. An HTTP POST message to /kafka/send will send a string message to this topic:

```
curl -X POST localhost:8080/kafka/send
```

You should see something like the following:

```
SendResult [producerRecord=ProducerRecord(topic=demo, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=hello there., timestamp=null), recordMetadata=demo-0@6]
```

## Reading messages

Use the `kafka-console-consumer.sh` script that comes with kafka:

```
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic demo
```

You should see `hello there.` each time you post to the endpoint.