import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AddComponent} from './add/add.component';
import {StudentRoutingModule} from './student-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { KlassSelectComponent } from './klass-select/klass-select.component';
import {CoreModule} from '../core/core.module';
import { IndexComponent } from './index/index.component';


@NgModule({
  declarations: [
    AddComponent,
    KlassSelectComponent,
    IndexComponent
  ],
    imports: [
        CommonModule,
        StudentRoutingModule,
        ReactiveFormsModule,
        CoreModule,
    ]
})
export class StudentModule {
}
