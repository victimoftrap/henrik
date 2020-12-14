package com.github.victimoftrap.mikael.repository;

import com.github.victimoftrap.mikael.model.events.EventDescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("MainEventRepository")
public interface MainEventRepository extends JpaRepository<EventDescription, UUID> {
}
