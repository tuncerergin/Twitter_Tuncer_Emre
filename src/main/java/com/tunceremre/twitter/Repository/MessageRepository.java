package com.tunceremre.twitter.Repository;

import com.tunceremre.twitter.entity.Messages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface MessageRepository extends JpaRepository<Messages, Long> {
    Page<Messages> findById(@RequestParam("id") long id, Pageable pageable);

    Page<Messages> findBySender_Id(@RequestParam("id") long id, Pageable pageable);

    Page<Messages> findByReceiver_Id(@RequestParam("id") long id, Pageable pagepageable);

}
