package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Work;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface WorkRepository extends JpaRepository<Work, String> {

}
