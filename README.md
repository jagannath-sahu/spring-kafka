# spring-kafka

follow https://www.youtube.com/watch?v=QFEaRZGfZ5A&list=PLF5X0J2bZ_k7FU_ajpj1H35ocmN2wZbAO&index=3


Create new Topic on startup

KafkaAdmin

config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapAddress());

NewTopic

Create producer

KafkaTemplate

ProducerFactory
config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapAddress());
config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
# springboot-kafka-producer
