package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Work;
import com.example.demo.repository.WorkRepository;

@Service
public class WorkServiceImplement implements WorkService {

	@Autowired
	WorkRepository workRepository; 
	
	@Override
	public List<Work> getAll() {
		return workRepository.findAll();
	}

	@Override
	public Optional<Work> getById(String id) {
		return workRepository.findById(id);
	}

	@Override
	public Work create(Work work) {
		return workRepository.save(work);
	}

	@Override
	public Work update(String id, Work update) {
		Optional<Work> work = workRepository.findById(id);
		if(work != null) {
			return workRepository.save(update);
		} else return null;
	}

	@Override
	public boolean delete(String id) {
		Optional<Work> work = workRepository.findById(id);
		if(work != null) {
			workRepository.deleteById(id);
			return true;
		} else return false;
	}

	@Override
	public Page<Work> getAllByPagingAndSorting(Pageable pageable) {
		return workRepository.findAll(pageable);
	}

}
