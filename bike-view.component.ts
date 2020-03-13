import { Component, OnInit } from '@angular/core';
import {Bike} from '../../../bike';
import {BikeService} from '../../../service/bike.service';
import { ActivatedRoute, Router } from '@angular/router';
import {FormGroup, Validators,FormBuilder} from '@angular/forms';
import Swal from 'sweetalert2'



@Component({
  selector: 'app-bike-view',
  templateUrl: './bike-view.component.html',
  styleUrls: ['./bike-view.component.css']
})
export class BikeViewComponent implements OnInit {

  constructor(private bikeService: BikeService,private route : ActivatedRoute,private router : Router,private formBuilder:FormBuilder) {
    this.createBikePriceUpdate();
  }

  bikeName: string;

  bike: Bike[];

  updateSelectedBike: Bike[];

  bikeNumber: string;
  bikeType: string;
  bikeBrandName: string;
  bikeId: number;
  price: number;

  bikeName1:string;
  updateBikePriceForm: FormGroup;
  status: string;



  ngOnInit() {
    this.bikeService.getAllBikes().subscribe((data: Bike[]) => {
      this.bike = data;
    })


  }

  deleteBike(bikeId: number) {
    this.bikeService.deleteBike(bikeId).subscribe(res => {
      Swal.fire({
        title: 'Removing Completed',
        text: 'You Have Been Successfully Deleted Your Bike From This Application',
        type: 'warning',
        showCancelButton: false,
        confirmButtonText: 'Ok',
      });
      this.ngOnInit();
    })
  }


  updateBikePopUp(bikeId: number) {
    return  this.bikeService.searchBikeById(bikeId).subscribe((value:Bike[])=> {
      this.updateSelectedBike = value;
    });
  }

  updateBikePrice(bikePrice: string){
    this.route.params.subscribe(params=> {
      this.bikeService.updateBikePrice(this.updateSelectedBike['bikeId'], bikePrice);
      this.updateBikePriceForm.reset();
      this.ngOnInit();
      Swal.fire({
        title: 'Bike Price Update Complete',
        text: 'You Have Been Successfully Updated Your Bike For This Application',
        type: 'success',
        showCancelButton: false,
        confirmButtonText: 'Ok',
      });
    });

  }

  createBikePriceUpdate(){
    this.updateBikePriceForm = this.formBuilder.group({
      bikePrice:['',Validators.required],
    });
  }

}

    


