package com.tunceremre.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long Id;

    @Column(name = "country_code", unique = true, nullable = false, length = 5)
    private long countryCode;// Ülke Kodu (Türkiye:90 gibi)

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)// Bir ülkenin birçok şehri olabilir.
    @JoinColumn(name = "country_code", referencedColumnName = "country_code")
    private List<Province> province;
}
