import ImageRendering from "./ImageRendering";
import Footer from "../shared/Footer";

export default function Product (props) {
    const value = props.product;

    console.log("Images are", value)

    return(
        <div>
            <div>Name: {value.name}</div>
            <div>Category: {value.category}</div>
            <div>Image:
                 {value.images.map((i,index) =>
             <ImageRendering key={index} image={i}/>
             )}
            </div>

            <div>
                <br/>
            </div>

        </div>
    )
}
