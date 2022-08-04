package com.beyondsoft.springbootdemo2.pojo;


import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * 表示节点类型
 */
@Data
@Node(labels = "User")
public class UserNode {

    @Id
    @GeneratedValue
    private Long nodeId;

    @Property
    private String userId;

    @Property
    private String name;

    @Property
    private int age;

}
