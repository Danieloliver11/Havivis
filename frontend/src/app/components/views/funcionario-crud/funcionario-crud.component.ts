import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderService } from '../../template/header/header.service';

@Component({
  selector: 'app-funcionario-crud',
  templateUrl: './funcionario-crud.component.html',
  styleUrls: ['./funcionario-crud.component.css']
})
export class FuncionarioCrudComponent implements OnInit {

  constructor(private router: Router, private headerService: HeaderService) {
    headerService.headerdata = {
      title: 'Cadastro de Funcionário',
      icon: 'person',
      routeUrl: '/funcionario'
    }
   }

  ngOnInit(): void {
  }

  navigateToFuncionarioCreate() {
    this.router.navigate(['/funcionario/create'])
  }
}
