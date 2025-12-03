package com.madrasati.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTeacherRequest {
    private String firstName;
    private String lastName;
    private Long classroomId;
}
