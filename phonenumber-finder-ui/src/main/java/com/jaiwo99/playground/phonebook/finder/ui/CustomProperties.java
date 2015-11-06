package com.jaiwo99.playground.phonebook.finder.ui;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liang shi
 * @since 06.11.15
 */
@Data
@Component
@ConfigurationProperties("phonebook.custom")
public class CustomProperties {
    private String greeting = "UNDEFINED";
}
