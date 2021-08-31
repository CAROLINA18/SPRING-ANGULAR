import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DetalleUsersComponent } from './user/detalle-users.component';
import { EditarUsersComponent } from './user/editar-users.component';
import { ListaUsersComponent } from './user/lista-users.component';
import { NuevoUsersComponent } from './user/nuevo-users.component';



const routes: Routes = [
  {path: '', component: ListaUsersComponent},
  {path: 'detalle/:id', component: DetalleUsersComponent},
  {path: 'nuevo', component: NuevoUsersComponent},
  {path: 'editar/:id', component: EditarUsersComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
