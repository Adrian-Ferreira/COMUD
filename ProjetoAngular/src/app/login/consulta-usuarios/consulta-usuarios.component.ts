import { Component, OnInit } from '@angular/core';
import { WebListServiceService } from '../../service/web-list-service.service';
import { Router } from '@angular/router';
import { ONG } from 'src/app/model/ONG';

@Component({
  selector: 'app-consulta-usuarios',
  templateUrl: './consulta-usuarios.component.html',
  styleUrls: ['./consulta-usuarios.component.css'],
})

export class ConsultaUsuariosComponent implements OnInit {

  listaOng: ONG[];
  constructor(private router: Router, private srv: WebListServiceService) { }

  ngOnInit() {
    this.srv.consultaTudo().subscribe((resp: ONG[]) => {
      this.listaOng = resp;
    });
  }
}
