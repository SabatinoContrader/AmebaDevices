import { IntestazioneComponent } from '../components/intestazione/intestazione.component';
import { LoginComponent } from "../components/login/login.component";
import { HomeDriverComponent } from "../components/home-driver/home-driver.component";
import { FormsModule } from "@angular/forms";
import { NgModule } from "@angular/core";
import { TreeModule } from 'primeng/primeng';
import {DragDropModule} from 'primeng/dragdrop';
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from "./app-routing.module";
import { UserService } from "../services/user.service";
import { CustomerService } from "../services/customer.service";
import {BrowserModule} from '@angular/platform-browser';
import { AppComponent } from "./app.component";
import { HomeOwnerComponent } from "../components/home-owner/home-owner.component";
import { SignupComponent } from "../components/signup/signup.component";
import { ReportDriverComponent } from "../components/report-driver/report-driver.component";
import { ReportService } from "../services/report.service";
import { CarComponent } from "../components/car/car.component";
import { CarService } from "../services/car.service";
import { AddCarComponent } from "../components/addCar/addCar.component";
import { ReportHystoryComponent } from "../components/report-hystory/report-hystory.component";
import { ReportOwnerComponent } from "../components/report-owner/report-owner.component";
import { ReportNearComponent } from "../components/report-near/report-near.component";
import { PaymentComponent } from "../components/payment/payment.component";
import { PaymentService } from "../services/payment.service";
import { ExtensionStopsComponent } from "../components/extension-stops/extension-stops.component";
import { ExtensionStopsRowComponent } from "../components/extension-stops-row/extension-stops-row.component";
import { FindCarplaceComponent } from "../components/find-carplace/find-carplace.component";
import { AgmCoreModule } from '@agm/core';
import { GoogleMapService } from "../services/google-map.service";
import { ManagementParkComponent } from "../components/management-park/management-park.component";
import { LegislationsComponent } from "../components/legislations/legislations.component";
import { UsefulNumbersComponent } from "../components/useful-numbers/useful-numbers.component";
import { ManagementSlotComponent } from '../components/management-slot/management-slot.component';
import { SlotService } from '../services/slot.service';
import { SuperuserComponent } from '../components/superuser/superuser.component';
import { SuperuserService } from '../services/superuser.service';
import { InstallerComponent } from '../components/installer/installer.component';
import { BuildingService } from '../services/building.service';
import { BuildingTableComponent } from '../components/building-table/building-table.component';
import { BuildingTreeComponent } from '../components/building-tree/building-tree.component';
import { BuildingTreeService } from '../services/buildingTree.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeDriverComponent,
    HomeOwnerComponent,
    SignupComponent,
    ReportDriverComponent,
    CarComponent,
    AddCarComponent,
    ReportHystoryComponent,
    ReportOwnerComponent,
    ReportNearComponent,
    PaymentComponent,
    ExtensionStopsComponent,
    ExtensionStopsRowComponent,
    FindCarplaceComponent,
    ManagementParkComponent,
    LegislationsComponent,
    UsefulNumbersComponent,
    IntestazioneComponent,
    ManagementSlotComponent,
    SuperuserComponent,
    InstallerComponent,
    BuildingTableComponent,
    BuildingTreeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAUf_fIZF0iu40Uiwhj3RhFE3Kd1KrWUFw',
      libraries: ["places"]
    }),
    TreeModule,
    DragDropModule
  ],
  providers: [
    UserService,
    CustomerService, 
    SuperuserService, 
    ReportService, 
    CarService,
    PaymentService,
    GoogleMapService, 
    SlotService,
    BuildingService,
    BuildingTreeService
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
