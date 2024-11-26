package com.prosoft.spring_boot_profile;

import com.prosoft.spring_boot_profile.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.EnabledIf;

/**
 * Тестовый класс запускается только при значении spring.profiles.active=black из application.properties
 * (если в тестах есть свой application.properties, то значение spring.profiles.active берется из него)
 */
@SpringBootTest(classes = SpringBootProfileApplication.class)
@EnabledIf(value = "#{environment.getActiveProfiles()[0] == 'black'}", loadContext = true)
class RunOnlyBlackCarTest {

	private static final String EXPECTED_COLOR = "black";

	@Value("${profile.property.value}")
	private String propertyValue;

	@Autowired
	private Car car;

	@Test
	@DisplayName("Тест черной машины")
	void blackColorTest() {
		System.out.println("RunOnlyBlackCarTest " + propertyValue);
		Assertions.assertEquals(EXPECTED_COLOR, car.getColor());
	}

}
