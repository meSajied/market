import React, { useEffect, useState } from "react";
import { Link } from "react-router";
import { axiosInstance } from "../axiosInstance";
import { useAuth } from "../account/Authentication";

const ProductList = () => {
  const { user } = useAuth();
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axiosInstance.get(`/vendor/${user.id}/products`);
        setProducts(response.data);
      } catch (error) {
        console.error("Error fetching products:", error);
      }
    };

    fetchProducts();
  }, [user.id]);

  return (
    <div className="flex h-screen">
      <div className="border rounded-lg basis-1/6 bg-blue-900 text-white justify-center p-3 text-center space-y-3">
        <div>
          <Link className="p-2 font-semibold" to="/vendor/product/add">
            Add Product
          </Link>
        </div>
        <div>
          <Link className="p-2 font-semibold" to="/vendor/product/list">
            Product List
          </Link>
        </div>
        <div>
          <Link className="p-2 font-semibold" to="/vendor/order/list">
            Order List
          </Link>
        </div>
      </div>

      <div className="border-2 basis-5/6 flex justify-center items-center p-4">
        <table className="min-w-full bg-white border border-gray-300">
          <thead>
            <tr>
              <th className="py-2 px-4 border-b">ID</th>
              <th className="py-2 px-4 border-b">Name</th>
              <th className="py-2 px-4 border-b">Price</th>
              <th className="py-2 px-4 border-b">Discount</th>
              <th className="py-2 px-4 border-b">Description</th>
              <th className="py-2 px-4 border-b">Status</th>
              <th className="py-2 px-4 border-b">Stock</th>
              <th className="py-2 px-4 border-b">Commission</th>
              <th className="py-2 px-4 border-b">Color</th>
              <th className="py-2 px-4 border-b">Size</th>
              <th className="py-2 px-4 border-b">Edit</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product) => (
              <tr key={product.id}>
                <td className="py-2 px-4 border-b">{product.id}</td>
                <td className="py-2 px-4 border-b">{product.name}</td>
                <td className="py-2 px-4 border-b">{product.price}</td>
                <td className="py-2 px-4 border-b">{product.discount}</td>
                <td className="py-2 px-4 border-b">{product.description}</td>
                <td className="py-2 px-4 border-b">{product.status}</td>
                <td className="py-2 px-4 border-b">{product.stock}</td>
                <td className="py-2 px-4 border-b">{product.comission}</td>
                <td className="py-2 px-4 border-b">{product.color}</td>
                <td className="py-2 px-4 border-b">{product.size}</td>
                <td className="py-2 px-4 border-b">
                  <Link to={`/product/${product.id}/edit`} className="p-1 border-2 border-red">Edit</Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ProductList;