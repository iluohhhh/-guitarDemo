import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BuilderService {
  constructor(private http: HttpClient) {
  }

  public getAll() {
    const url = `builders`;
    return this.http.get(url);
  }
}
