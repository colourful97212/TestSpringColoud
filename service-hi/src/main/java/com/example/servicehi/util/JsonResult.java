package com.example.servicehi.util;

import lombok.Data;

@Data
public class JsonResult<T> {
    private T data;
    private String message;
    private int status;
}
