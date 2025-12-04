import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { ClassroomListItem } from '../models/classroom.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClassroomService {
  private http: HttpClient = inject(HttpClient);

  getClassrooms(): Observable<ClassroomListItem[]> {
    return this.http.get<ClassroomListItem[]>('/api/classes');
  }
}
