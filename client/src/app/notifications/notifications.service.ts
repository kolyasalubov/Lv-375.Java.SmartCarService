import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Notifications } from  './notifications';
import * as SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';
import { Globals } from '../globals';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {

  private baseUrl = Globals.baseURL + '/notifications';
  private notificationsSource = new BehaviorSubject<Notifications[]>([]);
  currentNotifications = this.notificationsSource.asObservable();
 
  // connect(){
  //   let socket = new WebSocket('http://localhost:9501/socket');
  //   let ws = Stomp.over(socket);
  //   return ws;
  // }

  updateNotifications(notifications : Observable<Notifications[]>){
    notifications.subscribe(data => {
      this.wrapNotifications(data);
      this.notificationsSource.next(data);

    });
  }

  constructor(private http: HttpClient) { }

  public getAllNotifications(id) {
    return this.http.get<Notifications[]>(this.baseUrl + "/" + id);
  }

  public deleteNotification(id){
    return this.http.post(this.baseUrl + "/" + id, null);
  }

  private wrapNotifications(notifications){
    notifications.forEach(n => {
      n.showCheckbox = false;
      n.showDropdown = false;
      n.showButton = false;
      if (n.type === 'Warning'){
        n.showCheckbox = true;
      } else if (n.type === 'Review'){
        n.showButton = true;
      } else if (n.type !== 'Information'){
        n.showDropdown = true;
      }
    });
  }
}
