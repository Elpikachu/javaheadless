//import './App.css';
import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './structure/Header';
import Footer from './structure/Footer';
import Blog from './Blog';
import Content from './Content';

async function fetchJson(url) {
    const response = await fetch(url);
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    const json = await response.json();
    return json;
}

function App() {
  const [data, setData] = useState(JSON.parse(localStorage.getItem('myData')));

  useEffect(() => {
      const fetchData = async () => {
          if (!data) {
              try {
                  const fetchedData = await fetchJson('jsonconf/routes.json');
                  setData(fetchedData);
                  localStorage.setItem('myData', JSON.stringify(fetchedData));
              } catch (error) {
                  console.error(error);
              }
          }
      };

      fetchData();
  }, [data]); // Effect depends on the 'data' state

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