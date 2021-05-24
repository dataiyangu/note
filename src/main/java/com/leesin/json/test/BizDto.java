package com.leesin.json.test;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BizDto {

    @NotNull(message = "bizType can not be null")
    private Integer bizType;

    private String bizObjJson;
}