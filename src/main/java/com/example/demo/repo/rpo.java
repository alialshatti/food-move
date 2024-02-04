package com.example.demo.repo;

import com.example.demo.entity.DoraSample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface rpo extends JpaRepository<DoraSample,Long> {
}
