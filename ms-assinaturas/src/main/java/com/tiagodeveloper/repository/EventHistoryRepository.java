package com.tiagodeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagodeveloper.domain.EventHistory;

public interface EventHistoryRepository extends JpaRepository<EventHistory, Integer> {

}
