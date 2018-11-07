import { DeleteRoomComponent } from './../components/deleteRoom/deleteRoom.component';
import { UpdateRoomComponent } from './../components/updateRoom/updateRoom.component';
import { IntestazioneComponent } from '../components/intestazione/intestazione.component';
import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from '../components/login/login.component';
import { HomeDriverComponent } from '../components/home-driver/home-driver.component';
import { HomeOwnerComponent } from '../components/home-owner/home-owner.component';
import { SignupComponent } from '../components/signup/signup.component';
import { ReportDriverComponent } from '../components/report-driver/report-driver.component';
import { CarComponent } from '../components/car/car.component';
import { AddCarComponent } from '../components/addCar/addCar.component';
import { ReportHystoryComponent } from '../components/report-hystory/report-hystory.component';
import { ReportOwnerComponent } from '../components/report-owner/report-owner.component';
import { ReportNearComponent } from '../components/report-near/report-near.component';
import { PaymentComponent } from '../components/payment/payment.component';
import { ExtensionStopsComponent } from '../components/extension-stops/extension-stops.component';
import { FindCarplaceComponent } from '../components/find-carplace/find-carplace.component';
import { ManagementParkComponent } from '../components/management-park/management-park.component';
import { UsefulNumbersComponent } from '../components/useful-numbers/useful-numbers.component';
import { LegislationsComponent } from '../components/legislations/legislations.component';
import { ManagementSlotComponent } from '../components/management-slot/management-slot.component';
import { SuperuserComponent} from '../components/superuser/superuser.component';
import { GestioneCustomerComponent} from '../components/gestioneCustomer/gestioneCustomer.component';
import { InsertCustomerComponent } from '../components/insertCustomer/insertCustomer.component';
import { GestioneBuildingComponent } from '../components/gestioneBuilding/gestioneBuilding.component';
import { InsertBuildingComponent } from '../components/insertBuilding/insertBuilding.component';
import {ItemtypemanagerComponent} from '../components/itemtype/itemtype.component';
import { InsertitemtypeComponent } from '../components/insertItemType/insertItemType.component';
import { UpdateitemtypeComponent } from '../components/updateitemType/updateitemType.component';
import { DeleteitemtypeComponent } from '../components/deleteitemType/deleteitemType.component';
import { ReaditemtypeComponent } from '../components/readitemType/readitemType.component';
import { ReadCustomerComponent } from '../components/readCustomer/readCustomer.component';
import { UpdateCustomerComponent } from '../components/updateCustomer/updateCustomer.component';
import { DeleteCustomerComponent } from '../components/deleteCustomer/deleteCustomer.component';
import { UpdateBuildingComponent } from '../components/updateBuilding/updateBuilding.component';
import { DeleteBuildingComponent } from '../components/deleteBuilding/deleteBuilding.component';
import { GestioneFloorComponent } from '../components/gestioneFloor/gestioneFloor.component';
import { InsertFloorComponent} from '../components/insertFloor/insertFloor.component';
import { UpdateFloorComponent } from 'src/components/updateFloor/updateFloor.component';
import { DeleteFloorComponent } from 'src/components/deleteFloor/deleteFloor.component';
import { GestioneRoomComponent } from 'src/components/gestioneRoom/gestioneRoom.component';
import { InsertRoomComponent } from 'src/components/insertRoom/insertRoom.component';
import { InstallermanagerComponent } from '../components/installer/installer.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'homeDriver', component: HomeDriverComponent},
  {path: 'superuser', component: SuperuserComponent},
  {path: 'homeOwner', component: HomeOwnerComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'itemTypeManager', component: ItemtypemanagerComponent},
  {path: 'car', component: CarComponent},
  {path: 'addCar', component: AddCarComponent},
  {path: 'reportDriver', component: ReportDriverComponent},
  {path: 'reportHystory', component: ReportHystoryComponent},
  {path: 'reportOwner', component: ReportOwnerComponent},
  {path: 'reportNear', component: ReportNearComponent},
  {path: 'findCarPlace', component: FindCarplaceComponent},
  {path: 'extensionStops', component: ExtensionStopsComponent},
  {path: 'reportDriver', component: ReportDriverComponent},
  {path: 'paymentsHystory', component: PaymentComponent},
  {path: 'managementPark', component: ManagementParkComponent},
  {path: 'usefulNumbers', component: UsefulNumbersComponent},
  {path: 'legislations', component: LegislationsComponent},
  {path: 'intestazione', component: IntestazioneComponent},
  {path: 'managementSlot', component: ManagementSlotComponent},
  {path: 'gestioneCustomer', component: GestioneCustomerComponent},
  {path: 'insertCustomer', component: InsertCustomerComponent},
  {path: 'gestioneBuilding', component: GestioneBuildingComponent},
  {path: 'insertBuilding', component: InsertBuildingComponent},
  {path: 'insertitemType', component: InsertitemtypeComponent},
  {path: 'itemtype', component:ItemtypemanagerComponent},
  {path: 'updateitemType', component:UpdateitemtypeComponent},
  {path: 'deleteitemType', component:DeleteitemtypeComponent},
  {path: 'readitemType', component:ReaditemtypeComponent},
  {path: 'readCustomer', component: ReadCustomerComponent},  
  {path: 'updateCustomer', component: UpdateCustomerComponent},
  {path: 'deleteCustomer', component: DeleteCustomerComponent},
  {path: 'updateBuilding', component: UpdateBuildingComponent},
  {path: 'deleteBuilding', component: DeleteBuildingComponent},
  {path: 'gestioneFloor/:buildingId', component: GestioneFloorComponent},
  {path: 'insertFloor/:buildingId', component: InsertFloorComponent},
  {path: 'updateFloor/:buildingId', component: UpdateFloorComponent},
  {path: 'deleteFloor/:buildingId', component: DeleteFloorComponent},
  {path: 'gestioneRoom/:floorId', component: GestioneRoomComponent},
  {path: 'insertRoom/:floorId', component: InsertRoomComponent},
  {path: 'updateRoom/:floorId', component: UpdateRoomComponent},
  {path: 'deleteRoom/:floorId', component: DeleteRoomComponent},
  {path: 'installer', component:InstallermanagerComponent}
];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  declarations: []
})
export class AppRoutingModule { }
