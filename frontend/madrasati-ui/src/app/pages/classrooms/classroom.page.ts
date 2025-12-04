import { Component, inject, OnInit } from '@angular/core';
import { ClassroomService } from '../../services/classroom.service';
import { ClassroomListItem } from '../../models/classroom.model';

@Component({
  selector: 'app-classrooms',
  imports: [],
  templateUrl: './classroom.page.html',
  styleUrl: './classroom.page.scss',
})
export class ClassroomPage implements OnInit {
  private classRoomService: ClassroomService = inject(ClassroomService);

  classrooms: ClassroomListItem[] = [];
  loading = true;

  ngOnInit(): void {
    this.classRoomService.getClassrooms().subscribe({
      next: (data) => {
        this.classrooms = data;
        this.loading = false;
      },
      error: () => {
        this.loading = true;
      },
    });
  }
}
