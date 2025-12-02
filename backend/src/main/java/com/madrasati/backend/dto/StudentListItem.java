package com.madrasati.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentListItem {
    private Long id;
    private String firstName;
    private String lastName;
    private Long classroomId;

}
