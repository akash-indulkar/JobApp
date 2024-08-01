package com.akashxdev.JobApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akashxdev.JobApp.model.JobPost;
import com.akashxdev.JobApp.service.JobService;

@RestController
public class JobController {
	@Autowired
	private JobService service;
	
	@PostMapping("/job")
	public JobPost addJob(@RequestBody JobPost job) {
		service.addJob(job);
		return service.getJob(job.getPostId());
	}
	
	@GetMapping({"/jobs"})
	public List<JobPost> getAllJobs(){
		return service.getAllJobs();
	}
	
	@GetMapping("/job/{postId}") //"/job/{postId}"
	public JobPost getJob(@PathVariable int postId){
		return service.getJob(postId);
	}
	
	@PutMapping("/job")
	public JobPost updateJob(@RequestBody JobPost job) {
		service.updateJob(job);
		return service.getJob(job.getPostId());
	}
	
	@DeleteMapping("/job/{postId}")
	public JobPost deleteJob(@PathVariable int postId) {
		service.deleteJob(postId);
		return service.getJob(postId);
	}
	
	@GetMapping("/load")
	public void load(){
		service.load();
	}
	
	@GetMapping("/jobs/keyword/{keyword}")
	public List<JobPost> jobsHavingKeyword(@PathVariable String keyword){
		return service.jobsHavingKeyword(keyword);
	}
	
}
