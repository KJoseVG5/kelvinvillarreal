import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Category } from './category';

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{

	createDb(){
		const categories = [
			{ id: 11, name: 'Housing' },
			{ id: 12, name: 'Food' },
			{ id: 13, name: 'Fun' },
			{ id: 14, name: 'Education' },
			{ id: 15, name: 'Magneta' },
			{ id: 16, name: 'RubberMan' },
			{ id: 17, name: 'Dynama' },
			{ id: 18, name: 'Dr IQ' },
			{ id: 19, name: 'Magma' },
			{ id: 20, name: 'Tornado' }
		];

		return {categories};
	}

	// Overrides the genId method to ensure that a category always has an id.
	// If the category array is empty,
	// the method below returns the initial number (11).
	// if the heroes array is not empty, the method below returns the highest
	// hero id + 1.
	genId(categories: Category[]): number {
		return categories.length > 0 ? Math.max(...categories.map(category => category.id)) + 1 : 11;
	}
}
