//import './App.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './structure/Header';
import Footer from './structure/Footer';
import Blog from './Blog';
import Content from './Content';



function App() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/" element={<Blog />} />
        <Route path="/content/:id" element={<Content />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;