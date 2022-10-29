export default function ImageRendering (props){


    const image = props.image;
    return(
        <div>
            <img
                // className="img1"
                    src={image.url}
                    alt="Property1"
                    width="300"
                    height="400"
                />
        </div>
    )
}