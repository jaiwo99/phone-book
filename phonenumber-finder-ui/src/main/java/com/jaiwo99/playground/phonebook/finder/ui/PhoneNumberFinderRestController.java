package com.jaiwo99.playground.phonebook.finder.ui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author liang shi
 * @since 02.11.15
 */
@RestController
public class PhoneNumberFinderRestController {

    private final PhoneNumberFinderClient client;

    @Autowired
    public PhoneNumberFinderRestController(PhoneNumberFinderClient client) {
        this.client = client;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "/api/employees/", method = RequestMethod.GET)
    public List<EmployeeDTO> findEmployeesByTerm(@RequestParam(required = false) String term) {
        return client.findEmployeesByTerm(term);
    }

    private List<EmployeeDTO> fallback(String term) {
        return Arrays.asList(new EmployeeDTO("fallback-id", "fallback-name", "fallback-department", "fallback-room", "fallback-role", "fallback-phone"));
    }
}
