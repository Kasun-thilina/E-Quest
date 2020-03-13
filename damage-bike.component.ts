import { Component, OnInit } from '@angular/core';
import {BikeService} from '../../../service/bike.service';
import {Bike} from '../../../bike';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from "sweetalert2";
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-damage-bike',
  templateUrl: './damage-bike.component.html',
  styleUrls: ['./damage-bike.component.css']
})
export class DamageBikeComponent implements OnInit {

  constructor(private bikeService:BikeService,private formBuilder:FormBuilder,private route : ActivatedRoute,private router : Router) {
    this.crateFormForBikeStatusUpdate();
  }

  bike:Bike[];

  bikeStatusSearch : Bike[];

  updateBikeStatuForm: FormGroup;
  bikeStatusOne : string;
  bikeId:number;

  ngOnInit() {
    this.bikeService.getAllBikes().subscribe((data:Bike[])=>{
      this.bike = data;
    })
  }

  updateBikeStatus(bikeId: number) {
    this.bikeService.searchBikeById(bikeId).subscribe((searchData:Bike[])=>{
      this.bikeStatusSearch = searchData;

      this.bikeStatusOne = searchData['bikeStatus'];
      this.bikeId = searchData['bikeId'];
    })

  }

  updateBikeStatusPopUp(bikeStatus: string) {
    this.route.params.subscribe(params=> {
      this.bikeService.updateBike(this.bikeId, bikeStatus);
      this.updateBikeStatuForm.reset();
      this.ngOnInit();
      Swal.fire({
        title: 'Bike Price Update Complete',
        text: 'You Have Been Successfully Updated Your Bike For This Application',
        type: 'success',
        showCancelButton: false,
        confirmButtonText: 'Ok',
      });
      this.ngOnInit()
    });

  }

  crateFormForBikeStatusUpdate(){
    this.updateBikeStatuForm = this.formBuilder.group({
      bikeStatus:['',Validators.required],
    });
  }

}
