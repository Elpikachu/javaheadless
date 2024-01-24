import React from "react";
import { Link } from 'react-router-dom';
import '../styles/Header.css'

const Header = () => {
    return (
        <header className="header-container">
            <Link to="/" className="logo-container">
                <img src="/images/redcontainer.jpg" alt="Ronald Mclogo" className="logo" />
                <span className="logo-text">Headless application demo</span>
            </Link>
        </header>
    );
};

export default Header;