import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EMPTY, Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Funcionario } from './funcionario.model';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  baseUrl = 'http://localhost:3001/funcionarios'

  constructor(
    private snackBar: MatSnackBar,
     private http: HttpClient) { }

  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ['msg-error'] : ['msg-success']
    })
  }

  create(funcionario: Funcionario): Observable<Funcionario> {
    return this.http.post<Funcionario>(this.baseUrl, funcionario).pipe(
      map((obj) => obj),
      catchError(e => this.errorHandler(e))


    )
  }

  read(): Observable<Funcionario[]> {
    return this.http.get<Funcionario[]>(this.baseUrl)
  }

  readById(id: number): Observable<Funcionario> {
    const url = `${this.baseUrl}/${id}`
    return this.http.get<Funcionario>(url)
  }

  update(funcionario: Funcionario): Observable<Funcionario> {
    const url = `${this.baseUrl}/${funcionario.id}`
    return this.http.put<Funcionario>(url, funcionario)
  }

  delete(id: number): Observable<Funcionario> {
    const url = `${this.baseUrl}/${id}`
    return this.http.delete<Funcionario>(url)
  }

  errorHandler(e: any) : Observable<any> {
    console.log(e)
    this.showMessage('Ocorreu um erro!', true);
    return EMPTY;
  }
}
