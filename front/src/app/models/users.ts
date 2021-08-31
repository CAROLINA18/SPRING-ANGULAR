export class Users {
    id : number;
    nombre : string;
    email :string;
    surname :string;
	password :string;
	fecha_creacion :Date;
	celular :string;


    constructor(id:number , nombre:string , email:string , surname:string , password:string , fecha_creacion:Date , celular:string){
        this.id = id,
        this.nombre = nombre,
        this.email = email,
        this.surname = surname,
        this.password = password,
        this.fecha_creacion = fecha_creacion,
        this.celular = celular
    }
}


