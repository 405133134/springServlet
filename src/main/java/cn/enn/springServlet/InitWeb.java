package cn.enn.springServlet;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class InitWeb implements ApplicationContextInitializer{

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("applicationContextInitializer");
	}

}
