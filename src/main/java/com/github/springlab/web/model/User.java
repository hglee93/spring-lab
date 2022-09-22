package com.github.springlab.web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Document(collection = "users")
@NoArgsConstructor
public class User {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;

    private int age;

}
