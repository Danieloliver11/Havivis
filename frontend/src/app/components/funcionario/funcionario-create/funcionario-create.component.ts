import { Funcionario } from './../funcionario.model';
import { Component, OnInit } from '@angular/core';
import { FuncionarioService } from '../funcionario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-funcionario-create',
  templateUrl: './funcionario-create.component.html',
  styleUrls: ['./funcionario-create.component.css']
})
export class FuncionarioCreateComponent implements OnInit {

  funcionario: Funcionario = {
    login: '',
    senha: '',
    nome: '',
    email: '',
    adm: false
  }

  constructor(
    private funcionarioService: FuncionarioService,
    private router: Router,) { }

  ngOnInit(): void {
  }


  createFuncionario(): void {
    this.funcionarioService.create(this.funcionario).subscribe(() => {
      this.funcionarioService.showMessage('Funcionário Criado')
      this.router.navigate(['/funcionario'])
    })

    
  }

  cancel(): void {
    this.router.navigate(['/funcionario'])
  }

}
