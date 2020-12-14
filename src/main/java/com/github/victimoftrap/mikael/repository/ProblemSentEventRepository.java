package com.github.victimoftrap.mikael.repository;

import com.github.victimoftrap.mikael.model.events.ProblemSentEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("ProblemSentEventRepository")
public interface ProblemSentEventRepository extends JpaRepository<ProblemSentEvent, UUID> {
}
