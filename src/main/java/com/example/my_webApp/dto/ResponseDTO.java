package com.example.my_webApp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDTO {
    private int status;
    private Object data;

    private String message;

    private LocalDateTime timestamp;

}
