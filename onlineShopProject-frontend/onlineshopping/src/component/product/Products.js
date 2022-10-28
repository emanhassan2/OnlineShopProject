import Product from "./Product";

export default function Products(props) {
    const products = props.products;
    return(
            <div >
                <h3 style={{backgroundColor: "#EA2027", opacity: 0.7,textAlign: "left",padding:"9px",borderRadius: "5px",color:"white",fontSize: "17px"}}></h3>

                <div>
                    <div>
                        {products.map((i) =>
                            <Product product={i}/>)}
                        <br/>

                    </div>

                </div>
            </div>

    )
}