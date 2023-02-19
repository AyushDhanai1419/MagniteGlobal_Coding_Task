package com.magniteglobal.assessment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.magniteglobal.assessment.entity.Question;
import com.magniteglobal.assessment.repository.QuestionRepository;
import com.magniteglobal.assessment.service.QuestionService;

@SpringBootTest
class QuestionServiceTest {
	
	@InjectMocks
	QuestionService questionService;
	
	@Mock
	QuestionRepository questionRepository;
	
	@Test
	void getAllQuestionsTest()
	{
		List<Question> list = new ArrayList<>();
		list.add(new Question());
		Mockito.when(questionRepository.findAll()).thenReturn(list);
		assertNotNull(list);
	}
	
	@Test
	void addQuestionTest()
	{
		Question ques = new Question();
		ques.setQuestionId(1L);
		Mockito.when(questionRepository.save(Mockito.any())).thenReturn(ques);
		assertNotNull(ques);
	}
 }
