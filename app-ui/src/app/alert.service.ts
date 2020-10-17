import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  message:string;
  show:boolean;

  constructor() { }


  onAlert (message:string){
    this.show=true;
    this.message =message;

    setTimeout(()=>{
      this.clear()
    },3000 )
  }

  clear (){
    this.message='';
    this.show=false;
  }

}

