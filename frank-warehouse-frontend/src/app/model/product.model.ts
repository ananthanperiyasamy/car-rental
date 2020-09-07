
import { Car } from './car.model';
import { Location } from './location.model';
export class Product {
    constructor(
        public id: string, 
        public location: Location, 
        public name: string, 
        public cars : Car
    ){}
}