package lk.ijse.bikereservation.entity;

import lombok.*;

import javax.persistence.*;

/**
 * entity class for user role
 * @author Chalodya
 * @since 2019/09
 **/
@Entity
@Table(name = "auth_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_role_id")
    private int roleId;
    @Column(name = "role_name")
    private String role;
    @Column(name = "role_desc")
    private String description;
}
