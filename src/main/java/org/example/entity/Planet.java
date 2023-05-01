package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Planet implements Serializable {
    @Id
    private String id;
    private String name;

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name;
    }
}
