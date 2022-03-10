package ru.vlapin.trainings.integrationtraining;

import ru.vlapin.trainings.integrationtraining.model.JavaConfigBasedSetterPropertiesPlaceholderExample;
import ru.vlapin.trainings.integrationtraining.model.JavaConfigBasedSetterPropertiesPlaceholderExampleImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
//@EnableHypermediaSupport(type = HAL)
public class IntegrationTrainingApplication {

  public static void main(String[] args) {
    SpringApplication.run(IntegrationTrainingApplication.class, args);
  }

  @Bean
  @ConfigurationProperties("my-properties2")
  JavaConfigBasedSetterPropertiesPlaceholderExample mySetterProperties2() {
    return new JavaConfigBasedSetterPropertiesPlaceholderExampleImpl();
  }
}
