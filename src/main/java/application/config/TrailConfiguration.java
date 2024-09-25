package application.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "application.repository.dao")
@EntityScan(basePackages = "application.repository.entity")
@ComponentScan(basePackages = {"application"})
public class TrailConfiguration {
}
