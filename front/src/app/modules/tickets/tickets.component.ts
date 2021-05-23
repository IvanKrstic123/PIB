import { SharedService } from 'src/app/shared/services/shared.service';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.scss'],
})
export class TicketsComponent implements OnInit {
  tickets: any;

  filterPlaceholder: string = 'Pretrazite predstave';

  constructor(private sharedService: SharedService) {}

  ngOnInit() {
    this.sharedService.manipulateShowSubject.subscribe(data => {
      this.tickets = data;
    })
  }
}
