package com.jaiwo99.playground.phonebook.finder;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author liang shi
 * @since 21.10.15
 */
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String>, EmployeeRepositoryCustom {
}
