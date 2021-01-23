import {NgModule} from '@angular/core';
import {IndexComponent} from './index/index.component';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AddComponent} from './add/add.component';
import {CommonModule} from '@angular/common';
import {EditComponent} from './edit/edit.component';
import {TeacherSelectComponent} from './teacher-select/teacher-select.component';
import {KlassRoutingModule} from './klass-routing.module';
import {CoreModule} from '../core/core.module';

/**
 * 班级模块
 */
@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        KlassRoutingModule,
        CoreModule
    ],
  declarations: [IndexComponent, AddComponent, EditComponent, TeacherSelectComponent]
})
export class KlassModule {

}
