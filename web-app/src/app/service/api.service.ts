import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private isLogin: BehaviorSubject<boolean>;

  public isLogin$: Observable<boolean>;

  setIsLogin(isLogin: boolean) {
    window.sessionStorage.setItem('isLogin', isLogin ? '1' : '0');
    this.isLogin.next(isLogin);
  }

  constructor(private httpClient: HttpClient) {
    let isLogin: string = window.sessionStorage.getItem('isLogin');
    if (isLogin === null) {
      isLogin = '0';
    }

    this.isLogin = new BehaviorSubject<boolean>(isLogin === '0' ? false : true);
    this.isLogin$ = this.isLogin.asObservable();
  }

  login(param: object): Observable<boolean> {
    const url = 'http://localhost:8080/authentication/login';
    return this.httpClient.post<boolean>(url, param);
  }
}
