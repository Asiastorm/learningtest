import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AddComponent} from './add/add.component';
import {IndexComponent} from './index/index.component';

const routes: Routes = [
  {
    path: '',
    component: IndexComponent
  },
  {
    path: '/add',
    component: AddComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule {
}
