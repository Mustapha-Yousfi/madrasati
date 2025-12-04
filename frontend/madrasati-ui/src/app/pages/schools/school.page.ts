import { Component, inject, OnInit } from '@angular/core';
import { SchoolService } from '../../services/school.service';
import { SchoolListItem } from '../../models/school.model';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-schools-page',
  imports: [RouterLink],
  templateUrl: './school.page.html',
  styleUrl: './school.page.scss',
})
export class SchoolPage implements OnInit {
  private schoolService = inject(SchoolService);

  schools: SchoolListItem[] = [];
  loading = true;

  ngOnInit(): void {
    this.schoolService.getSchools().subscribe({
      next: (data) => {
        this.schools = data;
        this.loading = false;
      },
      error: () => {
        this.loading = true;
      },
    });
  }
}
