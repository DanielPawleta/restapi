package dpawleta.restapi.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest
@Testcontainers
public class BaseIntegrationTest {

    @Container
    private static PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:14.1")
                    .withDatabaseName("postgres")
                    .withPassword("postgres")
                    .withUsername("postgres");

    @DynamicPropertySource
    public static void containerConfig(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        dynamicPropertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);

    }
}
