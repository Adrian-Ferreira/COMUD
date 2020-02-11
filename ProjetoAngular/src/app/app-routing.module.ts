import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {SobreComponent} from './sobre/sobre.component';
import {HomeComponent}  from './home/home.component';
import {FaleconoscoComponent} from './faleconosco/faleconosco.component';
import {ProdutoComponent} from './produto/produto.component';
import {LoginComponent} from './login/login.component';
import { ConsultaUsuariosComponent } from './login/consulta-usuarios/consulta-usuarios.component';
import { EditaUsuarioComponent } from './login/edita-usuario/edita-usuario.component';
import { FaqComponent } from './faq/faq.component';
import { EditaProdutoComponent } from './produto/edita-produto/edita-produto.component';
import { CadProdutoComponent } from './produto/cad-produto/cad-produto.component';
import { CadOngComponent } from './login/cad-ong/cad-ong.component';
import { TrocasComponent } from './trocas/trocas.component';
import { DoacaoComponent } from './doacao/doacao.component';
import { EditaOngComponent } from './login/edita-ong/edita-ong.component';

const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'sobre',component:SobreComponent},
  {path:'home',component:HomeComponent},
  {path:'contatos',component:FaleconoscoComponent},
  {path: 'produto', component:ProdutoComponent},
  {path:'login', component:LoginComponent},
  {path: 'consultaongs', component:ConsultaUsuariosComponent},
  {path: 'editausuario/:id', component:EditaUsuarioComponent},
  {path: 'consultaong/:id', component:EditaOngComponent},
  {path: 'faq', component:FaqComponent},
  {path: 'editaproduto/:id', component:EditaProdutoComponent},
  {path: 'cadastroproduto', component: CadProdutoComponent},
  {path: 'cadastroong', component: CadOngComponent},
  {path: 'cestadetrocas', component: TrocasComponent},
  {path: 'cestadedoacao', component: DoacaoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
