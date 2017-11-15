package com.durgadas.springboot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/topics")
@Api(value="Topics")
@CrossOrigin
public class TopicController {
	
	@Autowired
	TopicService topicService;

	@GetMapping
	@ApiOperation(value="View all the registered topics")
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message = "Response succesfull"),
			@ApiResponse(code = 500 , message = "Internal Server error")
		}
	)
	public List<Topic> getAllTopics(@RequestParam (name="name",required=false) String name){
		if (null != name) {
			return topicService.getTopicsByName(name);
		}
		return topicService.getAllTopics();
		
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Search for a topic with ID")
	@ApiResponses(value= {
			@ApiResponse(code= 200 , message = "Response succesfull"),
			@ApiResponse(code = 404 , message = "Topic not found"),
			@ApiResponse(code = 500 , message = "Internal Server error")
		}
	)
	public Topic getTopicById(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create Topic")
	@ApiResponses(value= {
			@ApiResponse(code= 201 , message = "Topic Created"),
			@ApiResponse(code = 500 , message = "Internal Server error")
		}
	)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Update Topic")
	@ApiResponses(value= {
			@ApiResponse(code= 204 , message = "Topic information updated"),
			@ApiResponse(code = 500 , message = "Internal Server error")
		}
	)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete Topic")
	@ApiResponses(value= {
			@ApiResponse(code= 204 , message = "Topic deleted"),
			@ApiResponse(code = 500 , message = "Internal Server error")
		}
	)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
