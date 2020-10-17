
import { CreateItemComponent } from './create-item/create-item.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ItemListComponent } from './item-list/item-list.component';
import { EditItemComponent } from './edit-item/edit-item.component';
import { ItemComponent } from './item/item.component';



const routes: Routes = [
  { path: 'items', component: ItemListComponent },
  { path: 'add-item', component: CreateItemComponent },
  { path: 'edit-item', component: EditItemComponent },
  {path: 'item/:id', component: ItemComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
