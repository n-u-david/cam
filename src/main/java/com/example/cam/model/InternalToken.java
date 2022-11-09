package com.example.cam.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class InternalToken implements Serializable {
    String header;
    String body;
    String signature;

}
