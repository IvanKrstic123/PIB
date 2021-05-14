import { HttpClient, HttpEventType, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, mapTo, tap } from 'rxjs/operators';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { NotificationService } from './notification.service';

const httpOptions = {
  headers:  new HttpHeaders({ 'Content-Type': 'application/json' }), observe: 'response' 
}
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private auth: BehaviorSubject<any>;
  private readonly JWT_TOKEN = "JWT_TOKEN";

  userData: null;

  constructor(private http: HttpClient, private notificationService: NotificationService) {
    this.auth = new BehaviorSubject<any>(
      localStorage.getItem(this.JWT_TOKEN)
    )
  }

  signUp(user: { username: string, email: string, password: string }) {
    return this.http.post<any>(environment.API_ENDPOINT + 'api/auth/signup', user).pipe(
      catchError((error) => {
        if(error.error.message === 'Email is already in use!') {
          this.notificationService.error('Email is already in use!')
        }
        if (error.error.message === 'Username is already taken!') {
          this.notificationService.warning('Username is already taken!')
        }
        return of(error.error.message)
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

  public getCurrentUser() {
    return localStorage.getItem('user');
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
