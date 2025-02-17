import React, { useState, useEffect } from "react";
import { Link, Navigate } from "react-router-dom";
import { axiosInstance } from "../axiosInstance";
import { FilterData } from "../components/FilterData";

export default function VendorDashboard() {
    return <Navigate to="/vendor/product/list" />
}