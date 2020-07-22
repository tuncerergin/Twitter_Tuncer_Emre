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
public class Province implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "province_no", unique = true, nullable = false, length = 2)
    private long provinceNo; // Plaka

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)// Birçok şehir bir ülkeye bağlı olur.
    //Cascade type will fix
    @JoinColumn(name = "country_code", referencedColumnName = "country_code")
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
// Bir şehre ait birçok kasaba olabilir. (Uni-directional)
    @JoinColumn(name = "province_no", referencedColumnName = "province_no")
    private List<District> district;
}
