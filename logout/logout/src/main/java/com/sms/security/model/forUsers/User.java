package com.sms.security.model.forUsers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "surname", "name" })})

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2)
    @Column(name = "surname")
    private String surname;//Фамилия

    @Size(min = 2)
    @Column(name = "name")
    private String name;//Имя

    @Column(name = "middle_name")
    private String middleName;//Отчество - может отсутствовать

    @Column(name = "account_type")
    private String accountType;//Тип аккаунта

    @Column(name = "group_name")
    private String group;//Группа

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String surname, String name, String middleName, String accountType, String group, String email, String password) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.group = group;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
    }
}
