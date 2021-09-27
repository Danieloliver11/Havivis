import { Funcionario } from './../funcionario.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FuncionarioService } from '../funcionario.service';

@Component({
  selector: 'app-funcionario-update',
  templateUrl: './funcionario-update.component.html',
  styleUrls: ['./funcionario-update.component.css']
})
export class FuncionarioUpdateComponent implements OnInit {

  funcionario!: Funcionario;
 

  constructor(
    private funcionarioService: FuncionarioService,
     private router: Router,
      private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params.id
    this.funcionarioService.readById(id).subscribe((funcionario) => {
    this.funcionario = funcionario
  });
  }

  updateFuncionario(): void {
      this.funcionarioService.update(this.funcionario).subscribe(() => {
      this.funcionarioService.showMessage('Funcionário atualizado com sucesso!')
      this.router.navigate(['/funcionario'])
    })

  }

  cancel(): void {
    this.router.navigate(['/funcionario'])
  }

}
