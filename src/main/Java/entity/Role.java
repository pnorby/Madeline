package entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a role.
 *
 * @author pnorby
 */

@Entity(name = "Role")
@Table(name = "role")
public class Role {
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "user_id",
        foreignKey = @ForeignKey(name = "role_user_id_fk"))
    private int userId;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

}
