import Product from "./Product";

export default function Products(props) {
    const products = props.products;
    return(
            <div >
                <h1 style={{backgroundColor: "gray", opacity: 0.7,textAlign: "left",padding:"15px",borderRadius: "5px", border:"2px",borderColor:"black", fontSize: "17px"}}></h1>

                <div>
                    <br/>
                    <div style={{display:"flex", flexDirection:"row", flexWrap:"wrap" ,justifyContent:"space-evenly", marginLeft:"2%", marginRight:"2%"}}>
                        {products.map((i) =>
                            <Product product={i}/>)}
                        <br/>

                    </div>

                </div>
            </div>

    )
}