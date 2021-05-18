import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PerformancesService {

  constructor(private http: HttpClient) { }

  getPerformances() {
    return this.http.get<Performance[]>(environment.API_ENDPOINT + 'performances/get');
  }
}
