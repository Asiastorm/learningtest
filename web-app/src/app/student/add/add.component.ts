import {Component, OnInit} from '@angular/core';
import {Student} from '../../norm/entity/student';
import {FormControl, FormGroup} from '@angular/forms';
import {Klass} from '../../norm/entity/klass';
import {HttpClient} from '@angular/common/http';
import {StudentService} from '../../service/student.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.sass']
})
export class AddComponent implements OnInit {

  student: Student;
  klass: Klass;
  formGroup: FormGroup;

  constructor(private studentService: StudentService) {
  }

  ngOnInit() {
    this.student = new Student();
    this.formGroup = new FormGroup({
      name: new FormControl(''),
      sno: new FormControl('')
    });
  }

  onSubmit(): void {
    this.student = this.formGroup.value;
    console.log(this.student);
    this.student.klass = this.klass;
    this.studentService.save(this.student).subscribe((data)=> {

    });
  }

  onKlassSelected(klass: Klass) {
    this.klass = klass;
  }
}
