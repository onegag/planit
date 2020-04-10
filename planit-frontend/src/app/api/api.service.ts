import { Injectable } from '@angular/core';
import { USERS } from 'src/config'
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/interfaces/UserInterface'
import { BehaviorSubject } from 'rxjs';

const emptyUser: User = {
  id: null,
  name: '',
  surname: '',
  birth_date: '',
  address: ''
}


@Injectable({
  providedIn: 'root'
})
export class MainService {

  users = new BehaviorSubject<any>(null)
  selectedUser = new BehaviorSubject<any>(emptyUser)

  constructor(private http: HttpClient) {}

  selectUser(id: number) {
    this.selectedUser.next(this.users.getValue().find(x => x.id == id))
  }

  deselectUser() {
    this.selectedUser.next(emptyUser)
  }

  getAllUsers() {
  	this.http.get(USERS).subscribe(users => this.users.next(users))
  }

  createUser(user: User) {
  	return this.http.post(USERS, user).subscribe(() => this.getAllUsers())
  }

  updateUser(user: User) {
  	this.http.put(USERS + '/' + user.id, user).subscribe(() => this.getAllUsers())
  }

  removeUserById(id: number) {
  	this.http.delete(USERS + '/' + id).subscribe(() => this.getAllUsers())
  }


}
