import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TeacherAddComponent} from './teacher/add/teacher-add.component';
import {TeacherEditComponent} from './teacher/edit/teacher-edit.component';
import {TeacherIndexComponent} from './teacher/index/teacher-index.component';
import {WelcomComponent} from './welcom/welcom.component';
import {RegisterComponent} from './Authentication/register/register.component';
import {LoginComponent} from './Authentication/login/login.component';


const routes: Routes = [
  {
    path: '',
    component: WelcomComponent
  },
  {
    path: 'teacher',
    component: TeacherIndexComponent
  },
  {
    path: 'teacher/add',
    component: TeacherAddComponent
  },
  {
    path: 'teacher/edit/:id',
    component: TeacherEditComponent
  },
  {
    path: 'klass',
    loadChildren: () => import('./klass/klass.module').then(mod => mod.KlassModule)
  },
  {
    path: 'student',
    loadChildren: () => import('./student/student.module').then(mod => mod.StudentModule)
  },
  {
    path: 'register',
    component: RegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
