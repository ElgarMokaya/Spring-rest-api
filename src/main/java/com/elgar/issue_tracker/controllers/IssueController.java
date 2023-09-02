package com.elgar.issue_tracker.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elgar.issue_tracker.models.Issue;
import com.elgar.issue_tracker.repository.IssueRepository;
@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class IssueController {
	@Autowired
	private IssueRepository issueRepository;
	
	@GetMapping("/all_issues")
	public List<Issue> getAllIssues() {
		return issueRepository.findAll();
		
	}
		
	@PostMapping("/add_isssue")
		public ResponseEntity<Issue> addIssue(@RequestBody Issue issue){
		
	Issue  savedIssue= issueRepository.save(issue);
	return  new ResponseEntity<>(savedIssue,HttpStatus.CREATED);
	}
	
	@PutMapping("/update_issue/{id}")
	public ResponseEntity<Issue> updateIssue(@PathVariable Long id,@RequestBody Issue updatedIssue){
		if(!issueRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		updatedIssue.setId(id);
		
		Issue savedUpdatedIssue=issueRepository.save(updatedIssue);
		return ResponseEntity.ok(savedUpdatedIssue);
		
		
	}
	
	@DeleteMapping("/delete_issue/{id}")
	
	public ResponseEntity<Void>deleteIssue(@PathVariable Long id){
		if(!issueRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		 
		issueRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();		
	}
	
	
	
	
	

}
