package edu.miu.cs544.group1.project.domain;

import edu.miu.cs544.group1.project.domain.enumerated.RoleCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    @Enumerated(EnumType.STRING)
    private RoleCode code;

    public Role(RoleCode code) {
        this.code = code;
    }
}
