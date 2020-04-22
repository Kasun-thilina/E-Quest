import { Component, OnInit } from '@angular/core';
import {GuestService} from '../../../service/guest.service';
import {Guest} from '../../../guest';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  loginForm: FormGroup;
  invalidLogin: boolean = false;

  guest : Guest;

  constructor(private guestService:GuestService,private formBuilder : FormBuilder,private router: Router){ }

  ngOnInit() {
    window.localStorage.removeItem('token');
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.invalid){
      return;
    }
    const loginPayload = {
      username: this.loginForm.controls.username.value,
      password: this.loginForm.controls.password.value
    };
    this.guestService.login(loginPayload).subscribe(data=>{
      // debugger;
      if (data.status === 200){
        window.localStorage.setItem('token', data.result.token);
        this.router.navigate(['admin/bike']);
      }else {
        this.invalidLogin = true;
        alert(data.message);
      }
    })

  }
}
