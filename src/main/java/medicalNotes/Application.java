package medicalNotes;

import lombok.extern.slf4j.Slf4j;
import medicalNotes.config.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * This class is the main class for medicalNotes microservice
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"medicalNotes"})
@EntityScan("medicalNotes")
@EnableFeignClients("medicalNotes")
@Generated
public class Application {

    public static void main(String[] args) {
        log.info("Launch medicalNotes module");
        SpringApplication.run(Application.class, args);
    }

}
