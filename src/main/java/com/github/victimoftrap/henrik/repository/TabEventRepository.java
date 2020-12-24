package com.github.victimoftrap.henrik.repository;

import com.github.victimoftrap.henrik.model.events.TabEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("TabEventRepository")
public interface TabEventRepository extends JpaRepository<TabEvent, UUID> {
}
