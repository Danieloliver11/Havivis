import { FuncionarioService } from '../funcionario.service';
import { Funcionario } from './../funcionario.model';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-funcionario-read',
  templateUrl: './funcionario-read.component.html',
  styleUrls: ['./funcionario-read.component.css']
})
export class FuncionarioReadComponent implements OnInit {

  funcionarios: Funcionario[] = [];
  displayedColumns = ['id','nome','email','adm','action']

  constructor(private funcionarioService: FuncionarioService) { }

  ngOnInit(): void {
    this.funcionarioService.read().subscribe(funcionarios => {
      this.funcionarios = funcionarios
      console.log(funcionarios)
    })
  }
}
