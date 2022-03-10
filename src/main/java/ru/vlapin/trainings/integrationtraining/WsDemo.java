package ru.vlapin.trainings.integrationtraining;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import static javax.jws.soap.SOAPBinding.Style.*;

@Slf4j
@WebService // помечает класс как web-service
@SOAPBinding(style = RPC) // Определяет тип
public class WsDemo {
  public String sayHello(String name) {
    return "Hello, %s!".formatted(name);
  }

  public static void main(String... __) {
    val address = "http://localhost:1212/hello";
    Endpoint.publish(address, new WsDemo());
    log.info("address: {}", address);
  }
}
