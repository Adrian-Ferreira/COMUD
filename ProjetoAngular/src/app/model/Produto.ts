import { Usuario } from './Usuario';

export class Produto{
    idProduto: number;
    nome: String;
    linkFoto: String;
    detalhes: String;
    categoria: String = "Selecione";
    classificacao: String = "Selecione";
    condicao: String = "Selecione";
    tamanho: String = "Selecione";
    status:String = "DISPONÍVEL";
    usuario:Usuario;
}