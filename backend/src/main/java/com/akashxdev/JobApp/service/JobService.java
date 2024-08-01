package com.akashxdev.JobApp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akashxdev.JobApp.model.JobPost;
import com.akashxdev.JobApp.repo.JobRepo;

@Service
public class JobService {
	@Autowired
	private JobRepo repo;
	
	public void addJob(JobPost job) {
		repo.save(job);
	}
	
	public JobPost getJob(int postId) {
		return repo.findById(postId).orElse(null);
	}
	
	public List<JobPost> getAllJobs(){
//		int a =10/0;
		return repo.findAll();
	}
	
	public void updateJob(JobPost job) {
		repo.save(job);
	}
	
	public void deleteJob(int jobId) {
		repo.deleteById(jobId);
	}

	public void load() {
		repo.save(new JobPost(1, "Java Developer", "good knowledge of java", 2, Arrays.asList("Java", "core java", "spring")));
		repo.save(new JobPost(2, "MERN Developer", "good knowledge of MERN", 2, Arrays.asList("REACT", "MERN", "NODE JS")));
		repo.save(new JobPost(3, "AI Developer", "good knowledge of AI", 2, Arrays.asList("AI", "LLM")));
		repo.save(new JobPost(4, "JS Developer", "good knowledge of JS", 2, Arrays.asList("JS", "TS", "TSX")));
	}

	public List<JobPost> jobsHavingKeyword(String keyword) {
		return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
	}

	
}
