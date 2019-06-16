package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Work;

public interface WorkService {
	public List<Work> getAll();
	public Optional<Work> getById(String id);
	public Work create(Work work);
	public Work update(String id, Work work);
	public boolean delete(String id);
	public Page<Work> getAllByPagingAndSorting(Pageable pageable);
}
