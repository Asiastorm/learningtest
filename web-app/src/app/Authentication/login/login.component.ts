import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Route, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {ApiService} from '../../service/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {
  formGroup: FormGroup;

  constructor(private httpClient: HttpClient,
              private router: Router,
              private apiService: ApiService) {
  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    });
  }

  register() {
    this.router.navigateByUrl('register');
  }

  login() {
    const username = this.formGroup.get('username').value;
    const password = this.formGroup.get('password').value;
    this.apiService.login({username, password}).subscribe(result => {
      this.apiService.setIsLogin(true);
      console.log(result);
    });
  }
}
