package com.unionsystems.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication(exclude = SecurityAutoConfiguration.class,
        scanBasePackages = {"com.unionsystems"})
@EnableJpaRepositories(basePackages = {"com.unionsystems"})
@EntityScan(basePackages = {"com.unionsystems"})
@EnableJpaAuditing
public class AppStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        logger.info(" >>>>>>>>>>>>>>>>>>>> Starting HR App <<<<<<<<<<<<<<<<<<");
        return application.sources(AppStarter.class);
    }

}
