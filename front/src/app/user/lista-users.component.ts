import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Users } from '../models/users';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-lista-users',
  templateUrl: './lista-users.component.html',
  styleUrls: ['./lista-users.component.css']

})
export class ListaUsersComponent implements OnInit {

  users: Users[] = [];
  constructor(   private usersService: UsersService,
    private toastr: ToastrService) { 
 
  }

  ngOnInit(): void {
    this.cargarUser();
  }

  cargarUser(): void {
    this.usersService.lista().subscribe(
      data => {
        this.users = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  public onBorrar(id:number) {
    this.usersService.delete(id).subscribe(
      data => {
        this.toastr.success('Usuario Eliminado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.cargarUser();
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
      }
    );
  }

}
