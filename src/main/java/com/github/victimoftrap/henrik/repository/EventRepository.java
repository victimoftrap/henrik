package com.github.victimoftrap.henrik.repository;

import com.github.victimoftrap.henrik.model.EventDescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("eventRepository")
public interface EventRepository extends JpaRepository<EventDescription, UUID> {
}
