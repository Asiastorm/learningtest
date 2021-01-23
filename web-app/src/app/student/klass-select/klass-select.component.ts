import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Klass} from '../../norm/entity/klass';
import {FormControl} from '@angular/forms';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-klass-select',
  templateUrl: './klass-select.component.html',
  styleUrls: ['./klass-select.component.sass']
})
export class KlassSelectComponent implements OnInit {
  @Output() selected = new EventEmitter<Klass>();
  @Input() klass: Klass;
  url = 'http://localhost:8080/Klass?name=';

  klasses: Array<Klass>;
  klassSelect: FormControl;

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit() {
    this.klassSelect = new FormControl();
    const url = 'http://localhost:8080/Klass?name=';
    this.httpClient.get(url)
      .subscribe((klasses: Array<Klass>) => {
        this.klasses = klasses;
        this.klasses.forEach((klass: Klass) => {
          if (typeof (this.klass) !== 'undefined' && klass.id === this.klass.id) {
            this.klassSelect.setValue(klass);
          }
        });
      });
  }

  onSelected(klass: Klass): void {
    this.selected.emit(klass);
  }
}
