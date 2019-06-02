package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class WeatherService {

    public WeatherModel getWeather(String city){
        return getRestTemplate().getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350", WeatherModel.class);
    }
    public WeatherList getWeatherList(String city){
        return getRestTemplate().getForObject("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350", WeatherList.class);
    }
    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate template = new RestTemplate();
        template.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return clientHttpResponse.getRawStatusCode() != 404;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });
        return template;
    }
}
