import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TeacherListItem } from '../models/teacher.model';

@Injectable({
  providedIn: 'root',
})
export class TeacherService {
  private http: HttpClient = inject(HttpClient);

  getTeachers(): Observable<TeacherListItem[]> {
    return this.http.get<TeacherListItem[]>('/api/teachers');
  }
}
