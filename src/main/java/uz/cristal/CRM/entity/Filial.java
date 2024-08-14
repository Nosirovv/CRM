package uz.cristal.CRM.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Filial {

    @Id
    @GeneratedValue(generator = "FilialIdSeq")
    @SequenceGenerator(name = "FilialIdSeq", sequenceName = "filial_id_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private String location;
    private Integer capacity;
    private Integer students;
    @ManyToMany
    private List<Course> courses;
    private String phoneNumber;
}
