# Apache KAFKA

[tutorialspoint.com](https://www.tutorialspoint.com/apache_kafka/index.htm)

[Confluent](https://www.confluent.io/blog/set-up-and-run-kafka-on-windows-linux-wsl-2/)

[kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/](https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/)

[analyticsinsights](https://analyticsinsights.io/aoache-kafka/)

[wiki](https://fr.wikipedia.org/wiki/Apache_Kafka)
__
[download Kafka](https://kafka.apache.org/downloads)

## Summary :
- [Execution](#execution)
- [Avantages](#avantages)
- [Inconvénients](#inconvénients)
- [api](#api)
- [composants](#components)

## Introduction: 

Kafka is a messaging system. A messaging system is responsible for transferring data from one application to another. In this way, the applications can focus on data, and not worry about gow to share it.
Distributed messaging is based on the concept of queing. Messages are queued asynchrounously, between client ^pplications and messaging system.
There are two types of messaging patterns: 
- point to point
- publish sbscribe (--> most of the messaging patterns)

Permet de centraliser et de paralleliser le traitement des messages.
Traitement asynchrone --> 

Kafka est utilisé principalement pour la mise en place de « data pipeline » temps réel mais ce n'est pas sa seule application possible dans le monde de l'entreprise. Il est aussi de plus en plus utilisé dans les architectures micro services comme système d’échange, dans la supervision temps réel et dans l’IOT15. Kafka apporte sa capacité à ingérer et diffuser une grande quantité de données, couplé à un framework de data stream processing, il permet le traitement complexe et en temps réel des données.

### Message Broker Use Case
The developers face the problem of successful data exchange. 
Imagine you have your own application. For example, it's an online store. So, you permanently work in your technological scope, and one day you need to make the application interact with other apps. Previously, you would use simple "end points" for machine to machine communication. But nowadays we have special message brokers. They make the process of data exchange simple and reliable. These tools use different protocols that determine the message format. The protocols show how the message should be transmitted, processed, and consumed.

### Point to Point messaging system:

In a point to point system, messages are persisted in a queue. One, or more consumers can consume the messages in the queue, but a particular message can be consumed by a maximum of ONE consumer only.
One a consumer reads a message in the queue, it disappears from that queue.

### Publish Subscribe messaging system: 

In the Pub-Sub messaging system, messages are persisted in a topic. Unlike point-to-point system, consumers can subscribe to one or more topic and consume all the messages in that topic.
In the Pub-Sub system, messages producers are callde **publishers** and messages consumers are called **subscribers**.

## ZOOKEEPER: 

### What is ZooKeeper?
ZooKeeper is a centralized service for maintaining configuration information, naming, providing distributed synchronization, and providing group services. All of these kinds of services are used in some form or another by distributed applications. Each time they are implemented there is a lot of work that goes into fixing the bugs and race conditions that are inevitable. Because of the difficulty of implementing these kinds of services, applications initially usually skimp on them, which make them brittle in the presence of change and difficult to manage. Even when done correctly, different implementations of these services lead to management complexity when the applications are deployed.

### Start Zookeeper:
```
bin/zookeeper-server-start.sh config/zookeeper.properties
```

## KAFKA: 

### What is kafka ?

Apache Kafka is a distributed publish-subscribe messaging system, and a robust queue that can handle a high volume of data and enables you to pass messages from one end-point to another.
Kafka is suitable for both offline and online message consumption. Kafka messages are persisted on the disk and replicated within the cluster to prevent data loss. Kafka is built on top of the ZooKeeper synchornization service. It integrates very well with Apache Storm and Spark for real-time streaming data analysis.

There are lots of Kafka-on-Windows tutorials, but most make the mistake of running Kafka directly on the JVM on Windows. Superficially, this appears to work, but there are limitations: Kafka uses specific features of POSIX to achieve high performance, so emulations—which happen on WSL 1—are insufficient. For example, the broker will crash when it rolls a segment file. Always run Kafka on Windows in a Linux environment backed by WSL 2.

Another approach that works well is to run Kafka in Docker containers. Docker Desktop for Windows has been updated to use the WSL 2 back end, so Docker works exactly as it does on native Linux, without needing to spin up an entire VM.

**Principale fonction est la centralisation des flux de données.**

La fonction première d’Apache Kafka est d’optimiser la transmission et le traitement des flux de données qui sont directement échangés entre le destinataire de données et la source. Kafka fait office d’instance de messagerie entre l’émetteur et le récepteur, et propose des solutions permettant de résoudre les problèmes généralement associés à ce type de connexion.

**Une puissante plateforme de streaming associée à une vaste panoplie de fonctionnalités.**
<a name="execution"></a>

L’exécution d’Apache Kafka se fait en tant que Cluster (grappe de serveurs) sur un ou plusieurs serveurs, pouvant concerner différents centres de calculs. Les différents nœuds du cluster, que l’on appelle aussi Broker, stockent et catégorisent les flux de données en topics. Les données sont ensuite réparties en partitions avant d’être répliquées et distribuées dans le cluster avec un horodateur. 

Les applications qui éditent des données dans une grappe de serveurs Kafka sont désignés comme producteurs (producer), tandis que toutes les applications qui lisent les données d'un cluster Kafka sont appelées des consommateurs (consumer). La composante centrale à laquelle accèdent producteurs et consommateurs lors du traitement des flux de données est une bibliothèque Java portant le nom de Kafka Stream.



### Avantages: 
<a name="avantages">
- **Haut débit:**
Kafka peut gérer des données à grande vitesse et à volume élevé. ( des milliers de messages par seconde)
- **Faible latence:**
Kafka peut gérer les messages avec une latence faible (quelques millisecondes)
- **Tolerance de panne:**
Avec la redondance, Kafka posddèe une capacité à résister au pannes de noeuds et de materiel au sein d'un cluster.
- **Durabilité:**
Les données sont persistées et peuvent être redondées.
- **Evolutivité:**
Kafka peut etre etendu sans aucun temps mort. La gestion des messages reste totalement transparente. Son architecture distribuée le rend totalement evolutif, grâce notemment à la replication et au partitionnement.
- **Les capacités du broker:**
Kafka peut performer en remplacement d'un broker plus traditionnel.

### Inconvénients: 
<a name="inconvénients">
- **Reglage du message:**
Le message doit etre immutable, les performances de kafka diminuent considerablement si le message doit etre modifié.
- **Pas de selection de sujets génériques:**
Il faut le nom exact du topic pour qu'un message lui parvienne. Par conséquent, pas de sujet "générique".
- **Instabilité:**
Lorsque le nombre de files d'attentes dans un cluster augmente considerablement, le comportement de Kafka peut être un peu maladroit.

### Apis: 
<a name="api">
Kafka comprend cinq APIs de base :

#### Producer API:
> Permet aux applications d'envoyer des flux de données aux topics du cluster Kafka.
#### Consumer API:
> Permet aux applications de lire des flux de données à partir des topics du cluster Kafka.
#### Streams API: 
> Permet de transformer des flux de données en topic de sortie.
#### Connect API:
> Permet d'implémenter des connecteurs qui récupèrent les données d'un système source ou d'une application vers Kafka ou qui poussent de Kafka vers une application.
#### AdminClient API: 
> Permet de gérer et d'inspecter les topics, les brokers, et les autres objets Kafka .

La communication entre les applications-client et les différents serveurs du Cluster Apache se fait au moyen d’un protocole, simple et performant, indépendant d’un langage de programmation, sur une base TCL. 

### Components: <a name="components">

#### Brokers:
- Brokers are the components that are responsible for maintaining the pub-lished data. Each broker hae zero or more partitions per topic. Assume, if there are N partitions in a topic and N number of brokers, each broker will have one partition.
- If there are N partitions put more than N brokers (n + m), the first N brokers will have one partition and the next M brokers will not have any partition for that topic.
- If there are N partitions in a topic and less than N brokers (n-m), each broker will have one or more partition sharing among them. But this scenario is not recommended due to inequal load distribution among the broker.

### Start Kafka broker: 
```
bin/kafka-server-start.sh config/server.properties
```

#### Kafka cluster: 
Kafka's having more than one broker are called "kafka cluster". A kafka cluster can be expanded without downtime. These clusters are used to manage the persistence and replication of message data.

#### Topics: 

A stream of messages belonging to a particular category is called a topic. Data is stored in topics.

Topics are split into partitions. For each topic, Kafka keeps a mini-mum of one partition. Each such partition contains messages in an immutable ordered sequence. A partition is implemented as a set of segment files of equal sizes.

##### Create a topic : 
```
./bin/kafka-topics.sh  --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic blabla 
```

##### Alter a topic to ad partitions : 
```
./bin/kafka-topics.sh --alter --zookeeper localhost:2181 --topic blabla --partitions 2
```

##### Describe a topic:
```
./bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic blabla
```

#### Partition and partition offset: 

Topics may have many partitions, so it can handle an arbitrary amount of data. 
```
--partitions ##
```
	
Each partitioned message has a unique sequence id called as offset.

#### Replicas of partition:

Replicas are nothing but backups of a partition. Replicas are never read or write data. They are used to prevent data loss.


#### Producers: 
Producers = publishers of messages. Producers send data to kafka brokers. Everytime a porducer publishes a message to a broker, the broker simply appends the message to the last segment file. Actually, the message will be appended to a partition. Producer can also send messages to a partition of their choice.
##### Create a producer:
```
./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic blabla
```

#### Consumers:
Consumers read data from brokers. Consumers subscribe to one or more topics and consume published messages py pulling data from the brokers.
##### Create a consumer: 
```
./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic blabla
```
##### With a group id:
```
$ ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic blabla --consumer-property group.id=mygroup
```

#### Leader:
The Leader is the node responsible for all reads and writes for the given partition. Every partition has one server acting as a leader.

#### Follower:
Node which follows leader instructions are called as follower. If the leader fails, one of the follower will automatically become the new leader. As follower act as normal consumer, pulls messages and updates its own data store.

<details>
	<summary>Screenshots: </summary>
	<h2>ZOOKEEPER: </h2>
	<img src="ZOOKEEPER.png" alt="Zookeeper">
	<h2>BROKER: </h2>
	<img src="BROKER.png" alt="Broker">
	<h2>TOPIC CREATION: </h2>
	<img src="topic.png" alt="Topic">
	<h2>PRODUCER: </h2>
	<img src="producer.png" alt="producer">
	<h2>CONSUMER: </h2>
	<img src="consumer.png" alt consumer>
</details>
