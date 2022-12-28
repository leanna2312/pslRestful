package com.example.pslrestful.dto;

import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
public class SuccessDto {

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private Boolean success;



}
