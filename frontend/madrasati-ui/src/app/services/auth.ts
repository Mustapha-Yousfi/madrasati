import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

interface LoginRequest {
  username: string;
  password: string;
}

interface LoginResponse {
  token: string;
  userName: string;
  role: string;
}
@Injectable({
  providedIn: 'root',
})
export class Auth {
  private http = inject(HttpClient);

  private apiUrl = '/api/auth/login';

  login(payload: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(this.apiUrl, payload);
  }
}
