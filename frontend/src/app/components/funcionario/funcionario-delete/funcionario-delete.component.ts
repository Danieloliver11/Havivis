import { Funcionario } from './../funcionario.model';
import { Component, OnInit } from '@angular/core';
import { FuncionarioService } from '../funcionario.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-funcionario-delete',
  templateUrl: './funcionario-delete.component.html',
  styleUrls: ['./funcionario-delete.component.css']
})
export class FuncionarioDeleteComponent implements OnInit {

  funcionario: Funcionario = {
    nome: '',
    email: '',
    login: '',
    senha: '',
    adm: false
  };

  constructor(
    private funcionarioService: FuncionarioService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.params.id
    this.funcionarioService.readById(id).subscribe(funcionario => {
    this.funcionario = funcionario
    })
  }

  deleteFuncionario(): void {
    const id = +this.route.snapshot.params.id
    this.funcionarioService.delete(id).subscribe(() => {
    this.funcionarioService.showMessage("Funcionário deletado com sucesso!")
    this.router.navigate(['/funcionario'])
    })
  }

  cancel(): void {
    this.router.navigate(['/funcionario'])
  }

}
