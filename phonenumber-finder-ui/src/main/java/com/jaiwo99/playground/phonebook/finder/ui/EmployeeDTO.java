package com.jaiwo99.playground.phonebook.finder.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author liang shi
 * @since 21.10.15
 */
@Data
public class EmployeeDTO {

    @JsonProperty("id")
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
