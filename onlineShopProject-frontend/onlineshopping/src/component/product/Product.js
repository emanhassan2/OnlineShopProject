import ImageRendering from "./ImageRendering";
import Footer from "../shared/Footer";
import CartIcon from "./CartIcon";


export default function Product (props) {
    const value = props.product;

    console.log("Images are", value)

    return(
        <div>

            <div>
                 {value.images.map((i,index) =>
             <ImageRendering key={index} image={i}/>
             )}
            </div>
            <div style={{ fontWeight: 'bold' }}>Name: {value.name}</div>
            <div  >Category: {value.category}</div>
            <div style={{ color:"red" }} >Price: {value.price}$</div>
            {/*<div> Description: {value.description}</div>*/}
            {/*<i><CartIcon/></i>*/}

            <div>
                <br/>
            </div>

        </div>
    )
}
