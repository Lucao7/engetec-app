import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MaterialFileInputModule } from 'ngx-material-file-input';
import { MatSelectModule } from '@angular/material/select';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSliderModule } from '@angular/material/slider';



@NgModule({
  declarations: [],
  exports: [
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MaterialFileInputModule,
    MatDividerModule,
    MatSelectModule,
    MatDatepickerModule,
    MatCheckboxModule,
    MatExpansionModule,
    MatSliderModule,
  ]
})
export class AngularMaterialModule { }
