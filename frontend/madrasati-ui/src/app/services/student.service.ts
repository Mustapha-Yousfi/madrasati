import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StudentListItem } from '../models/student.model';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  private http: HttpClient = inject(HttpClient);

  getStudents(): Observable<StudentListItem[]> {
    return this.http.get<StudentListItem[]>('/api/students');
  }
}
