package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.List;

@Data
public class WeatherModel {

    private WeatherMain main;

    @Data
    public static class WeatherMain {
        private double temp;
    }

}
