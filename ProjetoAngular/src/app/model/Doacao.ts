import { Usuario } from './Usuario';
import { Produto } from './Produto';
import { ONG } from './ONG';

export class Doacao {
    iddoacao: number;
    dataD: string;
    usuario: Usuario = new Usuario;
    produto: Produto = new Produto;
    ong: ONG = new ONG;
}