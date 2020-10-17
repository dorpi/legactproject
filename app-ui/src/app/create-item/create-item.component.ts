import { AlertService } from './../alert.service';
import { Component,  } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../item-service.service';
import { Item } from '../../models/Item';

@Component({
  selector: 'app-item-form',
  templateUrl: './create-item.component.html',
  styleUrls: ['./create-item.component.css']
})
export class CreateItemComponent  {


  item:Item;


  constructor(private route: ActivatedRoute,
    private router: Router,
    private itemService: ItemService ,public alertService:AlertService) {
    this.alertService.clear();
    this.item = new Item();
  }



  onSubmit() {
    this.itemService.save(this.item).subscribe(result => this.gotoItemList(),err=>{
    console.log(err)
      this.alertService.onAlert(err.error.message)
    }
    );
  }

  gotoItemList() {
    this.router.navigate(['/items']);
  }

}
