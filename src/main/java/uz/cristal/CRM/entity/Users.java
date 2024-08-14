package uz.cristal.CRM.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(generator = "UsersIdSeq")
    @SequenceGenerator(name = "UsersIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phoneNumber;
    private String gender;
    private String username;
    private String password;
    private String role;







}
