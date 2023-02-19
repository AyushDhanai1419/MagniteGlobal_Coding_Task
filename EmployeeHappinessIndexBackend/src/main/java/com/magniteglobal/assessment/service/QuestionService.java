package com.magniteglobal.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magniteglobal.assessment.entity.Question;
import com.magniteglobal.assessment.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}
	
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
    }
	
	public void deleteQuestion(Long questionId) {
		questionRepository.deleteById(questionId);
    }


}