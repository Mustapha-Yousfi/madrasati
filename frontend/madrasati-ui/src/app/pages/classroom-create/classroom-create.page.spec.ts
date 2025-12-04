import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassroomCreatePage } from './classroom-create.page';

describe('ClassroomCreatePage', () => {
  let component: ClassroomCreatePage;
  let fixture: ComponentFixture<ClassroomCreatePage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClassroomCreatePage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClassroomCreatePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
