import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionnelComponent } from './professionnel.component';

describe('ProfessionnelComponent', () => {
  let component: ProfessionnelComponent;
  let fixture: ComponentFixture<ProfessionnelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfessionnelComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfessionnelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
