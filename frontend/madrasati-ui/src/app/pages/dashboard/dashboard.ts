import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';

interface CurrentUserResponse {
  username: string;
  firstName: string;
  lastName: string;
  email: string;
  role: string;
}

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss',
})
export class Dashboard implements OnInit {
  private httpClient = inject(HttpClient);
  currentUser?: CurrentUserResponse;

  ngOnInit() {
    this.httpClient.get<CurrentUserResponse>('/api/users/me').subscribe((user) => {
      this.currentUser = user;
    });
  }
}
