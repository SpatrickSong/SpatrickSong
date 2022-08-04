package com.beyondsoft.springbootdemo2.pojo;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

@Data
//@RelationshipProperties(type = "UserRelation")
public class UserRelation {
    @Id
    @GeneratedValue
    private Long id;

    @Relationship
    private UserNode startNode;

    @Relationship
    private UserNode endNode;
}
