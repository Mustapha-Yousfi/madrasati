import { Component, inject, OnInit } from '@angular/core';
import { TeacherService } from '../../services/teacher.service';
import { TeacherListItem } from '../../models/teacher.model';

@Component({
  selector: 'app-teachers',
  imports: [],
  templateUrl: './teacher.page.html',
  styleUrl: './teacher.page.scss',
})
export class TeacherPage implements OnInit {
  private teacherService: TeacherService = inject(TeacherService);

  teachers: TeacherListItem[] = [];
  loading = true;
  ngOnInit(): void {
    this.teacherService.getTeachers().subscribe({
      next: (data) => {
        this.teachers = data;
        this.loading = false;
      },
      error: () => {
        this.loading = true;
      },
    });
  }
}
