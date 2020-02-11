import { Component, OnInit } from '@angular/core';
import { WebListServiceService } from '../service/web-list-service.service';
import { Usuario } from '../model/Usuario';
import { GlobalsUsuario } from '../model/GlobalsUsuario';
import { Router } from '@angular/router';
import * as $ from 'jquery';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  login: String = "";
  user: Usuario = new Usuario();
  constructor(private srv: WebListServiceService, private router: Router) { }

  log: boolean;
  ok: string;

  ngOnInit() {
    this.srv.buscarInfo(localStorage.getItem("TOKEN")).subscribe(
      (res: Usuario) => {
        GlobalsUsuario.usuario = res;
        this.user = res;
      },
      (err) => {
        this.user = null;
      }
    );

    this.srv.BuscaDetalhesProd(localStorage.getItem("TOKEN")).subscribe(
      (res: Usuario) => {
        GlobalsUsuario.usuario = res;
        this.user = res;
      },
      (err) => {
        this.user = null;
      }
    );
  }

  logout() {
    this.srv.log.next(false);
    localStorage.removeItem("TOKEN");
    localStorage.clear();
    $('#logout').click();
    this.user = null;
  }
  Login() {
    if (localStorage.getItem("TOKEN")) {
      this.srv.log.next(true);
    }
  }
}
