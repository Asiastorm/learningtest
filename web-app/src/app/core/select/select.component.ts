import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Teacher} from '../../norm/entity/Teacher';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.sass']
})
export class SelectComponent implements OnInit {

  /*所有教师*/
  objects: Array<Select>;

  objectSelect: FormControl;

  @Output() selected = new EventEmitter<Select>();
  @Input() object: { id: number };
  @Input() url: string;

  constructor(private httpClient: HttpClient) {
  }


  /**
   * 获取所有的教师，并传给V层
   */
  ngOnInit() {
    this.objectSelect = new FormControl(this.object);
    this.httpClient.get(this.url)
      .subscribe((teachers: Array<Teacher>) => {
        this.objects = teachers;
      });
  }

  /**
   * 比较函数，标识用哪个字段来比较两个教师是否为同一个教师
   * @param t1 源
   * @param t2 目标
   */
  compareFn(t1: { id: number }, t2: { id: number }) {
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }

  onChange() {
    this.selected.emit(this.objectSelect.value);
  }
}

/**
 * 选择
 */
export class Select {
  id: number;
  name: string;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }
}
