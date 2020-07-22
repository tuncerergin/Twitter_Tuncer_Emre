package com.tunceremre.twitter.Repository;

import com.tunceremre.twitter.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findById(@RequestParam("id") Long id);  //http://localhost:8080/toDoLists/search/findById/?id=2

}
