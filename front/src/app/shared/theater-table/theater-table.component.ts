import { Router } from '@angular/router';
import { NotificationService } from './../services/notification.service';
import { SharedService } from './../services/shared.service';
import {
  AfterViewInit,
  Component,
  Input,
  OnInit,
  ViewChild,
} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-theater-table',
  templateUrl: './theater-table.component.html',
  styleUrls: ['./theater-table.component.scss'],
})
export class TheaterTableComponent implements OnInit, AfterViewInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  @Input() data: any[] = [];
  @Input() filterDataPlaceholder: string = '';


  displayedColumns: any = [
    'Id',
    'Naziv',
    'Trajanje',
    'Opis',
    'Kreator',
    'Zanr',
    'Kupovina',
  ];

  dataSource: MatTableDataSource<any>;
  dataCellDef: any[] = [];

  manipulateShow: any[] = [];

  constructor(
    private sharedService: SharedService,
    private notificationService: NotificationService,
    public router: Router
  ) {}

  ngOnInit() {
    const cellData = this.data.filter((data) => this.premappedObject(data));

    this.dataSource = new MatTableDataSource(cellData);

    console.log(this.data + " FROM TABLE")
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  premappedObject(data: any) {
    console.log(data)
    let mappedData = [];
    Object.entries(data).forEach((item) => {
      let value = item.pop();
      console.log(value)
      this.dataCellDef.push(item.pop());
      mappedData = [...mappedData, value];
    });
    return mappedData;
  }

  addShow(item: any) {
    for (const x of this.manipulateShow) {
      if (x.id === item.id) {
        this.notificationService.warning('Predstava je vec dodata !');
        return;
      }
    }
    this.manipulateShow.push(item);
    this.notificationService.success('Predstava je uspesno dodata u korpu!');
    this.sharedService.manipulateShowSubject.next(this.manipulateShow);
  }

  removeShow(item: any) {
    const idx = this.data.findIndex((x) => x.id === item.id);

    if (idx !== -1) {
      this.data.splice(idx, 1);
      this.sharedService.manipulateShowSubject.next(this.data);
      this.notificationService.success(
        'Predstava je uspesno uklonjena iz korpe!'
      );
      this.dataSource = new MatTableDataSource(this.data)
    } else {
      this.notificationService.error('Ovu predstavu ste uklonili vec!');
      return;
    }
  }
}
