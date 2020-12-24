package com.github.victimoftrap.henrik.repository;

import com.github.victimoftrap.henrik.model.events.MouseEnterEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("MouseEnterEventRepository")
public interface MouseEnterEventRepository extends JpaRepository<MouseEnterEvent, UUID> {
}
