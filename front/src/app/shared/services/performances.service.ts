import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PerformancesService {

  constructor(private http: HttpClient) { }

  getPerformances() {
    return this.http.get<Performance[]>(environment.API_ENDPOINT + 'performances/get');
  }

  addPerformances(){
    return this.http.post<Performance>(environment.API_ENDPOINT + 'performances/add', {});
  }
}
