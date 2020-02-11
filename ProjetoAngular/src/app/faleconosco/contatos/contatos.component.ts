import { Component, OnInit } from '@angular/core';
import { NgModelGroup } from '@angular/forms';
import { Faq } from 'src/app/model/Faq';

@Component({
  selector: 'app-contatos',
  templateUrl: './contatos.component.html',
  styleUrls: ['./contatos.component.css']
})
export class ContatosComponent implements OnInit {
  filtro: any = /^([a-zA-zà-úÀ-Ú]|\s+)+$/;
  num: any = /^[0-9]+$/;
  _msgErroN: string = null;
  _msgErroS: string = null;
  _msgErroE: string = null;
  _msgErroT: string = null;
  _msgErroSe: string = null;
  _msgEnviar: string = null;
  faq: Faq = new Faq();

  constructor() { }

  ngOnInit() {
  }

  validacao() {
    if (this.faq.nome == "" || this.faq.sobrenome == "" || this.faq.sobrenome == null || this.faq.email == "" || this.faq.telefone == null || this.faq.mensagem == "" || this.faq.nome == null || this.faq.email == null || this.faq.mensagem == null) {
      alert('Preencha todos os campos');
    }
    if (!this.filtro.test(this.faq.nome)) {
      this.faq.nome = "";
      this._msgErroN = "Dado inválido";
    }
    else {
      this._msgErroN = null;
    }
    if (this.faq.email.indexOf("@") == -1 && this.faq.email.indexOf("@") > 1 || this.faq.email.indexOf(".") == -1) {
      this.faq.email = "";
      this._msgErroE = "Dado inválido";
    }
    else {
      this._msgErroE = null;
    }

    if (this.faq.telefone.length < 10 || !this.num.test(this.faq.telefone)) {
      this.faq.telefone = null;
      this._msgErroT = `Digite um telefone válido`;
    }
    else {
      this._msgErroT = null;
    }

    if (this.faq.assunto == "Selecione") {
      this._msgErroSe = "Escolha uma opção";
    }
    else {
      this._msgErroSe = null;
    }

    if (this.faq.nome != "" && this.faq.sobrenome != "" && this.faq.email != "" && this.faq.mensagem != "" && this.faq.assunto != "Selecione" && this.faq.telefone) {
      this._msgEnviar = "Dados enviados com SUCESSO!!";
      this.faq.nome = "";
      this.faq.sobrenome = "";
      this.faq.email = "";
      this.faq.mensagem = "";
      this.faq.telefone = null;
      this.faq.assunto = "Selecione";
    }
  }
}
