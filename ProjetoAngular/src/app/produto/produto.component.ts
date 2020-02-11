import { Component, OnInit } from '@angular/core';
import { WebListServiceService } from '../service/web-list-service.service';
import { Produto } from '../model/Produto';
import { GlobalsProduto } from '../model/GlobalsProduto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})


export class ProdutoComponent implements OnInit {

  idbusca: number;
  idproduto: Produto[];
  _idproduto: Produto;
  prodModal: Produto = new Produto();
  lista: boolean;
  _msgErro: string = null;
  id: number;
  palavraChave: String;

  constructor(private produtoBusca: WebListServiceService, private router: Router) { }

  ngOnInit() {
    this.pesquisarTodos();
  }

  atribuiModal(id: number) {
    this.produtoBusca.buscaDetProd(id).subscribe(
      (res: Produto) => {
        this.prodModal = res
      }
    );
  }
  public CompartilhaDados() {
    this.produtoBusca.buscaDetProd(this.id).subscribe(
      (res: Produto) => {
        GlobalsProduto.produto = res;
        this.router.navigate(['modalproduto']);
      },
    )
  }

  public pesquisarTodos() {
    this._msgErro = "";
    this.lista = true
    this.produtoBusca.obterLista().subscribe((resultado: Produto[]) => {
      this.idproduto = resultado
      this.idbusca = null;
    })
  }

  public pesquisar() {
    if (this.palavraChave == null) {
      this._msgErro = "";
      this.lista = true
      this.produtoBusca.obterLista().subscribe((resultado: Produto[]) => {
        this.idproduto = resultado
        this.idbusca = null;
      })
    }
    else {
      this.produtoBusca.buscaPalavraChave(this.palavraChave).subscribe((res: Produto[]) => {
        this.idproduto = res;
        this.palavraChave = null;
      });
    }
  }
}