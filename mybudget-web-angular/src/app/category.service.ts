import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of} from 'rxjs';

import { Category} from './category';

import { MessageService } from './message.service';

import { catchError, map, tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private categoriesUrl = 'http://localhost:8000/api/categories/';

  constructor(private http: HttpClient, private messageService: MessageService) { }

  getCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.categoriesUrl)
      .pipe(
          tap(_ => this.log('fetched categories')),
          catchError(this.handleError('getCategories', []))
      );
  }

  /** GET category by id. Will 404 if id not found */
  getCategory(id: number): Observable<Category> {
  	const url = `${this.categoriesUrl}/${id}`;
    
  	return this.http.get<Category>(url)
      .pipe(
        tap(_ => this.log(`fetched category id=${id}`)),
        catchError(this.handleError<Category>(`getCategory id =${id}`))
      );
  }

  /** PUT: update the category on the server */
  update (category: Category): Observable<any> {
    return this.http.put(this.categoriesUrl, category, httpOptions)
      .pipe(
        tap(_ => this.log(`updated category id=${category.id}`)),
        catchError(this.handleError<any>('updateCategory'))
      );
  }

  /** POST: add a new category to the server */
  save (category: Category): Observable<Category> {
    return this.http.post(this.categoriesUrl, category, httpOptions)
      .pipe(
        tap((category: Category) => this.log(`added category w/ id=${category.id}`)),
        catchError(this.handleError<Category>('addCategory'))
      );
  }

  /** DELETE: delete the category from the server */
  delete (category: Category | number): Observable<Category> {
    
    const id = typeof category === 'number' ? category : category.id;
    const url = `${this.categoriesUrl}/${id}`;
    return this.http.delete<Category>(url, httpOptions)
      .pipe(
        tap(_ => this.log(`deleted category id=${id}`)),
        catchError(this.handleError<Category>('deleteCategory'))
      );
  }


  /* GET categories whose name search term */
  search(term: string): Observable<Category[]> {
    if(!term.trim()){
      //if not search term, return empty array
      return of([]);
    }

    return this.http.get<Category[]>(`${this.categoriesUrl}/search?name=${term}`)
      .pipe(
        tap(_ => this.log(`found categories matching "${term}"`)),
        catchError(this.handleError<Category[]>('searchCategories', []))
      );
  }  

  private log(message: string){
    this.messageService.add(`CategoryService: ${message}`);
  }

  /**
  * Handle Http operation that failed.
  * Let the app continue.
  * @param operation - name of the operation that failed
  * @param result - optional value to return as the observable result
  */
  private handleError<T> (operation = 'operation', result?: T){
    return (error: any): Observable<T> => {

      //TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let de app keep running by returning an empty result.
      return of(result as T);
    }
  }
}
