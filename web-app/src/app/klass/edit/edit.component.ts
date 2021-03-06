import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {KlassModule} from '../klass.module';
import {Klass} from '../../norm/entity/klass';
import {Teacher} from '../../norm/entity/Teacher';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.sass']
})
export class EditComponent implements OnInit {
  formGroup: FormGroup;
  teacher: Teacher;
  private url: string;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private httpClient: HttpClient) {

  }

  private getUrl(): string {
    return this.url;
  }

  loadData(): void {
    this.httpClient.get(this.getUrl())
      .subscribe((klass: Klass) => {
        this.formGroup.setValue({name: klass.name});
        this.teacher = klass.teacher;
      }, () => {
        console.error('${this.getUrl()}请求发生错误');
      });
  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      name: new FormControl()
    });

    this.route.params.subscribe((param: { id: number }) => {
      console.log(param);
      this.setUrlById(param.id);
      this.loadData();
    });
  }

  onSubmit(): void {
    const data = {
      name: this.formGroup.value.name,
      teacher: {id: this.teacher.id}
    };
    this.httpClient.put(this.getUrl(), data)
      .subscribe(() => {
        this.router.navigateByUrl('', {relativeTo: this.route});
      }, () => {
        console.error(`在${this.getUrl()}上的PUT请求发生错误`);
      });
  }

  onTeacherSelected(teacher: Teacher) {
    this.teacher = teacher;
  }

  private setUrlById(id: number): void {
    this.url = `http://localhost:8080/Klass/${id}`;
  }
}
