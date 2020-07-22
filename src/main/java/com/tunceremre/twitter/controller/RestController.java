package com.tunceremre.twitter.controller;

import com.tunceremre.twitter.Repository.*;
import com.tunceremre.twitter.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Random;

@Controller
@AllArgsConstructor
public class RestController {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final CountryRepository countryRepository;
    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;
    private final FollowerRepository followerRepository;


    @PostConstruct
    public void setData() {

        Users s_users = new Users();
        s_users.setName("Tuncer");
        s_users.setSurname("Ergin");
        s_users.setEPosta("eposta");
        s_users.setPassword("pass");
        s_users.setProfileImageUrl("image Url");
        s_users.setBirthDate(new Date());

        Users r_users = new Users();
        r_users.setName("Emre");
        r_users.setSurname("Çatamak");
        r_users.setEPosta("eposta");
        r_users.setPassword("pass");
        r_users.setProfileImageUrl("image Url");
        r_users.setBirthDate(new Date());

        Country country = new Country();
        country.setName("Country");
        Random rnd = new Random();

        long id = rnd.nextInt(1000);

        country.setCountryCode(id);

        Province province = new Province();
        province.setName("Province");
        province.setProvinceNo(id);
        province.setCountry(country);

        District district = new District();
        district.setName("District");
        district.setProvince(province);
        district.setDistrictNo(id);

        Adress address = new Adress();
        address.setAdress("Adres");
        address.setDistrict(district);


        s_users.setAdress(address);
        r_users.setAdress(address);

        Messages messages = new Messages();
        messages.setDate(new Date());
        messages.setDetail("Mesaj içeriği");

        messages.setReceiver(r_users);
        messages.setSender(s_users);

        messageRepository.save(messages);


        // r_users.setFollowing(s_users);


        Followers followers = new Followers();


        System.out.println("Post Construct -> İşlem tamamlandı.");

  /*      Optional<Users> user = userRepository.findById((long) 1);
        Optional<Users> user2 = userRepository.findById((long) 2);

        followers.setFollowed(user.get());
        followers.setFollowing(user2.get());

        followerRepository.save(followers);

        user.get().setAdress(address);

        // user.setFollowing(user2.get());

        //  Optional<Country> countryy = countryRepository.findById((long) 1);
        // Page<Followers> follow = followerRepository.findByFollowed(user.get(), Pageable.unpaged());


        System.out.println(user.get().getAdress().getAdress() + " - "
                        + user.get().getAdress().getUser().getName() + " - "
                        + user.get().getAdress().getDistrict().getName() + " - "
                        + user.get().getAdress().getDistrict().getProvince().getName() + " - "
                        + user.get().getAdress().getDistrict().getProvince().getCountry().getName() + " - "
                //   + user.get().getAdress().getDistrict().getProvince().getCountry().getProvince().get(0).getName()+ " - "
                //  + user.get().getAdress().getDistrict().getProvince().getCountry().getProvince().get(0).getDistrict().get(0).getName()

        );

        System.out.println(countryy.get().getName());
        System.out.println("Follow: "+follow.getContent().get(0).getFollowing().getName());
*/
    }

}
