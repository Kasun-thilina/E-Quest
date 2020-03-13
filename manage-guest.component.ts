import { Component, OnInit } from '@angular/core';
import {Guest} from '../../../guest';
import {Bike} from '../../../bike';
import {GuestService} from '../../../service/guest.service';
import {Reservationdetails} from '../../../reservationdetails';
import {RentdetailsService} from '../../../service/rentdetails.service';
import Swal from 'sweetalert2'



@Component({
  selector: 'app-manage-guest',
  templateUrl: './manage-guest.component.html',
  styleUrls: ['./manage-guest.component.css']
})
export class ManageGuestComponent implements OnInit {

  constructor(private guestService : GuestService,private rentDetailService : RentdetailsService) { }

  guest : Guest[];
  searchRentDetailsByGuestId: Reservationdetails[];
  userName: string;
  country: string;

  ngOnInit() {
    this.guestService.getAllGuests().subscribe((data: Guest[]) => {
      this.guest = data;
    })
  }

  searchResrvationByGuestId(rentId: number) {
    return this.rentDetailService.searchReservationByGuestID(rentId).subscribe((value:Reservationdetails[])=> {
      console.log(value);
      this.searchRentDetailsByGuestId = value;
    });
  }

  removeGuest(guestId: number) {
    this.guestService.removeGuest(guestId).subscribe(res => {
      Swal.fire({
        title: 'Removing Completed',
        text: 'You Have Been Successfully Deleted Your Guest From This Application',
        type: 'warning',
        showCancelButton: false,
        confirmButtonText: 'Ok',
      });
      this.ngOnInit();
    })
  }
}
