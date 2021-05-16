import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shows',
  templateUrl: './shows.component.html',
  styleUrls: ['./shows.component.scss'],
})
export class ShowsComponent implements OnInit {
  shows: any;
 
  filterPlaceholder: string = 'Pretrazite predstave';

  constructor() {}

  ngOnInit(): void {
    this.shows = [
      {
        id: 1,
        name: 'Kostana',
        duration: '90 min',
        description: 'Izvodi se u Vranje, predstava Bore Stankovica...',
        author: 'Bora Stankovic',
        genre: 'Drama',
      },
      {
        id: 2,
        name: 'Kostana',
        duration: '90 min',
        description: 'Izvodi se u Vranje, predstava Bore Stankovica...',
        author: 'Bora Stankovic',
        genre: 'Drama',
      },
      {
        id: 3,
        name: 'Kostana',
        duration: '90 min',
        description: 'Izvodi se u Vranje, predstava Bore Stankovica...',
        author: 'Bora Stankovic',
        genre: 'Drama',
      },
      {
        id: 4,
        name: 'Kostana',
        duration: '90 min',
        description: 'Izvodi se u Vranje, predstava Bore Stankovica...',
        author: 'Bora Stankovic',
        genre: 'Drama',
      },
      {
        id: 5,
        name: 'Kostana',
        duration: '90 min',
        description: 'Izvodi se u Vranje, predstava Bore Stankovica...',
        author: 'Bora Stankovic',
        genre: 'Drama',
      },
      {
        id: 6,
        name: 'Kostana',
        duration: '90 min',
        description: 'Izvodi se u Vranje, predstava Bore Stankovica...',
        author: 'Bora Stankovic',
        genre: 'Drama',
      },
      {
        id: 7,
        name: 'Kostana',
        duration: '90 min',
        description: 'Izvodi se u Vranje, predstava Bore Stankovica...',
        author: 'Bora Stankovic',
        genre: 'Drama',
      },
      {
        id: 8,
        name: 'Kostana',
        duration: '90 min',
        description: 'Izvodi se u Vranje, predstava Bore Stankovica...',
        author: 'Bora Stankovic',
        genre: 'Drama',
      },
      {
        id: 9,
        name: 'Kostana',
        duration: '90 min',
        description: 'Izvodi se u Vranje, predstava Bore Stankovica...',
        author: 'Bora Stankovic',
        genre: 'Drama',
      },
    ];
  }
}
