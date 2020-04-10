import { Component, OnInit } from '@angular/core';
import { MainService } from 'src/app/api/api.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private api: MainService) {}

	ngOnInit() {
		this.api.getAllUsers()
	}

}
