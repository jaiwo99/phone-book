package com.jaiwo99.playground.phonebook.finder.ui;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author liang shi
 * @since 02.11.15
 */
@FeignClient("phonenumber-finder")
public interface PhoneNumberFinderClient {

    @RequestMapping(value = "/api/employees/", method = RequestMethod.GET)
    List<EmployeeDTO> findEmployeesByTerm(@RequestParam(value = "term", required = false) String term);
}
