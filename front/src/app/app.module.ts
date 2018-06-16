import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {NgZorroAntdModule, NZ_MESSAGE_CONFIG} from 'ng-zorro-antd';
import {AppComponent} from './app.component';
import {registerLocaleData} from '@angular/common';
import zh from '@angular/common/locales/zh';
import {MyInterceptor} from './net/interceptors/my.interceptor';

registerLocaleData(zh);

@NgModule({
  declarations: [
    AppComponent
  ],
  imports     : [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgZorroAntdModule.forRoot()
  ],
  providers   : [
    {provide: HTTP_INTERCEPTORS, useClass: MyInterceptor, multi: true},
    {provide: NZ_MESSAGE_CONFIG, useValue: { nzDuration: 3000 }}
  ],
  bootstrap   : [AppComponent]
})
export class AppModule {
}
