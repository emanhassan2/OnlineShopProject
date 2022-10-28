import logo from './logo.svg';
import './App.css';
import {useEffect} from "react";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";


import DisplayProduct from "./component/product/displayProduct";
import Products from "./component/product/Products";
import Login from "./component/login/Login";
import {Route, Routes} from "react-router-dom";
import ShoppingCart from "./component/ShoppingCart/ShoppingCart";



function App() {
  useEffect( () => {
    axios.get("http://localhost:8084/hello", { headers: { Authorization: "Basic UmVkaWV0OnRlc3QxMjM0"}}).then(response => console.log(response)).catch(error => console.log(error));
  })

  return (
    <div className="App">

    {/*<Login/>*/}
     {/*<DisplayProduct/>*/}
      <Routes>
        <Route path="/" element={<Login/>}></Route>
        <Route path="/product" element={<DisplayProduct/>}></Route>
        <Route path="/shoppingCart" element={<ShoppingCart/>}></Route>
      </Routes>

    </div>
  );
}

export default App;
/*
return (
    <>
      <NavBar />
      <Routes>
        <Route path='/' element={<Home />}>
          <Route path='/services' element={<Services />}></Route>
          <Route path='/featuredrooms' element={<FeaturedRooms />}></Route>
        </Route>
        <Route path='/rooms/' element={<AllRooms />}></Route>
        <Route path='/rooms/:slug' element={<RoomDetails />}></Route>
        <Route path='/contact' element={<ContactUs />}></Route>
        <Route path='/login' element={<SignInUp />}></Route>
        <Route extract path='*' element={<PageNotFound />}></Route>
      </Routes>
      <Subscribe />
    </>
* */
