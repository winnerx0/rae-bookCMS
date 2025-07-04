package com.winnerezy.simon.repositories;

import com.winnerezy.simon.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {

    List<Message> findBySessionIdOrderByCreatedAtAsc(String sessionId);
}
