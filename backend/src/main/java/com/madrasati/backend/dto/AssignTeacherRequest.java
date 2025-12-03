package com.madrasati.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssignTeacherRequest {
    private Long classroomId;
}
