import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoolsCreatePage } from './schools-create.page';

describe('SchoolsCreatePage', () => {
  let component: SchoolsCreatePage;
  let fixture: ComponentFixture<SchoolsCreatePage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SchoolsCreatePage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SchoolsCreatePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
