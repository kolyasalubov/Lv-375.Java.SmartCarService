import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpErrorResponse, HttpResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {User} from './user';
import { Globals } from '../globals';
import { catchError } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<User[]> {
    return this.http.get<User[]>(Globals.baseURL + '/users');
  }

  deleteUserById(id: number) {
    return this.http.delete(Globals.baseURL + '/user/' + id);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(Globals.baseURL + '/user/' + id);
  }

  getUserByUsername(username: String): Observable<User> {
    return this.http.get<User>(Globals.baseURL + '/user/' + username + '/username');
  }

  postAvatar(avatar: FormData, username: String): Observable<HttpResponse<File>>{
    return this.http.post<File>(Globals.baseURL + '/uploadAvatar/' + username, avatar, {observe: 'response'})
    .pipe(
      catchError(this.handleError)
    );
  }

  postFile(fileToUpload: FormData): Observable<HttpResponse<File>> {
    return this.http.post<File>(Globals.baseURL + '/norms', fileToUpload,  { observe: 'response' })
    .pipe(
      catchError(this.handleError)
    );
}

getAvatar(username: String): Observable<String[]> {
  return this.http.get<String[]>(Globals.baseURL + '/downloadAvatar/' + username)
  .pipe(
    catchError(this.handleError)
  );
}

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };
}
