import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ClassroomService } from '../../services/classroom.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { SchoolService } from '../../services/school.service';
import { SchoolListItem } from '../../models/school.model';

@Component({
  selector: 'app-classroom-create',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './classroom-create.page.html',
  styleUrl: './classroom-create.page.scss',
})
export class ClassroomCreatePage implements OnInit {
  private fb: FormBuilder = inject(FormBuilder);
  private classroomService: ClassroomService = inject(ClassroomService);
  private schoolService: SchoolService = inject(SchoolService);
  private router: Router = inject(Router);
  form!: FormGroup;
  schools: SchoolListItem[] = [];

  ngOnInit(): void {
    this.schoolService.getSchools().subscribe({
      next: (data) => {
        this.schools = data;
      },
      error: (err) => {
        console.error('Erreur chargment écoles', err);
      },
    });
    this.form = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      level: ['', Validators.required],
      schoolId: [null, Validators.required],
    });
  }

  onSubmit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    console.log('FORM VALID DATA = ', this.form.value);
    this.classroomService.createClassroom(this.form.value).subscribe({
      next: () => {
        alert('Classe créé avec succès');
        this.form.reset();
        this.router.navigate(['/classes']);
      },
      error: (err) => {
        console.log(err);
        alert('Erreur lors de la création de la classe');
      },
    });
  }
}
