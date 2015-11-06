package com.jaiwo99.playground.phonebook.finder.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liang shi
 * @since 02.11.15
 */
@RefreshScope
@Controller
public class PhoneNumberFinderUIController {

    @Autowired
    CustomProperties customProperties;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findEmployeesByTerm() {
        return "index";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseBody
    public String greeting() {
        return "Greetings from: " + customProperties.getGreeting();
    }
}
