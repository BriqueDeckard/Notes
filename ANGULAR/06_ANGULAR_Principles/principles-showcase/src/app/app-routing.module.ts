import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisplayAListComponent } from './display-a-list/display-a-list.component';
import { EditAnObjectComponent } from './edit-an-object/edit-an-object.component';
import { GetObjectAsyncComponent } from './get-object-async/get-object-async.component';
import { HomeComponent } from './home/home.component';
import { ObjectDetailsComponent } from './object-details/object-details.component';
import { ShowAnObjectComponent } from './show-an-object/show-an-object.component';
import { ViewingDetailsComponent } from './viewing-details/viewing-details.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'show-object', component: ShowAnObjectComponent },
  { path: 'edit-object', component: EditAnObjectComponent },
  { path: 'display-list', component: DisplayAListComponent },
  { path: 'get-object-async', component: GetObjectAsyncComponent },
  { path: 'viewing-details', component: ViewingDetailsComponent },
  { path: 'detail/:id', component: ObjectDetailsComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
