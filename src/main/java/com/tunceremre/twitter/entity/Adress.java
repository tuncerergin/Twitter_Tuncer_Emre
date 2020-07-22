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
public class Adress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "adress", nullable = true, length = 20)
    private String adress;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "adress_id")
    private Users user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Bir adres sadece 1 ilçeye bağlı olur.
    @JoinColumn(name = "district_no", referencedColumnName = "district_no")
    private District district;


}
