package com.magniteglobal.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magniteglobal.assessment.entity.Question;


public interface QuestionRepository extends JpaRepository<Question, Long> {

}