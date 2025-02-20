package com.mitocode.examenf_sc.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(
    LocalDateTime dateTime,
    String message,
    String Path
    )
{

}
