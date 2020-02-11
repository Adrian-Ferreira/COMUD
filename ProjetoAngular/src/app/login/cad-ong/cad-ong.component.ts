import { Component, OnInit } from '@angular/core';
import { ONG } from './../../model/ONG';
import { WebListServiceService } from 'src/app/service/web-list-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cad-ong',
  templateUrl: './cad-ong.component.html',
  styleUrls: ['./cad-ong.component.css']
})
export class CadOngComponent implements OnInit {

  ong: ONG = new ONG();
  _msgEnviar: string = null;
  _msgEnviarE: string = null;


  filtro: any = /^([a-zA-zà-úÀ-Ú]|\s+)+$/;
  num: any = /^[0-9]+$/;

  _msgErroN: string = null
  _msgErroE: string = null
  _msgErroT: string = null
  _msgErroS: string = null;
  _msgErroEn: string = null;
  _msgErroD: string = null;

  constructor(private srv: WebListServiceService, private router:Router) { }

  ngOnInit() {

  }

  validacao() {

    if (this.ong.nome == "" || this.ong.email == "" || this.ong.telefone == null || this.ong.site == "" || this.ong.endereco == "" || this.ong.descricao == "") {
      alert('Preencha todos os campos');
    }

    if (!this.filtro.test(this.ong.nome)) {
      this.ong.nome = "";
      this._msgErroN = "Dado inválido";
    }
    else {
      this._msgErroN = null;
    }

    if (this.ong.email.indexOf("@") == -1 && this.ong.email.indexOf("@") > 1 || this.ong.email.indexOf(".") == -1) {
      this.ong.email = "";
      this._msgErroE = "Dado inválido";
    }
    else {
      this._msgErroE = null;
    }

    if (this.ong.telefone.length < 10 || !this.num.test(this.ong.telefone)) {
      this.ong.telefone = null;
      this._msgErroT = `Digite um telefone válido`;
    }
    else {
      this._msgErroT = null;
    }

    if (this.ong.site.indexOf(".") < 2) {
      this.ong.site = "";
      this._msgErroS = `URL inválida`;
    }
    else {
      this._msgErroS = null;
    }

    if (this.ong.nome != "" && this.ong.email != "" && this.ong.telefone != null && this.ong.site != "" && this.ong.endereco != "" && this.ong.descricao != "") {
      this._msgEnviar = null;
      this._msgEnviarE = null;
      this.srv.cadastra(this.ong).subscribe(res => {
        this._msgEnviar = "Dados enviados com SUCESSO!!";
        this.ong.nome = "";
        this.ong.email = "";
        this.ong.telefone = null;
        this.ong.site = "";
        this.ong.endereco = "";
        this.ong.descricao = "";
        this.router.navigate(['/consultaongs']);
      },
        error => {
          this._msgEnviarE = "Erro ao enviar dados!!";
          this.ong.nome = "";
          this.ong.email = "";
          this.ong.telefone = null;
          this.ong.site = "";
          this.ong.endereco = "";
          this.ong.descricao = "";
        })
    }
  }

  limpaEnviar() {
    this._msgEnviar = null;
    this._msgEnviarE = null;
  }

}
