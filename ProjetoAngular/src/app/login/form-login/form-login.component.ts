import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../model/Usuario';
import { WebListServiceService } from 'src/app/service/web-list-service.service';
import { Router } from '@angular/router';
import { Globals } from '../../model/Login';
import { Token } from 'src/app/model/Token';
import { GlobalsUsuario } from 'src/app/model/GlobalsUsuario';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css'],
  providers: [Globals]
})
export class FormLoginComponent implements OnInit {

  usuario: Usuario = new Usuario;
  _msgEnviarE: string = null;
  _msgLogout: string = null;

  constructor(private srv: WebListServiceService, private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem("TOKEN")) {
      this.router.navigate(['home']);
    }
    else {
      Globals.nome = undefined;
      this._msgLogout = "Usuário desconectado!";
    }
  }

  autenticacao() {
    this._msgLogout = null;
    this._msgEnviarE = null;
    if (this.usuario.email == "" || this.usuario.senha == "" || this.usuario.email == null || this.usuario.senha == null) {
      this._msgEnviarE = "Preencha todos os campos";
    }
    else {
      this.srv.login(this.usuario).subscribe((res: Token) => {
        localStorage.setItem("TOKEN", res.token);
        localStorage.setItem("nome", res.nome);
        localStorage.setItem("email", res.email);
        this.srv.log.next(true);
        GlobalsUsuario.teste = true;
        this.router.navigate(['home']);
      },
        error => {
          this._msgEnviarE = "Email e/ou senha inválido(s)";
          this.usuario.email = "";
          this.usuario.senha = "";
          this.router.navigate(['login']);
        })
    }
  }

  limpaEnviar() {
    this._msgEnviarE = null;
    this._msgLogout = null;
  }


}
