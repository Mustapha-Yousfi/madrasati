package com.madrasati.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassroomResponse {
    private Long id;
    private String name;
    private String level;
    private Long schoolId;
}
