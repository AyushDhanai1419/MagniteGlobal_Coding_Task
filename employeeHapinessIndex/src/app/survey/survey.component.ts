import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators  } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.scss']
})
export class SurveyComponent implements OnInit{
  surveyForm!: FormGroup;
  formData : any;
  happinessIndex  = 0;
  submitclicked = false;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router, private route: ActivatedRoute) {
   }

  ngOnInit(): void {

    this.formData = '"questionId" : "", "description" : "" , '

    this.getAllQuestion().subscribe(res => {
      this.formData = res;
      console.log(res);
    },
    
    error =>{console.log(error.message);});

    this.surveyForm = this.fb.group({
      mood: ['', Validators.required],
      helpful: ['', Validators.required],
      attitude: ['', Validators.required],
      positivity: ['', Validators.required],
      workout: ['', Validators.required],
    });
  }

  onSubmit() {
    const surveyData = this.surveyForm.value;
    
    this.happinessIndex = ((this.surveyForm.value.mood * 0.3) + (this.surveyForm.value.helpful * 0.2) + (this.surveyForm.value.workout * 0.2) + (this.surveyForm.value.attitude * 0.1) + (this.surveyForm.value.positivity * 0.2))*100/10;
    if(this.surveyForm.value.mood>0) {
      this.submitclicked = true;
    }
    
    console.log(surveyData);
    const queryParams = {
      mood: this.surveyForm.value.mood,
      helpful: this.surveyForm.value.helpful,
      workout: this.surveyForm.value.workout,
      attitude: this.surveyForm.value.attitude,
      positivity: this.surveyForm.value.positivity
    };
  }

  onClose() {
    this.submitclicked = false;
  }

  getAllQuestion(): Observable<any> {
    return this.http.get("http://localhost:8080/question/getAllQuestion");
  }
}
