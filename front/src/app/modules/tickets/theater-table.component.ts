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

  @Input() data: any;
  @Input() displayedColumns: any = [];
  @Input() filterDataPlaceholder: string = '';

  dataSource: MatTableDataSource<any>;
  dataCellDef: any[] = [];

  constructor() {}

  ngOnInit() {
    
    const cellData = this.data.filter((data) => this.premappedObject(data));

    this.dataSource = new MatTableDataSource(cellData);

    console.log(this.dataSource.data);
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
    let mappedData = [];
    Object.entries(data).forEach((item) => {
      let value = item.pop();
      this.dataCellDef.push(item.pop());
      mappedData = [...mappedData, value];
    });
    console.log(this.dataCellDef[0])
    return mappedData;
  }


}
