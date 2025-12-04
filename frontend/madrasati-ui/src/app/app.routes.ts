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
        loadComponent: () => import('./pages/dashboard/dashboard').then((m) => m.Dashboard),
      },
      {
        path: 'schools',
        loadComponent: () => import('./pages/schools/schools').then((m) => m.SchoolsPage),
      },
      {
        path: 'classes',
        loadComponent: () => import('./pages/classes/classes').then((m) => m.ClassesPage),
      },
      {
        path: 'students',
        loadComponent: () => import('./pages/students/students').then((m) => m.StudentsPage),
      },
      {
        path: 'teachers',
        loadComponent: () => import('./pages/teachers/teachers').then((m) => m.TeachersPage),
      },

      // --- Redirection si / rien ---
      { path: '', pathMatch: 'full', redirectTo: 'dashboard' },
    ],
  },

  // Wildcard global (si jamais besoin)
  { path: '**', redirectTo: 'dashboard' },
];
