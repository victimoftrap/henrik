package com.github.victimoftrap.mikael.repository;

import com.github.victimoftrap.mikael.model.events.ProblemChangedEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("ProblemChangedEvent")
public interface ProblemChangedEventRepository extends JpaRepository<ProblemChangedEvent, UUID> {
}
