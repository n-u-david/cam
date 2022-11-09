package com.example.cam.model;

import lombok.*;
import java.io.Serializable;

@Data
public class ExternalToken implements Serializable {
    String header;
    String body;
    String signature;
}
