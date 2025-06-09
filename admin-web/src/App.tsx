import React, {useState} from 'react';
import {BrowserRouter as Router, Navigate, Route, Routes} from 'react-router-dom';
import {ConfigProvider} from 'antd';
import zhCN from 'antd/locale/zh_CN';
import LoginPage from './components/LoginPage';
import AdminLayout from './components/AdminLayout';
import './App.css';

function App() {
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    const handleLogin = () => {
        setIsAuthenticated(true);
    };

    const handleLogout = () => {
        setIsAuthenticated(false);
    };

    return (
        <ConfigProvider locale={zhCN}>
            <Router>
                <div className="App">
                    <Routes>
                        <Route
                            path="/login"
                            element={
                                isAuthenticated ?
                                    <Navigate to="/admin\" replace/> :
                                    <LoginPage onLogin={handleLogin}/>
                            }
                        />
                        <Route
                            path="/admin/*"
                            element={
                                isAuthenticated ?
                                    <AdminLayout onLogout={handleLogout}/> :
                                    <Navigate to="/login" replace/>
                            }
                        />
                        <Route
                            path="/"
                            element={<Navigate to={isAuthenticated ? "/admin" : "/login"} replace/>}
                        />
                    </Routes>
                </div>
            </Router>
        </ConfigProvider>
    );
}

export default App;