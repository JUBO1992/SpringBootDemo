package com.jubo.springbootes.dto;

import lombok.Data;

/**
 * @author JUBO
 */
@Data
public class ResultDto<T> {
    private boolean success;
    private int httpCode;
    private String message;
    private String Tag;
    private T data;
}
