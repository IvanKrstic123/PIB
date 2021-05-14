import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, mapTo, tap } from 'rxjs/operators';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private auth: BehaviorSubject<any>;
  private readonly JWT_TOKEN = "JWT_TOKEN";

  userData: null;

  constructor(private http: HttpClient) {
    this.auth = new BehaviorSubject<any>(
      JSON.parse(localStorage.getItem(this.JWT_TOKEN))
    )
  }

  signUp(user: { username: string, email: string, password: string }) {
    return this.http.post(environment.API_ENDPOINT + 'api/auth/signup', user, httpOptions).pipe(
      tap(message => console.log(message)),
      catchError((error) => {
        console.log(error.error)
        return of(false)
      })
    )
  }

  signIn(user: { username: string, pasword: string }) {
    return this.http.post<any>(environment.API_ENDPOINT + 'api/auth/signin', user).pipe(
      map((user: any) => {
        this.loginUser(user)
        this.auth.next(user);
        this.userData = user;
        return user;
      }),
      catchError((error) => {
        console.log(error.error)
        return of(false)
      })
    )
  }

  public get currentUserValue() {
    return this.auth.value;
  }

  
  private loginUser(user: any) {
    this.removeJwtToken();
    localStorage.removeItem('user');
    localStorage.setItem('user', JSON.stringify(user))
    this.userData = user;
    this.storeJwtToken(user.accessToken);
  }

  public logOutUser() {
    this.userData = null;
    localStorage.removeItem('user')
    localStorage.removeItem(this.JWT_TOKEN)
  }

  getJwtToken() {
    this.auth.next(localStorage.getItem(this.JWT_TOKEN));
    return localStorage.getItem(this.JWT_TOKEN)
  }

  private storeJwtToken(jwt: string) {
    console.log(jwt)
    localStorage.setItem(this.JWT_TOKEN, jwt);
  }
  private removeJwtToken() {
    localStorage.clear();
  }
}
