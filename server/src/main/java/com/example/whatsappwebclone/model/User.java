package com.example.whatsappwebclone.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String full_name;
    private String email;
    private String profile_picture;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications= new ArrayList<>();

    @Override
    public int hashCode() {
        return Objects.hash(email, full_name, id, password, profile_picture);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(email, other.email) && Objects.equals(full_name, other.full_name)
                && Objects.equals(id, other.id) && Objects.equals(password, other.password)
                && Objects.equals(profile_picture, other.profile_picture);
    }
}
