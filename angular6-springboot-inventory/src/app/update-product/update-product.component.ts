import { Component, OnInit } from '@angular/core';
import { ProductService } from './../product.service';
import { Product } from './../product';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  id: number;
  product: Product;

  constructor(private productService: ProductService) { }

  ngOnInit() {
  	this.product = new Product();
    
  }
  
  updateProduct() {
    this.productService.updateProduct(this.id, this.product)
      .subscribe(data => console.log(data), error => console.log(error));
    this.product = new Product();
  }

  onSubmit() {
    this.updateProduct();    
  }

}
