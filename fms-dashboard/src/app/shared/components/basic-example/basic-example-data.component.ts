import { Component } from '@angular/core';

@Component({
  selector: 'basic-example-data',
  template: `
    <ng2-smart-table [settings]="settings" [source]="data"></ng2-smart-table>
  `,
})
export class BasicExampleDataComponent {

  settings = {
    columns: {
      vehicleId: {
        title: 'Vehicle ID',
      },
      customerName: {
        title: 'Customer Name',
      },
      plateNumber: {
        title: 'Plate ID',
      },
      status: {
        title: 'Status',
      },
    },
  };

  data = [
    {
      vehicleId: 'YS2R4X20005399401',
      customerName: 'Kalles Grustransporter',
      plateNumber: 'ABC123',
      status: 'CONNECTED',
    },
    {
      vehicleId: 'VLUR4X20009093588',
      customerName: 'Kalles Grustransporter',
      plateNumber: 'DEF456',
      status: 'CONNECTED',
    },
    {
      vehicleId: 'VLUR4X20009048066',
      customerName: 'Kalles Grustransporter',
      plateNumber: 'GHI789',
      status: 'CONNECTED',
    },
    {
      vehicleId: 'YS2R4X20005388011',
      customerName: 'Johans Bulk',
      plateNumber: 'JKL012',
      status: 'DISCONNECTED',
    },
    {
      vehicleId: 'YS2R4X20005387949',
      customerName: 'Johans Bulk',
      plateNumber: 'MNO345',
      status: 'CONNECTED',
    },
    {
      vehicleId: 'VLUR4X20009048066',
      customerName: 'Haralds Värdetransporter',
      plateNumber: 'PQR678',
      status: 'DICONNECTED',
    },
    {
      vehicleId: 'YS2R4X20005387055',
      customerName: 'Haralds Värdetransporter',
      plateNumber: 'STU901',
      status: 'CONNECTED',
    },

  ];
}
