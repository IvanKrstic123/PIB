import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RepertoarsRoutingModule } from './repertoars-routing.module';
import { RepertoarsComponent } from './repertoars.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    RepertoarsComponent
  ],
  imports: [
    CommonModule,
    RepertoarsRoutingModule,
    ReactiveFormsModule
  ]
})
export class RepertoarsModule { }
