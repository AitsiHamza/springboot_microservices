import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersComponent } from './components/customers/customers.component';
import {HomeComponent} from "./components/home/home.component";
import { ProductsComponent } from './components/products/products.component';
import {OrdersComponent} from "./components/orders/orders.component";
import { OrderDetailsComponent } from './components/order-details/order-details.component';

const routes: Routes = [
  {path:"home",component: HomeComponent},
  {path:"products",component: ProductsComponent},
  {path:"customers",component: CustomersComponent},
  {path:"orders/:customerId",component: OrdersComponent},
  {path:"order-details/:orderId",component: OrderDetailsComponent},
  {
    path: "**",redirectTo: "home"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
