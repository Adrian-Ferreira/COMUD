import { Component, OnInit } from '@angular/core';
import { ONG } from 'src/app/model/ONG';
import { ActivatedRoute, Router } from '@angular/router';
import { WebListServiceService } from 'src/app/service/web-list-service.service';

@Component({
  selector: 'app-edita-ong',
  templateUrl: './edita-ong.component.html',
  styleUrls: ['./edita-ong.component.css']
})
export class EditaOngComponent implements OnInit {

  ong: ONG = new ONG;

  id: number;

  constructor(private rota: ActivatedRoute, private srv: WebListServiceService, private router: Router) { }

  ngOnInit() {
    this.id = this.rota.snapshot.params["id"];

    this.srv.consulta(this.id).subscribe((res: ONG) => {
      this.ong = res;

    });
  }

  encerrar() {
    this.router.navigate(['/consultaongs']);
  }

}
