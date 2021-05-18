import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PerformancesService } from 'src/app/shared/services/performances.service';

@Component({
  selector: 'app-shows',
  templateUrl: './shows.component.html',
  styleUrls: ['./shows.component.scss'],
})
export class ShowsComponent implements OnInit {
  shows: Performance[] = [];
 
  filterPlaceholder: string = 'Pretrazite predstave';

  constructor(private performancesService: PerformancesService) {}

  ngOnInit(): void {
   this.performancesService.getPerformances().subscribe(data => this.shows = data);

  
  }
}
