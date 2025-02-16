import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { axiosInstance } from "../axiosInstance";
import { FilterData } from "../components/FilterData";

export default function VendorDashboard() {
    const [product, setProduct] = useState({
        name: "",
        price: "",
        discount: "",
        description: "",
        status: "INACTIVE",
        stock: "AVAILABLE", 
        color: "RED",
        size: "S",
        parentCategory: {
            id: ""
        },
        childCategory: {
            id: ""
        }
    });

    const { allCategory, allSubCategory } = FilterData();

    const handleChange = (e) => {
        const { name, value } = e.target;
        const parsedValue = Number(value); // Convert to number

        if (name === "parentCategory") {
            setProduct((prev) => ({
                ...prev,
                parentCategory: { ...prev.parentCategory, id: parsedValue }
            }));
        } else if (name === "childCategory") {
            setProduct((prev) => ({
                ...prev,
                childCategory: { ...prev.childCategory, id: parsedValue }
            }));
        } else if (name === "price" || name === "discount") {
            setProduct((prev) => ({
                ...prev,
                [name]: Number(value)
            }));
        } else {
            setProduct((prev) => ({
                ...prev,
                [name]: value
            }));
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(product);
        
        try {
            const response = await axiosInstance.post("/products", product);
            console.log("Product added:", response.data);
            alert("Product added successfully!");
        } catch (error) {
            console.error("Error adding product:", error);
            alert("Failed to add product. Please try again.");
        }
    };

    return (
        <div className="flex h-screen">
            <div className="border rounded-lg basis-1/6 bg-blue-900 text-white justify-center p-3 text-center space-y-3">
                <div>
                    <Link className="p-2 font-semibold" to="/product/add">Add Product</Link>
                </div>
                <div>
                    <Link className="p-2 font-semibold" to="/product/list">Product List</Link>
                </div>
                <div>
                    <Link className="p-2 font-semibold" to="/order/list">Order List</Link>
                </div>
            </div>

            <div className="border-2 basis-5/6 flex justify-center items-center">
                <div className="bg-white p-6 rounded-lg shadow-lg w-1/3">
                    <h2 className="text-xl font-bold mb-4 text-center">Add Product</h2>
                    <form onSubmit={handleSubmit} className="space-y-3">
                        <input type="text" name="name" placeholder="Product Name" value={product.name} onChange={handleChange} className="border p-2 w-full" required />
                        <input type="number" name="price" placeholder="Price" value={product.price} onChange={handleChange} className="border p-2 w-full" required />
                        <input type="number" name="discount" placeholder="Discount" value={product.discount} onChange={handleChange} className="border p-2 w-full" />
                        <textarea name="description" placeholder="Description" value={product.description} onChange={handleChange} className="border p-2 w-full resize-none" required />
                        
                        <select name="parentCategory" value={product.parentCategory.id} onChange={handleChange} className="border p-2 w-full" required>
                            <option value="">Select Category</option>
                            {allCategory.map((category) => (
                                <option key={category.id} value={category.id}>
                                    {category.name}
                                </option>
                            ))}
                        </select>

                        <select name="childCategory" value={product.childCategory.id} onChange={handleChange} className="border p-2 w-full" required>
                            <option value="">Select Subcategory</option>
                            {allSubCategory.map((category) => (
                                <option key={category.id} value={category.id}>
                                    {category.name}
                                </option>
                            ))}
                        </select>
                        <select name="color" value={product.color} onChange={handleChange} className="border p-2 w-full">
                            <option value="RED">Red</option>
                            <option value="BLACK">Black</option>
                            <option value="WHITE">White</option>
                        </select>
                        <select name="size" value={product.size} onChange={handleChange} className="border p-2 w-full">
                            <option value="S">S</option>
                            <option value="M">M</option>
                            <option value="XL">XL</option>
                        </select>
                        <button type="submit" className="bg-blue-500 text-white p-2 w-full rounded">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    );
}