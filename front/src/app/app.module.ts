import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from 'ngx-toastr';
import { ListaUsersComponent } from './user/lista-users.component';
import { DetalleUsersComponent } from './user/detalle-users.component';
import { NuevoUsersComponent } from './user/nuevo-users.component';
import { EditarUsersComponent } from './user/editar-users.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaUsersComponent,
    DetalleUsersComponent,
    NuevoUsersComponent,
    EditarUsersComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
   bootstrap: [AppComponent]
})
export class AppModule { }
