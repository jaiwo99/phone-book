package com.jaiwo99.playground.phonebook.finder;

import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author liang shi
 * @since 21.10.15
 */
public interface EmployeeRepositoryCustom {

    List<Employee> fullTextSearch(String term, Pageable pageable);
}
