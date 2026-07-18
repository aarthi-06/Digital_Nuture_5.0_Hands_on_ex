import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  Output,
  SimpleChanges
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight';
import { CreditLabel } from '../../pipes/credit-label-pipe';

export interface Course {
  id: number;
  name: string;
  code: string;
  credits: number;
  gradeStatus: 'passed' | 'failed' | 'pending';
}

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, Highlight, CreditLabel],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnChanges {

  @Input() course!: Course;

  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log(
        'Previous course:',
        changes['course'].previousValue,
        'Current course:',
        changes['course'].currentValue
      );
    }
  }

  requestEnrollment(): void {
    this.enrollRequested.emit(this.course.id);
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  get cardClasses() {
    return {
      'card--enrolled': false,
      'card--full': this.course.credits >= 4,
      expanded: this.isExpanded
    };
  }
}