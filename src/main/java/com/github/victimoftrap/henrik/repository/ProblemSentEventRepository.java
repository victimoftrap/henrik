package com.github.victimoftrap.henrik.repository;

import com.github.victimoftrap.henrik.model.events.ProblemSentEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("ProblemSentEventRepository")
public interface ProblemSentEventRepository extends JpaRepository<ProblemSentEvent, UUID> {
}
