package com.madrasati.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateSchoolRequest {
    private String name;
    private String description;
    private String address;

}

