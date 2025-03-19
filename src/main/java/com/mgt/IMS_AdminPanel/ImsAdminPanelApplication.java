package com.mgt.IMS_AdminPanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.mgt")
@EnableJpaRepositories("com.mgt.dao")
@EntityScan("com.mgt.model")
public class ImsAdminPanelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsAdminPanelApplication.class, args);
	}

}
