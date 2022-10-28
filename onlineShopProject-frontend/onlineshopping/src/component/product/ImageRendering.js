export default function ImageRendering (props){


    const image = props.image;
    return(
        <div>
            <img

                    // className="img1"
                    src={image.url}
                    alt="Property1"
                    width="280"
                    height="170"
                />
        </div>
    )
}