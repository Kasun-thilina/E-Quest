import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {GuestDashboardComponent} from './views/guest/guest-dashboard/guest-dashboard.component';
import {ViewAllBikesComponent} from './views/guest/view-all-bikes/view-all-bikes.component';
import {AdminDashboardComponent} from './views/admin/admin-dashboard/admin-dashboard.component';
import {BikeComponent} from './views/admin/bike/bike.component';
import {BikeViewComponent} from './views/admin/bike-view/bike-view.component';
import {ManageGuestComponent} from './views/admin/manage-guest/manage-guest.component';
import {ViewReservationsComponent} from './views/admin/view-reservations/view-reservations.component';
import {ReserveBikeComponent} from './views/guest/reserve-bike/reserve-bike.component';
import {AdminLoginComponent} from './views/admin/admin-login/admin-login.component';
import {ToatlIncomeComponent} from './views/admin/toatl-income/toatl-income.component';
import {DamageBikeComponent} from './views/admin/damage-bike/damage-bike.component';

const routes: Routes = [
  {
    path:'admin',
    component:AdminDashboardComponent,
    children:[
      {path:'bike',component:BikeComponent},
      {path:'all-bikes',component:BikeViewComponent},
      {path:'all-guests',component:ManageGuestComponent},
      {path:'all-reservations',component:ViewReservationsComponent},
      {path:'total-income',component:ToatlIncomeComponent},
      {path:'damage-bike',component:DamageBikeComponent}
    ],
  },

  {path: 'admin', pathMatch: 'full', redirectTo: 'admin/bike'},

  // {path:':username',component:GuestDashboardComponent},
  {path:'',component:GuestDashboardComponent},
  {path:'view-bikes/:username',component:ReserveBikeComponent},
  {path:'login',component:AdminLoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
