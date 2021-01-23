import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.sass']
})
export class IndexComponent implements OnInit {

  students = new Array();

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    const url = 'http://localhost:8080/student/query';
    this.httpClient.post(url, null)
      .subscribe((res: any) => {
        this.students = res.data;
      }, (rsp) => {
        console.error(`请求${url}出错` + rsp);
      });
  }

}
