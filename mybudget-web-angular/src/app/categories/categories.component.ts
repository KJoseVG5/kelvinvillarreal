import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';
import { Category } from '../category'

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories : Category[];

  constructor(private categoryService: CategoryService) { }

  ngOnInit() {
    this.getCategories();
  }

  getCategories(): void {
    this.categoryService.getCategories().subscribe(categories => this.categories = categories)
  }

  add(name: string): void {
    name = name.trim();
  
    if (!name) { 
      return; 
    }

    this.categoryService.save({ name } as Category).subscribe(category => this.getCategories());
  }

  delete(category: Category): void {
    this.categoryService.delete(category).subscribe(_ => this.getCategories());
  }

}
