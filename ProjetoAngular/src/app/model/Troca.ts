import { Produto } from './Produto';
import { Usuario } from './Usuario';

export class Troca{
    idTroca:number;
    dataT:string;
    cedido:Produto=new Produto;
    recebido:Produto=new Produto;
    remetente:Usuario=new Usuario;
    destinatario:Usuario=new Usuario;
}