package com.example.baseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.baseproject.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {}

