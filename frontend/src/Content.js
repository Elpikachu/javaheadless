import React, {useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import './styles/Content.css'

const endpoint = "api/content/getbyid/";
const reqUrl = `${localStorage.getItem('apiURL')}${endpoint}`;

const Content = () => {
    const { id } = useParams();
    const [content, setContent ] = useState(null);

    useEffect(() => {
        const fetchContent = async() => {
            try {
                const response = await axios.get(`${reqUrl}${id}`);
                setContent(response.data);
            } catch (error) {
                console.error('Error fetching article:', error);
            }
        };

        fetchContent();
    }, [id, reqUrl]);

    if (!content) {
        return <div>Loading … </div>;
    }

    return (
        <div className="content-container">
            <div className='content-header'>
                <h1 className="content-title">{content.contenttitle}</h1>
                {content.contentImglink && <img src={`${localStorage.getItem('apiURL')}api/images/${content.contentImglink}`} alt="Content" className="contentimg" />}
            </div>

            <div className='content-main'>
                <p className="content-contentArticle">{content.contentArticle}</p>
                <p className='writer-info'>
                    <strong>Writer:</strong> {content.writername}
                 </p>
                <p>
                    <strong>Date Created:</strong> {content.contentDatecreate}
                </p>
                <p>
                    <strong>Category:</strong> {content.contentCategory}
                </p>
            </div>
        </div>
    );
};

export default Content;