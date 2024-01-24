import React, {useState, useEffect} from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './styles/Blog.css';

const endpoint = "/api/content/all";
const reqUrl = `${process.env.REACT_APP_API_URL}${endpoint}`;

const Blog = () => {
    const [content, setContent] = useState([]);

    useEffect(() => {
        const fetchContent = async () => {
            try {
                const response = await axios.get(reqUrl);
                setContent(response.data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchContent();
    }, []);

    return (
        <div className="blog-container">
            <main className="content-grid">
                {content.map(item => (
                        <div className="content-item" key={item.contentid}>
                            {item.contentImglink && (
                                <img
                                    src={`${process.env.REACT_APP_API_URL}/api/images/${item.contentImglink}`}
                                    alt={item.contenttitle}
                                    className="content-image"
                                />
                            )}
                            <h2>
                                <Link to={`/content/${item.contentid}`}> 
                                {item.contenttitle}
                                </Link>
                            </h2>
                            <p>{item.contentSummary}</p>
                            <p>
                                <strong>By:</strong> {item.writername}
                            </p>
                        </div>
                ))}
            </main>
        </div>
    );
};

export default Blog;