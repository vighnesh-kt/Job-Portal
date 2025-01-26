package com.jobportal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.JobPost;
import com.jobportal.repository.JobRepository;

@Service
public class JobDao {
	
	@Autowired
	private JobRepository jobRepository;

	public List<JobPost> findAll() {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
	}

	public JobPost save(JobPost jobPost) {
		// TODO Auto-generated method stub
		return jobRepository.save(jobPost);
	}

	public JobPost findById(int postId) {
		// TODO Auto-generated method stub
		return jobRepository.findById(postId).orElse(null);
	}

	public void deleteById(int postId) {
		// TODO Auto-generated method stub
		jobRepository.deleteById(postId);
	}

	public void saveAll(List<JobPost> jobs) {
		// TODO Auto-generated method stub
		jobRepository.saveAll(jobs);
	}

	public List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword, String keyword2) {
		// TODO Auto-generated method stub
		return jobRepository.findByPostProfileContainingOrPostDescContaining(keyword, keyword2);
	}
	

}
