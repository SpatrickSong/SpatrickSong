package com.beyondsoft.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@Document(indexName = "user")
public class User {

    @Id
    private Long id;
    private  String first_name;
    private  String last_name;
    private int age;
    private String about;
    private List<String> interests;
}
