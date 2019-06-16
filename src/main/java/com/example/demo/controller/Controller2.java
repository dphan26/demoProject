package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Work;
import com.example.demo.service.WorkService;

@RestController
@RequestMapping("/api/v1")
public class Controller2 {
	
	@Autowired
	WorkService workservice;
	
	//about
	@GetMapping("")
	public  String about() {
		return "welcom.html";
	}
	//Get all
	@RequestMapping(value = "/works", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Work>> getWorks() throws Exception {
		return new ResponseEntity<>(workservice.getAll(), HttpStatus.OK);
	}
	
	//Get by id 
	@RequestMapping(value = "/works/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Work>> getWorkById(@PathVariable("id") String id) throws Exception {
		return new ResponseEntity<>(workservice.getById(id), HttpStatus.OK);
	}
	
	//Add
	@RequestMapping(value = "/works/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Work> createWork(@RequestBody Work work) throws Exception {
		return new ResponseEntity<>(workservice.create(work), HttpStatus.OK);
	}
	//Edit
	@RequestMapping(value = "/works/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Work> updateWorkById(@PathVariable("id") String id, @RequestBody Work work) throws Exception {
		return new ResponseEntity<>(workservice.update(id, work), HttpStatus.OK);
	}
	//Delete
	@RequestMapping(value = "/works/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteWorkById(@PathVariable("id") String id) throws Exception {
		return new ResponseEntity<>(workservice.delete(id), HttpStatus.NO_CONTENT);
	}
	//Fetch Works with Paging and Sorting
	@RequestMapping(value = "/works/pagingAndSorting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Work>> getWorksByPagingAndSorting(Pageable pageable) throws Exception {
		return new ResponseEntity<>(workservice.getAllByPagingAndSorting(pageable), HttpStatus.OK);
	}
}
