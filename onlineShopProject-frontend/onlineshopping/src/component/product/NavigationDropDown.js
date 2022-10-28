import { MDBDropdown, MDBDropdownMenu, MDBDropdownToggle, MDBDropdownItem } from 'mdb-react-ui-kit';

export default function NavigationDropDown() {
    return(
        <div>
            <div className="d-flex justify-content-center">
                <div className="p-2"><div>
                    <MDBDropdown>
                        <MDBDropdownToggle tag='a' className='btn btn-light'>
                            WOMEN
                        </MDBDropdownToggle>
                        <MDBDropdownMenu>
                            <MDBDropdownItem link>Tops</MDBDropdownItem>
                            <MDBDropdownItem link>Sweaters</MDBDropdownItem>
                            <MDBDropdownItem link>Jumpsuits & Rompers</MDBDropdownItem>
                            <MDBDropdownItem link>Matching Sets</MDBDropdownItem>
                            <MDBDropdownItem link>Jackets &Coats</MDBDropdownItem>
                        </MDBDropdownMenu>
                    </MDBDropdown>
                    <br/>

                </div></div>
                <div className="p-2"> <div>
                    <MDBDropdown>
                        <MDBDropdownToggle tag='a' className='btn btn-light'>
                            MEN
                        </MDBDropdownToggle>
                        <MDBDropdownMenu>
                            <MDBDropdownItem link>Button Down Shirts</MDBDropdownItem>
                            <MDBDropdownItem link>Topcoats</MDBDropdownItem>
                            <MDBDropdownItem link>Merino Sweaters</MDBDropdownItem>
                            <MDBDropdownItem link>Tuxedo Shop</MDBDropdownItem>
                            <MDBDropdownItem link>SuitJackets $ Blazers</MDBDropdownItem>
                        </MDBDropdownMenu>
                    </MDBDropdown>
                    <br/>

                </div></div>
                <div className="p-2"><div>
                    <MDBDropdown>
                        <MDBDropdownToggle tag='a' className='btn btn-light'>
                            JEANS
                        </MDBDropdownToggle>
                        <MDBDropdownMenu>
                            <MDBDropdownItem link>All Women's Jeans</MDBDropdownItem>
                            <MDBDropdownItem link>Supersoft Jeans</MDBDropdownItem>
                            <MDBDropdownItem link>Skyscraper Jeans</MDBDropdownItem>
                            <MDBDropdownItem link>Straight Leg Jeans</MDBDropdownItem>
                            <MDBDropdownItem link>Baggy Jeans</MDBDropdownItem>
                        </MDBDropdownMenu>
                    </MDBDropdown>
                    <br/>

                </div>
                </div>
                <div className="p-2"><div>
                    <MDBDropdown>
                        <MDBDropdownToggle tag='a' className='btn btn-light'>
                            NEW
                        </MDBDropdownToggle>
                        <MDBDropdownMenu>
                            <MDBDropdownItem link>Action</MDBDropdownItem>
                            <MDBDropdownItem link>Another action</MDBDropdownItem>
                            <MDBDropdownItem link>Something else here</MDBDropdownItem>
                            <MDBDropdownItem link>Something else here</MDBDropdownItem>
                            <MDBDropdownItem link>Something else here</MDBDropdownItem>
                        </MDBDropdownMenu>
                    </MDBDropdown>
                    <br/>

                </div></div>
                <div className="p-2"><div>
                    <MDBDropdown>
                        <MDBDropdownToggle tag='a' className='btn btn-light'>
                            GIFTS
                        </MDBDropdownToggle>
                        <MDBDropdownMenu>
                            <MDBDropdownItem link>Action</MDBDropdownItem>
                            <MDBDropdownItem link>Another action</MDBDropdownItem>
                            <MDBDropdownItem link>Something else here</MDBDropdownItem>
                            <MDBDropdownItem link>Something else here</MDBDropdownItem>
                            <MDBDropdownItem link>Something else here</MDBDropdownItem>
                        </MDBDropdownMenu>
                    </MDBDropdown>
                    <br/>

                </div></div>
                <div className="p-2"><div>
                    <MDBDropdown>
                        <MDBDropdownToggle tag='a' className='btn btn-light'>
                            STYLE TRIAL RENTAL
                        </MDBDropdownToggle>
                        <MDBDropdownMenu>
                            <MDBDropdownItem link>Women Style Trial</MDBDropdownItem>
                            <MDBDropdownItem link>Women Style Trial</MDBDropdownItem>
                            <MDBDropdownItem link>How it work</MDBDropdownItem>
                            <MDBDropdownItem link>Something else here</MDBDropdownItem>
                            <MDBDropdownItem link>Something else here</MDBDropdownItem>
                        </MDBDropdownMenu>
                    </MDBDropdown>
                    <br/>

                </div></div>
            </div>



        </div>
    )
}