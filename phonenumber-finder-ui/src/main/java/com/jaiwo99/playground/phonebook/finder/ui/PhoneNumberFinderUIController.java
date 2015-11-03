package com.jaiwo99.playground.phonebook.finder.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liang shi
 * @since 02.11.15
 */
@Controller
public class PhoneNumberFinderUIController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findEmployeesByTerm() {
        return "index";
    }
}
