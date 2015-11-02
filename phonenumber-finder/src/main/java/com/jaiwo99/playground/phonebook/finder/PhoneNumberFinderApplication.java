package com.jaiwo99.playground.phonebook.finder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

/**
 * @author liang shi
 * @since 21.10.15
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class PhoneNumberFinderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PhoneNumberFinderApplication.class);
    }

    @Value("classpath:employee.json")
    Resource jsonResource;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PhoneNumberFinderApplication.class);
    }

    @Bean
    CommandLineRunner loadEmployees(EmployeeRepository employeeRepository) throws IOException {

        return args -> {
            List<Employee> employeeList = new ObjectMapper().readValue(jsonResource.getFile(), new TypeReference<List<Employee>>() {});
            log.info("SIZE:" + employeeList.size());
            employeeRepository.save(employeeList);
        };
    }
}
