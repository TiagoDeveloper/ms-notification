package com.tiagodeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagodeveloper.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {

}
