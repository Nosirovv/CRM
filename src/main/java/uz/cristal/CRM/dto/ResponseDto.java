package uz.cristal.CRM.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto<T> {

    private String message;
    private boolean success;
    private T data;
}
