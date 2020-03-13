import { Component, OnInit } from '@angular/core';
import {BikeService} from '../../../service/bike.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-bike',
  templateUrl: './bike.component.html',
  styleUrls: ['./bike.component.css']
})
export class BikeComponent implements OnInit {



  addBikeForm: FormGroup;

  constructor(private bikeService: BikeService, private formBuilder: FormBuilder) {
    this.createBike();
  }

  ngOnInit() {

  }

  createBike(){
    this.addBikeForm = this.formBuilder.group({
      bikeNumber:['',Validators.required],
      bikeName:['',Validators.required],
      bikeType:['',Validators.required],
      bikeBrandName:['',Validators.required],
      bikePrice:['',Validators.required]
    });
  }


  registerBike(bikeNumber,bikeName,bikeType,bikeBrandName,bikePrice){
    this.bikeService.saveBike(bikeNumber,bikeName,bikeType,bikeBrandName,bikePrice);
    this.addBikeForm.reset();
    Swal.fire({
      title: 'Bike Registration Complete',
      text: 'You Have Been Successfully Add A Bike For This Application',
      type: 'success',
      showCancelButton: false,
      confirmButtonText: 'Ok',
    })
  }

}
