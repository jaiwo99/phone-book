package com.jaiwo99.playground.phonebook.finder.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/api/employees/", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeDTO>> findEmployeesByTerm(@RequestParam(required = false) String term) {
        return ResponseEntity.ok(client.findEmployeesByTerm(term));
    }
}
