import { Component, OnInit } from '@angular/core';
import {RentdetailsService} from '../../../service/rentdetails.service';
import {Reservationdetails} from '../../../reservationdetails';
import {Guest} from '../../../guest';
import { ActivatedRoute, Router } from '@angular/router';
import {FormGroup, Validators,FormBuilder} from '@angular/forms';
import Swal from 'sweetalert2'
import {Bike} from '../../../bike';
import {BikeService} from '../../../service/bike.service';

@Component({
  selector: 'app-view-reservations',
  templateUrl: './view-reservations.component.html',
  styleUrls: ['./view-reservations.component.css']
})
export class ViewReservationsComponent implements OnInit {

  constructor(private rentDetailService: RentdetailsService,private route : ActivatedRoute,private router : Router,private formBuilder:FormBuilder,private bikeService:BikeService) {
    this.createReservationUpdate();
  }

  bike : Bike[];
  bikeId : number;
  rentId : number;

  rentDetails: Reservationdetails[];

  searchRentDetails : Reservationdetails[];
  // status: string;
  userName: string;
  rentStatus: string;
  updateReservationForm: FormGroup;

  ngOnInit() {
    this.rentDetailService.reservationSummary().subscribe((data: Reservationdetails[]) => {
      this.rentDetails = data;
    });


  }

  searchResrvation(rentId: number) {
    return this.rentDetailService.searchReservationById(rentId).subscribe((value:Reservationdetails[])=> {
      console.log(value);
      this.searchRentDetails = value;
      this.bikeId = value['bikeId'];
      this.rentId = value['rentId'];
    });
  }


  updateReservationStatus(status: string,bikeStatus:string) {
      this.rentDetailService.updateReservationStatus(this.searchRentDetails['rentId'],status,this.bikeId,bikeStatus);
      this.updateReservationForm.reset();
      Swal.fire({
        title: 'Reservation Update Complete',
        text: 'You Have Been Successfully Updated The Reservation Status',
        type: 'success',
        showCancelButton: false,
        confirmButtonText: 'Ok',
      });
      this.ngOnInit();
  }
// call reservation
  createReservationUpdate(){
    this.updateReservationForm = this.formBuilder.group({
      status:['',Validators.required],
      bikeStatus:['',Validators.required],
    });
  }

}
