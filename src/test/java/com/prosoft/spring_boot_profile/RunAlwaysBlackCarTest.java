package com.prosoft.spring_boot_profile;

import com.prosoft.spring_boot_profile.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Этот тест будет запускаться всегда и для него будет всегда активироваться профиль "white" вне зависимости от того,
 * что установлено в application.properties в значении spring.profiles.active.
 * Для этого класса контекст всегда будет поднят "black"
 */
@ActiveProfiles("black")
@SpringBootTest
class RunAlwaysBlackCarTest {

    private static final String EXPECTED_COLOR = "black";

    @Value("${profile.property.value}")
    private String propertyValue;

    @Autowired
    private Car car;

    @Test
    @DisplayName("Тест черной машины")
    void whiteCarColorTest() {
        System.out.println("RunAlwaysBlackCarTest: " + propertyValue + " " + car.getColor());
        Assertions.assertEquals(EXPECTED_COLOR, car.getColor());
    }

}