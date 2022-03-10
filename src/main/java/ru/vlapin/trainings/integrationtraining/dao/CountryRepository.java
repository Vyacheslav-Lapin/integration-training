package ru.vlapin.trainings.integrationtraining.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.baeldung.springsoap.gen.Country;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Component;

import static com.baeldung.springsoap.gen.Currency.*;

@Component
@RequiredArgsConstructor
public class CountryRepository {

  private static final Map<String, Country> countries = new HashMap<>();

  @PostConstruct
  public void initData() {
    val spain = new Country();
    spain.setName("Spain");
    spain.setPopulation(46704314);
    spain.setCapital("Madrid");
    spain.setCurrency(EUR);
    countries.put("Spain", spain);
  }

  public Country findCountry(String name) {
    return countries.get(name);
  }
}
