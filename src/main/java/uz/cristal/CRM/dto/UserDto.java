package uz.cristal.CRM.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String birthDate;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String gender;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String role;

}
