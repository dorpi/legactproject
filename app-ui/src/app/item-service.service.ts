import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from '../models/Item';
import { Observable } from 'rxjs';

@Injectable()
export class ItemService {

  private itemsUrl: string;

  constructor(private http: HttpClient) {
    this.itemsUrl = 'http://localhost:8080/items/';
  }

  public findAll(): Observable<Item[]> {
    return this.http.get<Item[]>(this.itemsUrl);
  }

  public save(item: Item) {
    return this.http.post<Item>(this.itemsUrl, item);
  }


  public getItemById(id :string){
    return this.http.get<Item>(this.itemsUrl.concat(id));
  }


  public edit(item: Item) {
    return this.http.put<Item>(this.itemsUrl.concat(item.id.toString()), item);
  }


  public deleteItem(id:bigint){
    return this.http.delete<Item>(this.itemsUrl.concat(id.toString()))
  }

  public addAmount(amount:number,id:bigint){
    return this.http.put(this.itemsUrl.concat(id.toString(),"/inc/",amount.toString()),amount)
  }


  public subAmount(amount:number,id:bigint){
    return this.http.put(this.itemsUrl.concat(id.toString(),"/dec/",amount.toString()),amount)
  }
}
