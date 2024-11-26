package com.prosoft.spring_boot_profile.config;

import com.prosoft.spring_boot_profile.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    /**
     * Бин создается при spring.profiles.active=black из application.properties
     */
    @Bean
    @Profile("black")
    public Car blackCar() {
        return new Car(1L, "BMW", "black");
    }

    /**
     * Бин создается при spring.profiles.active=white из application.properties
     */
    @Bean
    @Profile("white")
    public Car whiteCar() {
        return new Car(1L, "BMW", "white");
    }


}
