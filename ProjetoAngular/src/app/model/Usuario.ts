import { Produto } from './Produto';
import { Doacao } from './Doacao';
import { Troca } from './Troca';

export class Usuario{
    idUsuario: number;
    nome: string;
    email: string;
    telefone: string;
    endereco:string;
    senha: string;
    confSenha: string;
    produto:Produto[];
    doacao:Doacao[];
    troca:Troca[];
}