import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WebListServiceService } from '../../service/web-list-service.service';
import { Usuario } from 'src/app/model/Usuario';


@Component({
  selector: 'app-edita-usuario',
  templateUrl: './edita-usuario.component.html',
  styleUrls: ['./edita-usuario.component.css']
})
export class EditaUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario;
  _msgEnviar: string = null;
  _msgEnviarE: string = null;
  _msgErroSFA: string = null;
  _msgErroSFO: string = null;

  filtro: any = /^([a-zA-zà-úÀ-Ú]|\s+)+$/;
  num: any = /^[0-9]+$/;
  carEsp: any = /[@#$%&]/;
  numFiltro: any = /[^0-9A-Za-z]*/;

  _msgErroN: string = null
  _msgErroE: string = null
  _msgErroT: string = null
  _msgErroS: string = null;
  _msgErroCS: string = null;

  id: number;

  constructor(private rota: ActivatedRoute, private srv: WebListServiceService, private router: Router) { }

  ngOnInit() {
    this.id = this.rota.snapshot.params["id"];

    this.srv.recuperaDetalhe(this.id).subscribe((res: Usuario) => {
      this.usuario = res;

    });
  }

  validacao() {

    if (this.usuario.confSenha == "" || this.usuario.confSenha == null || this.usuario.nome == "" || this.usuario.email == "" || this.usuario.telefone == null || this.usuario.endereco == null || this.usuario.endereco == "" || this.usuario.senha == "" || this.usuario.nome == null || this.usuario.email == null || this.usuario.senha == null) {
      alert('Preencha todos os campos');
    }

    if (!this.filtro.test(this.usuario.nome) || this.usuario.nome.indexOf(" ") < 1) {
      this.usuario.nome = "";
      this._msgErroN = "Dado inválido";
    }
    else {
      this._msgErroN = null;
    }

    if (this.usuario.email.indexOf("@") == -1 && this.usuario.email.indexOf("@") > 1 || this.usuario.email.indexOf(".") == -1) {
      this.usuario.email = "";
      this._msgErroE = "Dado inválido";
    }
    else {
      this._msgErroE = null;
    }

    if (this.usuario.telefone.length < 10 || !this.num.test(this.usuario.telefone)) {
      this.usuario.telefone = null;
      this._msgErroT = `Digite um telefone válido`;
    }
    else {
      this._msgErroT = null;
    }

    if (this.usuario.senha.length < 10) {
      this._msgErroSFA = null;
      this._msgErroSFO = null;
      this.usuario.senha = "";
      this._msgErroS = `A senha deve conter no minimo 10 caracteres`;
    }
    else {
      this._msgErroS = null;
    }

    if (this.usuario.confSenha === this.usuario.senha) {
      this._msgErroCS = null;
    }
    else {
      this.usuario.confSenha = "";
      this._msgErroCS = "As senhas nâo conferem";
    }

    if (this.usuario.nome != "" && this.usuario.email != "" && this.usuario.telefone != null && this.usuario.senha != "" && this.usuario.confSenha != "") {
      this._msgEnviar = null;
      this._msgEnviarE = null;
      this.srv.atualiza(this.usuario).subscribe(res => {
        this._msgEnviar = "Dados enviados com SUCESSO!!";
        this.usuario.nome = "";
        this.usuario.email = "";
        this.usuario.telefone = null;
        this.usuario.endereco = "";
        this.usuario.senha = "";
        this.usuario.confSenha = "";
        this._msgErroSFA = null;
        this._msgErroSFO = null;
        this.router.navigate(['/home'])
      },
        error => {
          this._msgEnviarE = "Erro ao enviar dados!!";
          this.usuario.nome = "";
          this.usuario.email = "";
          this.usuario.telefone = null;
          this.usuario.senha = "";
          this.usuario.confSenha = "";
          this._msgErroSFA = null;
          this._msgErroSFO = null;
        })

    }
  }

  vSenha() {
    if (this.carEsp.test(this.usuario.senha) && this.usuario.senha.length >= 10) {
      this._msgErroS = null;
      this._msgErroSFA = null;
      this._msgErroSFO = "Senha forte";
    }
    else if (this.filtro.test(this.usuario.senha) || this.num.test(this.usuario.senha) || this.numFiltro.test(this.usuario.senha)) {
      this._msgErroS = null;
      this._msgErroSFO = null;
      this._msgErroSFA = "Senha fraca";
    }
    else {
      this._msgErroSFA = null;
      this._msgErroSFO = null;
    }
  }

  limpaEnviar() {
    this._msgEnviar = null;
    this._msgEnviarE = null;
  }
}