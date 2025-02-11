import React from 'react';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import './App.css';
import { AuthProvider } from './account/Authentication';
import { RequiredAuthenticationAdmin } from './account/RequiredAuthenticationAdmin';
import Login from './account/Login';
import Dashboard from './account/Dashboard';

function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/admin/login" element={<Login />} />
          <Route 
            path="/" 
            element={
              <RequiredAuthenticationAdmin>
                <Dashboard />
              </RequiredAuthenticationAdmin>
            } 
          />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}

export default App;
