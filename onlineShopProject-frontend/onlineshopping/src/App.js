import logo from './logo.svg';
import './App.css';
import {useEffect} from "react";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";


import DisplayProduct from "./component/product/displayProduct";
import Products from "./component/product/Products";
import Login from "./component/login/Login";


function App() {
  useEffect( () => {
    axios.get("http://localhost:8084/hello", { headers: { Authorization: "Basic UmVkaWV0OnRlc3QxMjM0"}}).then(response => console.log(response)).catch(error => console.log(error));
  })

  return (
    <div className="App">
    <Login/>
     <DisplayProduct/>

    </div>
  );
}

export default App;
