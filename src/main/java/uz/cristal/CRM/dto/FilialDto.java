package uz.cristal.CRM.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilialDto {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String location;
    @NotNull
    @Positive
    private Integer capacity;
    @NotNull
    @Positive
    private Integer students;
    private List<CourseDto> courses;
    @NotBlank
    private String phoneNumber;
}
