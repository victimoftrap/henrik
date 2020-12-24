package com.github.victimoftrap.henrik.repository;

import com.github.victimoftrap.henrik.model.events.EventDescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("MainEventRepository")
public interface MainEventRepository extends JpaRepository<EventDescription, UUID> {
}
