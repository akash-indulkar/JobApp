package com.akashxdev.JobApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akashxdev.JobApp.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>{
	
	public List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
	
	
//	private List<JobPost> jobs = new ArrayList<JobPost>(Arrays.asList(
//			new JobPost(1, "Java Developer", "good knowledge of java", 2, Arrays.asList("Java", "core java", "spring")),
//			new JobPost(2, "MERN Developer", "good knowledge of MERN", 2, Arrays.asList("REACT", "MERN", "NODE JS")),
//			new JobPost(3, "AI Developer", "good knowledge of AI", 2, Arrays.asList("AI", "LLM")),
//			new JobPost(4, "JS Developer", "good knowledge of JS", 2, Arrays.asList("JS", "TS", "TSX"))
//			));
//	
//	public void add(JobPost job) {
//		jobs.add(job);
//		
//	}
//
//	public JobPost get(int postId) {
//		for(JobPost job : jobs) {
//			if(job.getPostId() == postId) {
//				return job;
//			}
//		}
//		return null;
//	}
//
//	public List<JobPost> findAll() {
//		return jobs;
//	}
//
//	public void update(JobPost jobToBeUpdated) {
//		for(JobPost job: jobs) {
//			if(job.getPostId()== jobToBeUpdated.getPostId()) {
//				job.setPostProfile(jobToBeUpdated.getPostProfile());
//				job.setPostDesc(jobToBeUpdated.getPostDesc());
//				job.setReqExp(jobToBeUpdated.getReqExp());
//				job.setTechStack(jobToBeUpdated.getTechStack());
//			}
//		}
//	}
//
//	public void delete(int jobId) {
//		for(JobPost job : jobs) {
//			if(job.getPostId()== jobId ){
//				jobs.remove(job);
//			}
//		}
//	}
//	

}
