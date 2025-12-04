import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { MainLayout } from './layout/main-layout/main-layout';
import { authGuard } from './guards/auth-guard';

export const routes: Routes = [
  // --- Route publique ---
  {
    path: 'login',
    component: Login,
  },

  // --- Toutes les routes protégées par authGuard ---
  {
    path: '',
    component: MainLayout,
    canActivate: [authGuard], // 🔒 Protection globale POUR TOUTES les pages après login
    children: [
      {
        path: 'dashboard',
        loadComponent: () =>
          import('./pages/dashboard/dashboard.page').then((m) => m.DashboardPage),
      },
      {
        path: 'schools',
        loadComponent: () => import('./pages/schools/school.page').then((m) => m.SchoolPage),
      },
      {
        path: 'classes',
        loadComponent: () =>
          import('./pages/classrooms/classroom.page').then((m) => m.ClassroomPage),
      },
      {
        path: 'students',
        loadComponent: () => import('./pages/students/student.page').then((m) => m.StudentPage),
      },
      {
        path: 'teachers',
        loadComponent: () => import('./pages/teachers/teacher.page').then((m) => m.TeacherPage),
      },
      {
        path: 'school/create',
        loadComponent: () =>
          import('./pages/school-create/school-create.page').then((m) => m.SchoolCreatePage),
      },

      // --- Redirection si / rien ---
      { path: '', pathMatch: 'full', redirectTo: 'dashboard' },
    ],
  },

  // Wildcard global (si jamais besoin)
  { path: '**', redirectTo: 'dashboard' },
];
