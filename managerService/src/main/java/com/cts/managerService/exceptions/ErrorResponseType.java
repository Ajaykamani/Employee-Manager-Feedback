package com.cts.managerService.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponseType implements Serializable {

    private static final long serialVersionUID = 1335215743922166108L;

    @JsonProperty("successResponse")
    private String successResponse;
    
    @JsonProperty("errorMessage")
    private String errMsg;
    
    @JsonProperty("errorDetails")
    private String errDetail;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;
   
    @JsonProperty("status")
    private Integer status;
}
