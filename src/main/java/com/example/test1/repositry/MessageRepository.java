package com.example.test1.repositry;

/**
 * Created by ridha on 11/7/17.
 */
import com.example.test1.dao.Message;
import com.example.test1.dao.TwitterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

@Query(value = "select u from Message u where u.sender=:sender")
    Page<Message> getMsg(@Param("sender") String sender, @Param("pageable") Pageable pageable);
}
