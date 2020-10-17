import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Item}from  '../../models/Item'
import {ItemService} from '../item-service.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  amount:number;
  items: Item[];



  constructor(private userService: ItemService,private router: Router) {
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.items = data;
    });
  }


  onDelete(id:bigint)
  {
      this.userService.deleteItem(id).subscribe(rseult=>{


        this.userService.findAll().subscribe(data => {
          this.items = data;
        });
      })
  }
}
