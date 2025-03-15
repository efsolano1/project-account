package ec.com.efsr.config;

import ec.com.efsr.repository.MovementRepositoryPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "ec.com.efsr",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Interactor$"),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MovementRepositoryPort.class})
        })
public class UseCaseConfig {
}
