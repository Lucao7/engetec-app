import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtribuicaoComponent } from './atribuicao.component';

describe('AtribuicaoComponent', () => {
  let component: AtribuicaoComponent;
  let fixture: ComponentFixture<AtribuicaoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AtribuicaoComponent]
    });
    fixture = TestBed.createComponent(AtribuicaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
