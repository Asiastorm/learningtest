import {Klass} from './klass';

export class Student {
  id: number;
  klass: Klass;
  name: string;
  sno: string;


  constructor(data?: { id?: number; name?: string; sno?: string; klass?: Klass }) {
    if (!data) {
      return;
    }
    this.id = data.id ? data.id : null;
    this.klass = data.klass ? data.klass : null;
    this.name = data.name ? data.name : '';
    this.sno = data.sno ? data.sno : '';

  }
}
