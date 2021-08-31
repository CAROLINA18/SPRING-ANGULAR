import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users';
import { UsersService } from '../service/users.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-editar-users',
  templateUrl: './editar-users.component.html',
  styleUrls: ['./editar-users.component.css']
})
export class EditarUsersComponent implements OnInit {

  user: Users | null = null;

  constructor(
    private userService: UsersService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.userService.detail(id).subscribe(
      data => {
        this.user = data;
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    if(this.user){
      console.log(this.user);
    this.userService.update(id, this.user).subscribe(
      data => {
        this.toastr.success('usuario Actualizado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/']);
      }
   
    );
  }
  }
}
