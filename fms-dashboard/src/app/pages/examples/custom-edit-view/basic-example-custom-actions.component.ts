import { Component } from '@angular/core';

@Component({
  selector: 'basic-example-custom-actions',
  template: `
    <ng2-smart-table [settings]="settings" [source]="data" (custom)="onCustom($event)"></ng2-smart-table>
  `,
})
export class BasicExampleCustomActionsComponent {

  settings = {
    columns: {
      id: {
        title: 'Vehicle ID',
      },
      name: {
        title: 'Customer Name',
      },
      username: {
        title: 'Plate ID',
      },
      email: {
        title: 'Status',
      }
    },
  };

  data = [
    {
      id: 1,
      name: 'Leanne Graham',
      username: 'Bret',
      email: 'Sincere@april.biz',
    },
    {
      id: 2,
      name: 'Ervin Howell',
      username: 'Antonette',
      email: 'Shanna@melissa.tv',
    },
    {
      id: 3,
      name: 'Clementine Bauch',
      username: 'Samantha',
      email: 'Nathan@yesenia.net',
    },
    {
      id: 4,
      name: 'Patricia Lebsack',
      username: 'Karianne',
      email: 'Julianne.OConner@kory.org',
    },
    {
      id: 5,
      name: 'Chelsey Dietrich',
      username: 'Kamren',
      email: 'Lucio_Hettinger@annie.ca',
    },
  ];

  onCustom(event) {
    alert(`Custom event '${event.action}' fired on row №: ${event.data.id}`)
  }
}
