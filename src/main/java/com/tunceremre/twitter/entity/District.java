package com.tunceremre.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "district_no", unique = true, nullable = false, length = 2)
    private long districtNo; // İlçe Kodu

    @Column(name = "name", nullable = true, length = 20)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Birçok ilçe bir ile bağlı olur
    @JoinColumn(name = "province_no", referencedColumnName = "province_no")
    private Province province;
}
