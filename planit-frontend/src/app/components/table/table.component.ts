import { Component, EventEmitter, Output } from '@angular/core';
import { MainService } from 'src/app/api/api.service'
import { User } from 'src/app/interfaces/UserInterface'
import { first } from 'rxjs/operators'

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {

  users;

  constructor(private api: MainService) {
    this.api.users.subscribe(users => this.users = users)
  }

  selectUser(id: number) {
  	console.log(id)
  	this.api.selectUser(id)
  }
}
