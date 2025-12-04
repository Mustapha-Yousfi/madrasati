import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassroomPage } from './classroom.page';

describe('Classrooms', () => {
  let component: ClassroomPage;
  let fixture: ComponentFixture<ClassroomPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClassroomPage],
    }).compileComponents();

    fixture = TestBed.createComponent(ClassroomPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
