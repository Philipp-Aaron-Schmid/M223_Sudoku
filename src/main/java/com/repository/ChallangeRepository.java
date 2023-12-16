package com.repository;

import com.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallangeRepository extends JpaRepository<Challenge, Integer> {
}