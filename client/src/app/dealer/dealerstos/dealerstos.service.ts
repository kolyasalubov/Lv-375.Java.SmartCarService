import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import{Techservice} from 'src/app/techservice/techservice';
import { from } from 'rxjs';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class DealerstosService {

  constructor(private http:HttpClient) { }

  getAllDealersSto(username:String):Observable<Techservice[]>{
  return this.http.get<Techservice[]>('http://localhost:9501/api/dealer/allstos/'+username);
  }
}