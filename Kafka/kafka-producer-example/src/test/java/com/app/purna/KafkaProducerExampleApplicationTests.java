//package com.app.purna;
//
//import com.app.purna.dto.Customer;
//import com.app.purna.service.KafkaMessagePublisher;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//import static java.util.concurrent.TimeUnit.SECONDS;
//import static org.awaitility.Awaitility.await;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Testcontainers
//class KafkaProducerExampleApplicationTests {
//
//	@Container
//	static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
//	@DynamicPropertySource
//	public static void intiKafkaProperties(DynamicPropertyRegistry registry)
//	{
//		registry.add("spring.kafka.bootstrap-servers",kafka::getBootstrapServers);
//	}
//	@Autowired
//	private KafkaMessagePublisher publisher;
//	@Test
//	public void testSendEventsToTopic()
//	{
//		publisher.sendEventsToTopic(new Customer( 22, "purna","purna@gmail.com","8890675342"));
//		await().pollInterval(Duration.ofSeconds(3))
//				.atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
//					//assert statement
//				});
//	}
//}
