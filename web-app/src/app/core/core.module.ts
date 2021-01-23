import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SelectComponent} from './select/select.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [SelectComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [SelectComponent]
})
export class CoreModule {
}
