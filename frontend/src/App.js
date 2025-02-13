import React from 'react';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import './App.css';
import { AuthProvider } from './account/Authentication';
import { RequiredAuthenticationAdmin } from './account/RequiredAuthenticationAdmin';
import { RequiredAuthentication } from './account/RequiredAuthentication';
import Login from './account/Login';
import Dashboard from './account/Dashboard';
import VendorLogin from './pages/VendorLogin';
import VendorDashboard from './pages/VendorDashboard';
import { FilterData } from './component/FilterData';
import ProductEdit from './pages/ProductEdit';
import OrderList from './pages/OrderList';
import ProductList from './pages/ProductList';
import AddProduct from './pages/AddProduct';

function App() {
  const { allCategory, allSubCategory, discountProduct, allActiveProducts, allProducts } = FilterData();
 
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/admin/login" element={<Login />} />
          <Route path="/vendor/login" element={<VendorLogin />} />
          <Route path="/product/:id/edit" element={<ProductEdit />} />
          <Route path="/order/list" element={<OrderList />} />
          <Route path="/product/list" element={<ProductList />} />
          <Route path="/product/add" element={<AddProduct />} />
          
          <Route 
            path="/admin/dashboard" 
            element={
              <RequiredAuthenticationAdmin>
                <Dashboard />
              </RequiredAuthenticationAdmin>
            } 
          />
          <Route 
            path="/vendor/dashboard" 
            element={
              <RequiredAuthentication>
                <VendorDashboard />
              </RequiredAuthentication>
            } 
          />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}

export default App;
