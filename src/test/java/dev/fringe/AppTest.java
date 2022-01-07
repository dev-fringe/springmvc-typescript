package dev.fringe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.fringe.config.DataSourceConfig;
import dev.fringe.config.HibernateConfig;
import dev.fringe.config.MapperConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DataSourceConfig.class, HibernateConfig.class, MapperConfig.class})
//@WebAppConfiguration
public class AppTest {

	@Test public void test() {
		System.out.println("Test");
	}
}
