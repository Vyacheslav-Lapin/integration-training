package ru.vlapin.trainings.integrationtraining.controller;

import com.medium.types.calculator.AdditionInput;
import com.medium.types.calculator.DivisionInput;
import com.medium.types.calculator.MultiplicationInput;
import com.medium.types.calculator.ObjectFactory;
import com.medium.types.calculator.Output;
import com.medium.types.calculator.SubtractionInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import ru.vlapin.trainings.integrationtraining.common.Loggable;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Slf4j
@Endpoint
@Loggable
@RequiredArgsConstructor
public class Calculator {

  public static final String NAMESPACE = "http://medium.com/types/calculator";

  @ResponsePayload
  @SuppressWarnings("unused")
  @PayloadRoot(namespace = NAMESPACE, localPart = "AdditionInput")
  public Output addition(@RequestPayload AdditionInput input) {
    val output = new ObjectFactory().createOutput();
    output.setResult(input.getNumber1() + input.getNumber2());
    return output;
  }

  @ResponsePayload
  @SuppressWarnings("unused")
  @PayloadRoot(namespace = NAMESPACE, localPart = "SubtractionInput")
  public Output subtraction(@RequestPayload SubtractionInput input) {
    val output = new ObjectFactory().createOutput();
    output.setResult(input.getNumber1() - input.getNumber2());
    return output;
  }

  @ResponsePayload
  @SuppressWarnings("unused")
  @PayloadRoot(namespace = NAMESPACE, localPart = "MultiplicationInput")
  public Output multiplication(@RequestPayload MultiplicationInput input) {
    val output = new ObjectFactory().createOutput();
    output.setResult(input.getNumber1() * input.getNumber2());
    return output;
  }

  @ResponsePayload
  @SuppressWarnings("unused")
  @PayloadRoot(namespace = NAMESPACE, localPart = "DivisionInput")
  public Output division(@RequestPayload DivisionInput input) {

    if (input.getNumber2() == 0)
      throw new IllegalArgumentException("Divisor can't be null");

    val output = new ObjectFactory().createOutput();
    output.setResult(input.getNumber1() + input.getNumber2());
    return output;
  }
}
