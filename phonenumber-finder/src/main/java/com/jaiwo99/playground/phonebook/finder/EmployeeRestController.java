package com.jaiwo99.playground.phonebook.finder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liang shi
 * @since 21.10.15
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Employee> queryEmployee(@RequestParam(value = "term", required = false) String term, Pageable pageable) {
        final List<Employee> list = employeeRepository.fullTextSearch(term, pageable);
        log.info("Find {} employees with term: {}", list.size(), term);
        return list;
    }
}
