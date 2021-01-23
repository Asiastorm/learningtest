import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Teacher} from '../../norm/entity/Teacher';
import {FormControl} from '@angular/forms';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-teacher-select',
  templateUrl: './teacher-select.component.html',
  styleUrls: ['./teacher-select.component.sass']
})
export class TeacherSelectComponent implements OnInit {
  @Output() selected = new EventEmitter<Teacher>();
  @Input() teacher: Teacher;
  url = 'http://localhost:8080/Teacher';

  constructor() {
  }

  /**
   * 获取所有的教师，并传给V层
   */
  ngOnInit() {
  }

  onSelected(teacher: Teacher): void {
    this.selected.emit(teacher);
  }
}
