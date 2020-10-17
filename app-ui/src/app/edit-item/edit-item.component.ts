import { AlertService } from './../alert.service';
import { Component,  OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../item-service.service';
import { Item } from '../../models/Item';

@Component({
  selector: 'app-item-form',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {


  item:Item;


  constructor(private route: ActivatedRoute,
    private router: Router,
    private itemService: ItemService,public alertService:AlertService) {
    this.alertService.clear();
    this.item = new Item();
  }
  ngOnInit(): void {
    this.itemService.getItemById(window.history.state.id).subscribe(result=>this.item = result)
  }

  onSubmit() {
    this.itemService.edit(this.item).subscribe(result => this.gotoUserList(),err=>{
      console.log("error")
      console.log(err.error.message)
      this.alertService.onAlert(err.error.message);
    }
    );
  }

  gotoUserList() {
    this.router.navigate(['/items']);
  }

}
