import { Router } from '@angular/router';
import { catchError, map, shareReplay } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { NotificationService } from './notification.service';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private userSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;

  private readonly JWT_TOKEN = 'JWT_TOKEN';
  private readonly USER_DATA = 'USER_DATA';

  expirationTimeout?: any;

  constructor(
    private http: HttpClient,
    private notificationService: NotificationService,
    private router: Router
  ) {
    this.userSubject = new BehaviorSubject<any>(
      localStorage.getItem(this.USER_DATA)
    );
    this.currentUser = this.userSubject.asObservable();
  }

  public get currentUserValue(): any {
    return this.userSubject.value;
  }

  signUp(user: { username: string; email: string; password: string }) {
    return this.http
      .post<any>(environment.API_ENDPOINT + 'api/auth/signup', user)
      .pipe(
        catchError((error) => {
          if (error.error.message === 'Email is already in use!') {
            this.notificationService.error('Email is already in use!');
          }
          if (error.error.message === 'Username is already taken!') {
            this.notificationService.warning('Username is already taken!');
          }
          return of(error.error.message);
        })
      );
  }

  signIn(user: { username: string; pasword: string }) {
    return this.http
      .post<any>(environment.API_ENDPOINT + 'api/auth/signin', user)
      .pipe(
        map((user) => {
          this.login(user);
          this.userSubject.next(user);
          this.handleExpiration(user);
          return user;
        }),
        shareReplay()
      );
  }

  public isLogged(user: any) {
    this.userSubject.next(user);
  }

  private login(user) {
    console.log(user)
    localStorage.setItem(this.USER_DATA, user);
    localStorage.setItem(this.JWT_TOKEN, user.accessToken);
  }

  public logout() {
    localStorage.clear();
    this.userSubject.next(null);
    this.router.navigate(['/auth']);
  }

  public autoLogout(expiration: any) {
    if(this.expirationTimeout) {
      clearTimeout(this.expirationTimeout)
    }
    this.expirationTimeout = setTimeout(() => {
      this.logout();
    },expiration)
  }

  private handleExpiration(user: any) {
    const time = 4000;
    const expiration = new Date(new Date().getTime() + time * 1000);
    const newUser = {
      ...user,
      expiration,
    };
    this.userSubject.next(newUser);
    localStorage.setItem(this.USER_DATA, JSON.stringify(newUser));
    localStorage.setItem(this.JWT_TOKEN, newUser.accessToken)
    this.autoLogout(time * 1000);
  }
}
