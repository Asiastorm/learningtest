import {Component, OnInit} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {Router} from '@angular/router';
import {ApiService} from './service/api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  isLogin = false;

  constructor(public translateService: TranslateService,
              private router: Router,
              private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.translateService.addLangs(['zh', 'en']);
    this.translateService.setDefaultLang('zh');
    const browserLang = this.translateService.getBrowserLang();
    this.translateService.use(browserLang.match(/zh|en/) ? browserLang : 'zh');
    this.apiService.isLogin$.subscribe(isLogin => this.isLogin = isLogin);
    this.router.navigateByUrl('login');
  }
}
