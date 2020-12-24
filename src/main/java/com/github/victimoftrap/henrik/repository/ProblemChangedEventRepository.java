package com.github.victimoftrap.henrik.repository;

import com.github.victimoftrap.henrik.model.events.ProblemChangedEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("ProblemChangedEvent")
public interface ProblemChangedEventRepository extends JpaRepository<ProblemChangedEvent, UUID> {
}
