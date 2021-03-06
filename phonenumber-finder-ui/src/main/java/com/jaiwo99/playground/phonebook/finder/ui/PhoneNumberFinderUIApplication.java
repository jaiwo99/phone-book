package com.jaiwo99.playground.phonebook.finder.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author liang shi
 * @since 22.10.15
 */
@SpringCloudApplication
@EnableFeignClients
public class PhoneNumberFinderUIApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneNumberFinderUIApplication.class, args);
    }
}
