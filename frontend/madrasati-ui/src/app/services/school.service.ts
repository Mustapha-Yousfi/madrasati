import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SchoolListItem } from '../models/school.model';

@Injectable({
  providedIn: 'root',
})
export class SchoolService {
  private http: HttpClient = inject(HttpClient);

  getSchools(): Observable<SchoolListItem[]> {
    return this.http.get<SchoolListItem[]>('/api/schools');
  }
}
