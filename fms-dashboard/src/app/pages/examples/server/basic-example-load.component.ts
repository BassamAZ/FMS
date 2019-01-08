import { Component } from '@angular/core';

import { LocalDataSource } from '../../../../ng2-smart-table';
import { BasicExampleLoadService } from './basic-example-load.service';

@Component({
  selector: 'basic-example-load',
  providers: [BasicExampleLoadService],
  template: `
    <ng2-smart-table [settings]="settings" [source]="source"></ng2-smart-table>
  `,
})
export class BasicExampleLoadComponent {

  source: LocalDataSource;

  settings = {
    columns: {
      id: {
        title: 'Vehicle ID',
        editable: false,
        addable: false,
      },


      name: {
        title: 'Customer Name',
      },
      username: {
        title: 'Plate ID',
      },
      email: {
        title: 'Status',
      },
    },
  };

  constructor(protected service: BasicExampleLoadService) {
    this.source = new LocalDataSource();

    this.service.getData().then((data) => {
      this.source.load(data);
    });
  }
}
