import { Component, OnInit } from '@angular/core';
import { UsersService } from '../service/users.service';
import { Users } from '../models/users';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nuevo-users',
  templateUrl: './nuevo-users.component.html',
  styleUrls: ['./nuevo-users.component.css']
})
export class NuevoUsersComponent implements OnInit {

  id  = 0;
  name = '';
  email = '';
  surname = '';
  password = '';
  fecha_creacion = new Date('0000-00-00');
  celular = '';

  constructor(
    private userService: UsersService,
    private toastr: ToastrService,
    private router: Router
    ) { }

  ngOnInit() {
  }

  onCreate(): void {
    const user = new Users(this.id, this.name,this.email,this.surname,this.password,this.fecha_creacion,this.celular);
    this.userService.save(user).subscribe(
      (data: any) => {
        console.log('Response', data);
        this.toastr.success('Producto Creado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/']);
      },
      (err: any) => {
        console.log('Response Error', err);
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/']);
      }
    );
  }

}
