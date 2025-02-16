import React from "react"
import { Link } from "react-router";

const OrderList = () => {
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
                
            </div>
        </div>
    );
}

export default OrderList