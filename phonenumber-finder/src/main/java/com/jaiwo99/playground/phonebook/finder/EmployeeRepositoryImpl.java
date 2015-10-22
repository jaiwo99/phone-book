package com.jaiwo99.playground.phonebook.finder;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * @author liang shi
 * @since 21.10.15
 */
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<Employee> fullTextSearch(String term, Pageable pageable) {
        final QueryBuilder queryBuilder;
        final String wildcardTerm = toWildcardQuery(term);

        if( StringUtils.isNotBlank(term) ) {
            queryBuilder = boolQuery()
                    .should(wildcardQuery("Abteilung", wildcardTerm))
                    .should(wildcardQuery("Nachname", wildcardTerm))
                    .should(wildcardQuery("Raum", wildcardTerm))
                    .should(wildcardQuery("Stelle", wildcardTerm))
                    .should(wildcardQuery("Telefon", wildcardTerm));
        } else {
            queryBuilder = matchAllQuery();
        }

        final SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(pageable)
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, Employee.class);
    }

    // Wildcard query is not analyzed, so it has to be lowercase or query_string is needed.
    private static String toWildcardQuery(String term) {
        return String.format("*%s*", term).toLowerCase();
    }
}
