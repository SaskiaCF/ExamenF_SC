package com.mitocode.examenf_sc.dto;

import java.util.List;

public record GenericResponse<T>(
        int status,
        String message,
        List<T> data
) {
}
