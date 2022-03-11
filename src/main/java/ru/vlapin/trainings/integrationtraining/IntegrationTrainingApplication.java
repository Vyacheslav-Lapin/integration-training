package ru.vlapin.trainings.integrationtraining;

import lombok.val;
import ru.vlapin.trainings.integrationtraining.model.JavaConfigBasedSetterPropertiesPlaceholderExample;
import ru.vlapin.trainings.integrationtraining.model.JavaConfigBasedSetterPropertiesPlaceholderExampleImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
//@EnableHypermediaSupport(type = HAL)
public class IntegrationTrainingApplication extends WsConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(IntegrationTrainingApplication.class, args);
  }

  @Bean
  @ConfigurationProperties("my-properties2")
  JavaConfigBasedSetterPropertiesPlaceholderExample mySetterProperties2() {
    return new JavaConfigBasedSetterPropertiesPlaceholderExampleImpl();
  }

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext){
    val messageDispatcherServlet = new MessageDispatcherServlet();
    messageDispatcherServlet.setApplicationContext(applicationContext);
    return new ServletRegistrationBean<>(
        messageDispatcherServlet,
        "/medium/ws/*");
  }

  @Bean(name = "calculatorDemo")
  public Wsdl11Definition wsdl11Definition(){
    val simpleWsdl11Definition = new SimpleWsdl11Definition();
    simpleWsdl11Definition.setWsdl(new ClassPathResource("/wsdl/calculator.wsdl"));
    return simpleWsdl11Definition;
  }
}
