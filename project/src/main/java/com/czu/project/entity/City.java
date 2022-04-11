package com.czu.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "area_code")
    private int areaCode;

    @Column(name = "country")
    private String country;

    @Column(name = "lang")
    private String lang;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Library> libraries = new ArrayList<>();
}
