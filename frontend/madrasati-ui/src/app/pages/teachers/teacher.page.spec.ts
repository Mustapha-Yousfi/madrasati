import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherPage } from './teacher.page';

describe('Teachers', () => {
  let component: TeacherPage;
  let fixture: ComponentFixture<TeacherPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TeacherPage],
    }).compileComponents();

    fixture = TestBed.createComponent(TeacherPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
