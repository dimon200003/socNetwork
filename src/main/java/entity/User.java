package entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;


    @Column(name = "age")
    private int age;


    @Setter
    @Getter
    @Column(name = "phone_number")
    private int phoneNumber;


    @Column(name = "adress")
    private String address;


    @Column(name = "user_name")
    private String name;


    @Column(name = "user_password")
    private String password;


}
