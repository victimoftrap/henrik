package com.github.victimoftrap.henrik.repository;

import com.github.victimoftrap.henrik.model.events.MouseLeaveEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("MouseLeaveEventRepository")
public interface MouseLeaveEventRepository extends JpaRepository<MouseLeaveEvent, UUID> {
}
