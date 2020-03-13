import { Component, OnInit } from '@angular/core';
import {RentdetailsService} from '../../../service/rentdetails.service';
import {TotalIncome} from '../../../total-income';
import {Chart} from 'chart.js';
@Component({
  selector: 'app-toatl-income',
  templateUrl: './toatl-income.component.html',
  styleUrls: ['./toatl-income.component.css']
})

export class ToatlIncomeComponent implements OnInit {

  data: TotalIncome[];
  Player = [];
  Run = [];
  Linechart : any;
  colour  = [
    "#ec407a", "#26a69a", "#7e57c2", "#29b6f6",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a",
    "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da",
    "#8d6e63", "#d4e157", "#29b6f6", "#ffca28"
  ];
  constructor(private rentDetails : RentdetailsService) { }

  ngOnInit() {
    this.rentDetails.getTotalIncome().subscribe((data: TotalIncome[]) => {
      data.forEach(x => {
        this.Player.push(x.monthName);
        this.Run.push(x.totalAmount);
      });
      this
      this.Linechart = new Chart('canvas', {
        type: 'bar',
        data: {
          labels: this.Player,

          datasets: [
            {
              data: this.Run,
              borderColor: this.colour,
              backgroundColor: this.colour,
              borderWidth: 1,

            }
          ]
        },
        options: {
          title: {
            display: true,
            text: 'Report -Total Income In Each Month'
          },
          scales: {
            xAxes: [{
              time: {
                unit: 'month'
              },
              gridLines: {
                display: false
              },
              scaleLabel: {
                display: true,
                labelString: 'Month Name',
                fontStyle: 'bold'
              },
              ticks: {
                maxTicksLimit: 5
              }
            }],
            yAxes: [{
              ticks: {
                beginAtZero: true,
                maxTicksLimit: 5
              },
              gridLines: {
                display: false
              },
              scaleLabel: {
                display: true,
                labelString: 'Total Income',
                fontStyle:'bold'

              }
            }],
          },
          legend: {
            display: false
          }
        }
      });
    });
  }

}
