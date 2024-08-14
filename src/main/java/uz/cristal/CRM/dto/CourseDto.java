package uz.cristal.CRM.dto;

import jakarta.persistence.ManyToMany;
import lombok.*;
import uz.cristal.CRM.entity.Filial;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private Integer id;
    private String name;
    private List<Filial> branches;
    private String time;
    private String mentor;
    private String startDay;
    private Integer roomNumber;
    private Integer groupNumber;

}
