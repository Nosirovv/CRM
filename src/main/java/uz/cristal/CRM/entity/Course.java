package uz.cristal.CRM.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(generator = "CourseIdSeq")
    @SequenceGenerator(name = "CourseIdSeq", sequenceName = "course_id_seq", allocationSize = 1)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Filial> branches;
    private String time;
    private String mentor;
    private String startDay;
    private Integer roomNumber;
    private Integer groupNumber;





}
