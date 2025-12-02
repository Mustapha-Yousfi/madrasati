package com.madrasati.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassroomListItem {
    private Long id;
    private String name;
    private String level;
    private Long schoolId;
}
