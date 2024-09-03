package com.cannon.nop.interfaces.event.dto.request;

import com.cannon.nop.interfaces.validator.FutureOrNow;
import com.cannon.nop.interfaces.validator.MaxLength;
import com.cannon.nop.interfaces.validator.NoSpecialCharacters;
import com.cannon.nop.interfaces.validator.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventRequest
{


    @NoSpecialCharacters
    @MaxLength
    @NotBlank
    private String primaryId;
    private List<@NotBlank @NoSpecialCharacters @MaxLength EventQuestionFormRequest> formData;
    @NotBlank
    @MaxLength
//    0이면 안된다는 로직 필요함
    private Integer joinLimit;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @FutureOrNow
    private LocalDateTime startDate;

}