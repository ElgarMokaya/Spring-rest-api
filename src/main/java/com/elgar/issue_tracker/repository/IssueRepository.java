package com.elgar.issue_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elgar.issue_tracker.models.Issue;

public interface IssueRepository extends JpaRepository<Issue,Long>{

}
