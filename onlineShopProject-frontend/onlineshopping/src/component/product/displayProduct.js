import axios from "axios";
import {useEffect, useState} from "react";
import Products from "./Products";
import Footer from "../shared/Footer";


export default function DisplayProduct() {
    const [data,setData]=useState([]);
    useEffect( () => {
        (async function getData() {
            const result = await axios.get("http://localhost:8084/product");
            const newData= result.data;
            console.log("newData", newData)
            setData(newData);
        })();
},[])

    console.log("My data is ", data);
    return(
        <div>

            <div><h1>Products</h1></div>
            <Products products ={data} />
            <Footer/>
        </div>
    )

}