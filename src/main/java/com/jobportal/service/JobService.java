package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dao.JobDao;
import com.jobportal.entity.JobPost;
import com.jobportal.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	public JobDao jobDao;

	// method to return all JobPosts
	public List<JobPost> getAllJobs() {
		return jobDao.findAll();

	}

	// method to add a jobPost
	public JobPost addJob(JobPost jobPost) {
		return jobDao.save(jobPost);

	}

//method to get job by id
	public JobPost getJob(int postId) {

		return jobDao.findById(postId);
	}

//method to update job with job post object
	public void updateJob(JobPost jobPost) {
		jobDao.save(jobPost);

	}

//method to delete job post by id 
	public void deleteJob(int postId) {
		jobDao.deleteById(postId);

	}

	public void load() {
		// arrayList to store store JobPost objects
		List<JobPost> jobs = new ArrayList<>(List.of(
				new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3,
						List.of("Java", "Spring", "SQL", "API")),
				new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5,
						List.of("Python", "Machine Learning", "TensorFlow", "API")),
				new JobPost(3, "Frontend Developer",
						"Create API amazing user interfaces with our talented frontend team.", 2,
						List.of("JavaScript", "React", "CSS", "API")),
				new JobPost(4, "Network Engineer", "Design and API maintain our robust network infrastructure.", 4,
						List.of("Cisco", "Routing", "Firewalls")),
				new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3,
						List.of("UI/UX Design", "Adobe XD", "Prototyping"))

		));

		jobDao.saveAll(jobs);

	}

	public List<JobPost> search(String keyword) {

		return jobDao.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
	}

}