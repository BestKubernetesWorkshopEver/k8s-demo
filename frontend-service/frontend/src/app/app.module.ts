import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { ButtonsModule } from 'angular-bootstrap-md'
import { NavbarModule, WavesModule } from 'angular-bootstrap-md'
import { CardsModule } from 'angular-bootstrap-md'

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),
    ButtonsModule,
    NavbarModule,
    WavesModule,
    CardsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
