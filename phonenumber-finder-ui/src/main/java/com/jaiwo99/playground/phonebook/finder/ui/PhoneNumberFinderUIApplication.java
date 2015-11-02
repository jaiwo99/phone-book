package com.jaiwo99.playground.phonebook.finder.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liang shi
 * @since 22.10.15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PhoneNumberFinderUIApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneNumberFinderUIApplication.class, args);
    }
}
