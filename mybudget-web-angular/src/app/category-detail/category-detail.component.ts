import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Category } from '../category'
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.css']
})
export class CategoryDetailComponent implements OnInit {

	@Input() category: Category;

	constructor(
		private route: ActivatedRoute,
		private categoryService: CategoryService,
		private location: Location
	) { }

	ngOnInit() {
		this.getCategory();
	}

	getCategory(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.categoryService.getCategory(id).subscribe(category => this.category = category);
	}

	goBack(): void {
		this.location.back();
	}

	save(): void {
		this.categoryService.update(this.category).subscribe(() => this.goBack());
	}

}
