package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;


@Data
public class TestDto {
    private Integer id;
    @NotNull
    private String userId;
    @NotNull
    private String testStr;

    @Builder
    public TestDto(String userId,String testStr) {
        this.userId = userId;
        this.testStr = testStr;
    }
}