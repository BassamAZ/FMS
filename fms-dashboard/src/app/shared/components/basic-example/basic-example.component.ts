import { Component } from '@angular/core';

@Component({
  selector: 'basic-example',
  template: `
    <ng2-smart-table [settings]="settings"></ng2-smart-table>
  `,
})
export class BasicExampleComponent {

  settings = {
    columns: {
      id: {
        title: 'Vehicle ID',
        width: '100px',
      },
      name: {
        title: 'Customer Name',
        width: '40%',
      },
      username: {
        title: 'Plate ID',
      },
      email: {
        title: 'Status',
      },
    },
  };

}
