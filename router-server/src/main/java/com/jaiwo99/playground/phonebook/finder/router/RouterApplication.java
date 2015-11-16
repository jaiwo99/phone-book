package com.jaiwo99.playground.phonebook.finder.router;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author liang shi
 * @since 16.11.15
 */
@SpringCloudApplication
@EnableZuulProxy
public class RouterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouterApplication.class, args);
    }
}
