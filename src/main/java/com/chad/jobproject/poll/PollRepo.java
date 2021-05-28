package com.chad.jobproject.poll;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PollRepo extends JpaRepository<Poll, Long> {
    List<Poll> findAll();
}
