import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'creditLabel'
})
export class CreditLabel implements PipeTransform {

  transform(credits: number): string {
    return credits === 1
      ? '1 Credit'
      : `${credits} Credits`;
  }
}