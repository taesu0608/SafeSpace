package com.example.demo.dto;

import com.example.demo.repository.TestRepository;
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
}