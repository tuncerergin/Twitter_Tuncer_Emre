package com.tunceremre.twitter.Repository;

import com.tunceremre.twitter.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Page<Country> findById(@RequestParam("id") Long id, Pageable pageable);  //http://localhost:8080/toDoLists/search/findById/?id=2

}
