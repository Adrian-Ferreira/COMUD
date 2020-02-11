import { Component, OnInit } from '@angular/core';
import { WebListServiceService } from '../../service/web-list-service.service';
import { Router } from '@angular/router';
import { Produto } from 'src/app/model/Produto';
import { Usuario } from '../../model/Usuario';
import { GlobalsUsuario } from '../../model/GlobalsUsuario';

@Component({
  selector: 'app-cad-produto',
  templateUrl: './cad-produto.component.html',
  styleUrls: ['./cad-produto.component.css']
})
export class CadProdutoComponent implements OnInit {
  produto: Produto = new Produto;
  user: Usuario = new Usuario;
  userParse: Usuario = new Usuario;



  filtro: any = /^([a-zA-zà-úÀ-Ú]|\s+)+$/;
  _msgErroN = null;
  _msgErroF = null;
  _msgErroT = null;
  _msgErroCA = null;
  _msgErroCL = null;
  _msgErroCO = null;
  _msgErroD = null;
  _msgEnviar = null;
  _msgErro = null;

  constructor(private srv: WebListServiceService, private router: Router) { }

  ngOnInit() {
    if (!localStorage.getItem("TOKEN")) {
      alert("Você não pode acessar está página sem estar logado")
      this.router.navigate(['/login']);
    }

    this.srv.BuscaDetalhesProd(localStorage.getItem("TOKEN")).subscribe(
      (res: Usuario) => {
        GlobalsUsuario.usuario = res;
        this.user = res;

        this.userParse.idUsuario = this.user.idUsuario;
        this.produto.usuario = this.userParse;
      },
      (err) => {
        this.user = null;
      }
    );
  }

  validacao() {
    if (this.produto.nome == "" || this.produto.linkFoto == "" || this.produto.detalhes == "" || this.produto.nome == null || this.produto.linkFoto == null || this.produto.detalhes == null) {
      alert("Preencha todos os campos");
    }

    if (this.produto.tamanho == "Selecione") {
      this._msgErroT = "Escolha uma opção";
    }
    else {
      this._msgErroT = null;
    }

    if (this.produto.condicao == "Selecione") {
      this._msgErroCO = "Escolha uma opção";
    }
    else {
      this._msgErroCO = null;
    }

    if (this.produto.classificacao == "Selecione") {
      this._msgErroCL = "Escolha uma opção";
    }
    else {
      this._msgErroCL = null;
    }

    if (this.produto.categoria == "Selecione") {
      this._msgErroCA = "Escolha uma opção";
    }
    else {
      this._msgErroCA = null;
    }

    if (!this.filtro.test(this.produto.nome)) {
      this.produto.nome = "";
      this._msgErroN = "Dado inválido";
    }
    else {
      this._msgErroN = null;
    }

    if (this.produto.nome != "" && this.produto.linkFoto != "" && this.produto.detalhes != "" && this.produto.categoria != "Selecione" && this.produto.tamanho != "Selecione" && this.produto.classificacao != "Selecione" && this.produto.condicao) {
      this.srv.inserirp(this.produto).subscribe((res) => {
        this._msgEnviar = "Dados enviados com SUCESSO!!";
        this.produto.nome = "";
        this.produto.linkFoto = "";
        this.produto.detalhes = "";
        this.produto.tamanho = "Selecione";
        this.produto.categoria = "Selecione";
        this.produto.classificacao = "Selecione";
        this.produto.condicao = "Selecione";
        this.router.navigate(['/produto']);
      },
        (error) => {
          this._msgErro = "Erro ao enviar dados!!";
          this.produto.nome = "";
          this.produto.linkFoto = "";
          this.produto.detalhes = "";
          this.produto.tamanho = "Selecione";
          this.produto.categoria = "Selecione";
          this.produto.classificacao = "Selecione";
          this.produto.condicao = "Selecione";
        })
    }
  }

  limpaEnviar() {
    this._msgEnviar = null;
    this._msgErro = null;
  }
}
