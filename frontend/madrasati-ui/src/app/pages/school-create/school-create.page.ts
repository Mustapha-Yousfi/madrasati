import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { SchoolService } from '../../services/school.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-schools-create',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './school-create.page.html',
  styleUrl: './school-create.page.scss',
})
export class SchoolCreatePage implements OnInit {
  private schoolService: SchoolService = inject(SchoolService);
  private fb: FormBuilder = inject(FormBuilder);
  private router: Router = inject(Router);
  form!: FormGroup;

  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      address: ['', [Validators.required]],
      description: [''],
    });
  }

  onSubmit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    console.log('FORM VALID DATA = ', this.form.value);
    this.schoolService.createSchool(this.form.value).subscribe({
      next: () => {
        alert('Ecole créé avec succès');
        this.form.reset();
        this.router.navigate(['/schools']);
      },
      error: (err) => {
        console.error(err);
        alert("Erreur lors de la création de l'école");
      },
    });
  }
}
