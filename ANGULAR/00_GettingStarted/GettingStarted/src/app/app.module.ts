import { NgModule } from '@angular/core';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatInputModule} from '@angular/material/input';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { ProductListComponent } from './product-list/product-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProductAlertsComponent } from './product-alerts/product-alerts.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CartComponent } from './cart/cart.component';
import { ShippingComponent } from './shipping/shipping.component';
import { BooksComponent } from './books/books.component';
import { CustomerComponent } from './customer/customer.component';
import { BookListComponent } from './book-list/book-list.component';
import { HomeComponent } from './home/home.component';
import { SearchBookComponent } from './search-book/search-book.component';
import { BookCardsListComponent } from './book-cards-list/book-cards-list.component';
import { BookTilesListComponent } from './book-tiles-list/book-tiles-list.component';

@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      // Root route
      { path: '', component: HomeComponent },
      // Product route
      { path: 'products/:productId', component: ProductDetailsComponent },
      // Cart route
      { path: 'cart', component: CartComponent },
      // Shipping route
      { path: 'shipping', component: ShippingComponent },
      // Books list route
      { path: 'books', component: BookListComponent },
      // Customer route
      { path: 'customers', component: CustomerComponent }
    ]),
    BrowserAnimationsModule,
    MatCardModule,
    MatGridListModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatInputModule
  ],
  declarations: [
    AppComponent,
    TopBarComponent,
    ProductListComponent,
    ProductAlertsComponent,
    ProductDetailsComponent,
    CartComponent,
    ShippingComponent,
    BooksComponent,
    CustomerComponent,
    BookListComponent,
    HomeComponent,
    SearchBookComponent,
    BookCardsListComponent,
    BookTilesListComponent
  ],
  bootstrap: [
    AppComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule { }
