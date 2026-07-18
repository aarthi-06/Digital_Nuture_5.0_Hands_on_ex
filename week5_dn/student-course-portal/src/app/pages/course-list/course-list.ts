import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  Course,
  CourseCard
} from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = true;

  selectedCourseId: number | null = null;

  courses: Course[] = [
    {
      id: 1,
      name: 'Angular Basics',
      code: 'CS101',
      credits: 3,
      gradeStatus: 'passed'
    },
    {
      id: 2,
      name: 'Database Management',
      code: 'CS102',
      credits: 4,
      gradeStatus: 'pending'
    },
    {
      id: 3,
      name: 'Computer Networks',
      code: 'CS103',
      credits: 3,
      gradeStatus: 'failed'
    },
    {
      id: 4,
      name: 'Operating Systems',
      code: 'CS104',
      credits: 4,
      gradeStatus: 'passed'
    },
    {
      id: 5,
      name: 'Web Development',
      code: 'CS105',
      credits: 3,
      gradeStatus: 'pending'
    }
  ];

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}