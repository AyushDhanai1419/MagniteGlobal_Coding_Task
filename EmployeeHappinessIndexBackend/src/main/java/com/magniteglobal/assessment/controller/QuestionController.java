package com.magniteglobal.assessment.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.magniteglobal.assessment.dto.QuestionDto;
import com.magniteglobal.assessment.entity.Question;
import com.magniteglobal.assessment.service.QuestionService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
    private ModelMapper modelMapper;

	@GetMapping("/getAllQuestion")
	public List<QuestionDto> getAllQuestion() {
		
		List<Question> questions = questionService.getAllQuestions();
		return questions.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@PostMapping("/addQuestion")
	public QuestionDto addQuestion(@RequestBody QuestionDto questionDto) {
		Question question = convertToEntity(questionDto);
		return convertToDto(questionService.addQuestion(question));
	}
	
	@DeleteMapping("/delete/{questionId}")
    public void deleteQuestion(@PathVariable Long questionId) {
		questionService.deleteQuestion(questionId);
    }
	
	private QuestionDto convertToDto(Question question) {
	    return modelMapper.map(question, QuestionDto.class);
	}
	
	private Question convertToEntity(QuestionDto questionDto) {
	    return modelMapper.map(questionDto, Question.class);
	}
}
