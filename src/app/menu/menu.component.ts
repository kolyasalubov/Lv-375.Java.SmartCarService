import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { User } from '../users/user';
import { UsersService } from '../users/users.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  private roles: String[];
  private authority: String;
  private username: String;
  user: User;
  
  constructor(private tokenStorage: TokenStorageService, private userService: UsersService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.username = this.tokenStorage.getUsername();

    this.userService.getUserByUsername(this.username)
    .subscribe(data => this.user = data);

      if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_CAR_OWNER') {
          this.authority = 'owner';
          return false;
        } else if (role === 'ROLE_SALES_MANAGER') {
          this.authority = 'sales';
          return false;
        } else if (role === 'ROLE_TECHNICAL_MANAGER') {
          this.authority = 'techmanager';
          return false;
        }else if (role === 'ROLE_DIELER') {
          this.authority = 'dieler';
          return false;
        }else if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_WORKER') {
          this.authority = 'worker';
          return false;
        }
        
      });
          } else {
            window.location.href = "/auth/login";
          }
  }

  goToNotifications(id){

  }

  goToOwnerCars(id) {
    this.router.navigate(['/ownercars', id]);
  }
  openUserProfile(){}

  openHelp(){}

  logout(){
    this.tokenStorage.signOut();
    window.location.href='/auth/login';
    }

  getAllUsers(){}

}