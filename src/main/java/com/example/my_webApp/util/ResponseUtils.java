package com.example.my_webApp.util;

import com.example.my_webApp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseUtils {

    public static <T> ResponseDTO<T> handleOkResponse(ResponseDTO<T> responseDTO, String message){
        responseDTO.setData(null);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.OK.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }
    public static <T> ResponseDTO<T> handleConflictResponse(ResponseDTO<T> responseDTO, String message){
        responseDTO.setData(null);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.CONFLICT.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }

    public static ResponseDTO handleErrorResponse(ResponseDTO responseDTO, String message) {
        responseDTO.setData(null);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }
}
