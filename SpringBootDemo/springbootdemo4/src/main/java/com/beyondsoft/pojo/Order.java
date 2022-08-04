package com.beyondsoft.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    public String id;
    public String no;
    public Date date;
    public int quantity;
}
