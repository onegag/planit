import { Component, Input } from '@angular/core';
import { User } from 'src/app/interfaces/UserInterface'
import { MainService } from 'src/app/api/api.service'
import { first } from 'rxjs/operators'

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  selectedUser: User;

  constructor(private api: MainService) {
    api.selectedUser.subscribe(user => this.selectedUser = user)
  }

  deselectUser() {
    this.api.deselectUser()
    setTimeout(() => console.log(this.selectedUser), 5000)
  }

  changeField(event, fieldName: string) {
  	this.selectedUser[fieldName] = event.target.value
  }

  submitForm() {
    // TODO: validation: all fields required
    this.selectedUser.id ? this.api.updateUser(this.selectedUser) : this.api.createUser(this.selectedUser)
    this.api.deselectUser();
  }

  deleteUser() {
    this.api.removeUserById(this.selectedUser.id)
    this.api.deselectUser();
  }

}
