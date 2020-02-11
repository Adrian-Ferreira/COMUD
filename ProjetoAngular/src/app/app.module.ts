import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SobreComponent } from './sobre/sobre.component';
import { ContatosComponent } from './faleconosco/contatos/contatos.component';
import { FooterComponent } from './footer/footer.component';
import { EquipeComponent } from './sobre/equipe/equipe.component';
import { TitleComponent } from './sobre/title/title.component';
import { ValueComponent } from './sobre/value/value.component';
import { FormsModule } from '@angular/forms';
import { FaleconoscoComponent } from './faleconosco/faleconosco.component';
import { InfosComponent } from './faleconosco/infos/infos.component';
import { HomeComponent } from './home/home.component';
import { ProdutoComponent } from './produto/produto.component';
import { LoginComponent } from './login/login.component';
import { FormLoginComponent } from './login/form-login/form-login.component';
import { TituloComponent } from './login/titulo/titulo.component';
import { ModalCadComponent } from './login/modal-cad/modal-cad.component';
import { ConsultaUsuariosComponent } from './login/consulta-usuarios/consulta-usuarios.component';
import { EditaUsuarioComponent } from './login/edita-usuario/edita-usuario.component';
import { FaqComponent } from './faq/faq.component';
import { FormFaqComponent } from './faq/form-faq/form-faq.component';
import { CadProdutoComponent } from './produto/cad-produto/cad-produto.component';
import { EditaProdutoComponent } from './produto/edita-produto/edita-produto.component';
import { CadOngComponent } from './login/cad-ong/cad-ong.component';
import { TrocasComponent } from './trocas/trocas.component';
import { DoacaoComponent } from './doacao/doacao.component';
import { InfoCardComponent } from './home/info-card/info-card.component';
import { EditaOngComponent } from './login/edita-ong/edita-ong.component';
import { CarrosselComponent } from './home/carrossel/carrossel.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SobreComponent,
    ContatosComponent,
    FooterComponent,
    EquipeComponent,
    TitleComponent,
    ValueComponent,
    FaleconoscoComponent,
    InfosComponent,
    HomeComponent,
    ProdutoComponent,
    LoginComponent,
    FormLoginComponent,
    TituloComponent,
    ModalCadComponent,
    ConsultaUsuariosComponent,
    EditaUsuarioComponent,
    FaqComponent,
    FormFaqComponent,
    CadProdutoComponent,
    EditaProdutoComponent,
    CadOngComponent,
    TrocasComponent,
    DoacaoComponent,
    InfoCardComponent,
    EditaOngComponent,
    CarrosselComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
