package com.jaiwo99.playground.phonebook.finder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author liang shi
 * @since 21.10.15
 */
@Data
@Document(indexName = "employees", type = "employee", shards = 1, indexStoreType = "memory")
public class Employee {

    @Id
    private String id;
    @JsonProperty("Nachname")
    private String name;
    @JsonProperty("Abteilung")
    private String department;
    @JsonProperty("Raum")
    private String room;
    @JsonProperty("Stelle")
    private String role;
    @JsonProperty("Telefon")
    private String phone;
}
