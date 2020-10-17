import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from 'src/models/Item';
import { ItemService } from '../item-service.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {


  inc:number;
  dec:number;
  item:Item;


  constructor(private route: ActivatedRoute,private itemService: ItemService,
    private router: Router)

  {
    this.item = new Item();
  }



  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.itemService.getItemById(id).subscribe(result=>{
      this.item = result
    },err=>this.goToItemLists())
  }

  onIncrease(incAmount:number){
    if (incAmount>0){
    this.itemService.addAmount(incAmount,this.item.id).subscribe(result=>{
      this.goToItemLists();

    })

  }
  }

  onDecrease(decAmount:number){
    if (decAmount>0){
      this.itemService.subAmount(decAmount,this.item.id).subscribe(result=>{
        this.goToItemLists();
      })
    }
  }


  goToItemLists(){
    this.router.navigate(['/items']);
  }
}
