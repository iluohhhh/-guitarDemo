import {Component, OnInit} from '@angular/core';
import {Guitar, GuitarService} from './net/guitar.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TypeService} from './net/type.service';
import {WoodService} from './net/wood.service';
import {BuilderService} from './net/builder.service';
import {NzMessageService} from 'ng-zorro-antd';
import {debounceTime, distinctUntilChanged} from 'rxjs/operators';

@Component({
  selector   : 'app-root',
  templateUrl: './app.component.html',
  styleUrls  : ['./app.component.css']
})
export class AppComponent implements OnInit {
  dataSet: Guitar[] = [];
  types: any[] = [];
  builders: any[] = [];
  woods: any[] = [];
  isVisible = false;
  isOkLoading = false;
  form: FormGroup;
  searchForm: FormGroup;

  constructor(private guitarService: GuitarService, private typeService: TypeService, private woodService: WoodService,
              private builderService: BuilderService, private message: NzMessageService) {
  }

  ngOnInit(): void {
    this.reLoadGuitar();
    const fb = new FormBuilder();
    this.form = fb.group({
      serialNumber: [null, [Validators.required]],
      price       : [null, [Validators.required]],
      builder     : [null, [Validators.required]],
      type        : [null, [Validators.required]],
      topWood     : [null, [Validators.required]],
      backWood    : [null, [Validators.required]],
      model       : [],
    });
    this.searchForm = fb.group({
      serialNumber: [null],
      price       : [null],
      builder     : [null],
      type        : [null],
      topWood     : [null],
      backWood    : [null],
      model       : [],
    });
    this.searchForm.valueChanges.pipe(debounceTime(500), distinctUntilChanged()).subscribe(value => {
      this.guitarService.searchGuitar(value).subscribe((data: any) => {
        this.dataSet = data;
      });
    });
    this.typeService.getAll().subscribe((data: any) => {
      this.types = data;
    });
    this.builderService.getAll().subscribe((data: any) => {
      this.builders = data;
    });
    this.woodService.getAll().subscribe((data: any) => {
      this.woods = data;
    });
  }

  showModal(): void {
    this.isVisible = true;
  }

  handleOk(): void {
    this.isOkLoading = true;
    this.guitarService.save(this.form.value).subscribe(res => {
      this.reLoadGuitar();
      this.isVisible = false;
      this.isOkLoading = false;
      this.message.success('添加成功');
    }, error1 => {
      this.isOkLoading = false;
      this.message.error('添加失败');
    });
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  submitForm() {

  }

  deleteGuitar(data) {
    this.guitarService.deleteOne(data).subscribe(res => {
      this.reLoadGuitar();
      this.message.success('删除成功');
    });
  }

  private reLoadGuitar() {
    this.guitarService.getAll().subscribe((data: any) => {
      this.dataSet = data;
    });
  }

}
