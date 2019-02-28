import { Component, OnInit, Input } from '@angular/core';
import { TimeList } from './time-list';
import { TimeListService } from './time-list-service';
import { WorkTime } from './work-time';
import { NewBooking } from './new-booking';
import { error } from '@angular/compiler/src/util';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingInfo } from './booking-info';
import { WorkInfo } from '../worker-list/work-info';

@Component({
  selector: 'app-time-list',
  templateUrl: './time-list.component.html',
  styleUrls: ['./time-list.component.scss']
})
export class TimeListComponent implements OnInit {

  @Input()
  carId : number;

  @Input()
  workInfo : Array<WorkInfo>;

  @Input()
  timeList : TimeList;
  error: ErrorEvent;
  bookingInfo : BookingInfo;
  newBooking : NewBooking;
  postBookingStatusCode : number;
  lastId : string;

  months = {'01':'Jan', '02':'Feb', '03':'Mar', '04':'Apr', '05':'May', '06':'June', '07':'July',
   '08':'Aug', '09':'Sept', '10':'Oct','11':'Nov', '12':'Dec'};

  constructor(private timeListServices : TimeListService, private router: Router) {}

  ngOnInit() {
    this.getBookingInfo()
  }

  getBookingInfo(){
    this.timeListServices.getBookingTime(this.timeList)
    .subscribe((data) => this.bookingInfo = data,
    error => this.error = error);
  }

  buttonClick(){
    this.getBookingInfo();
  }

  getDate(date : string) : string{
    return date.slice(8, 10) + " " + this.months[date.slice(5, 7)] + " " + date.slice(11, 16);
  }

  isEmptyDate(date : Array<WorkTime>): boolean{
   return date.length == 0;
    //return work.length == 0;
  }

  postBooking(){
    let newBooking: NewBooking = new NewBooking();
    newBooking.carId = this.carId;
    newBooking.start = this.bookingInfo.startBooking;
    newBooking.workInfo = this.workInfo;
    newBooking.workerId = this.timeList.workerId;
    
        this.timeListServices.postNewBooking(newBooking)
        .subscribe((date) => this.postBookingStatusCode = date,
        error => this.error = error);
}
goToHomePage() {
  this.router.navigate(['ui/home']);
}
select(startSession : string){
  if(this.lastId != undefined){
    document.getElementById(this.lastId).className = "jumbotron text-center hoverable p-4 ";
  }
  if(this.lastId == startSession){
    document.getElementById(this.lastId).className = "jumbotron text-center hoverable p-4 "
  }
  else{
  document.getElementById(startSession).className = "jumbotron text-center hoverable p-4 " + "select";
  }

  this.lastId = startSession;
}

}
