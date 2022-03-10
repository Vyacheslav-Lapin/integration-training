package ru.vlapin.trainings.integrationtraining.controller;

import com.baeldung.springsoap.gen.GetCountryRequest;
import com.baeldung.springsoap.gen.GetCountryResponse;
import lombok.RequiredArgsConstructor;
import lombok.val;
import ru.vlapin.trainings.integrationtraining.dao.CountryRepository;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class CountryEndpoint {

  private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

  CountryRepository countryRepository;

  @ResponsePayload
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {

    val response = new GetCountryResponse();

    response.setCountry(
        countryRepository.findCountry(
            request.getName()));

    return response;
  }
}
