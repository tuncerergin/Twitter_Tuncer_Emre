package com.tunceremre.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "surname", nullable = false, length = 20)
    private String surname;

    @Column(name = "e_posta", nullable = false, length = 20)
    private String ePosta;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "profile_image_url", length = 50)
    private String profileImageUrl;

    @Column(name = "date_of_birth", length = 10)
    private Date birthDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Bir kulalnıcının sadece 1 tane adresi olur.
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    /* @Joincolumn daki name değişkeni şuan içindeki tablonun referans verilecek stun adını belirtir.
     *  referencedColumnName değişkenindeki değer diğer tablodaki referans alınan stunun ismini belirtir
     * */
    private Adress adress;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "following_users", referencedColumnName = "id")
    private List<Followers> following;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "followed_user", referencedColumnName = "id")
    private List<Followers> followed;


}
