import { Component, inject, OnInit } from '@angular/core';
import { StudentService } from '../../services/student.service';
import { StudentListItem } from '../../models/student.model';

@Component({
  selector: 'app-students',
  imports: [],
  templateUrl: './student.page.html',
  styleUrl: './student.page.scss',
})
export class StudentPage implements OnInit {
  private studentService: StudentService = inject(StudentService);

  students: StudentListItem[] = [];
  loading = true;
  ngOnInit(): void {
    this.studentService.getStudents().subscribe({
      next: (data) => {
        this.students = data;
        this.loading = false;
      },
      error: () => {
        this.loading = true;
      },
    });
  }
}
