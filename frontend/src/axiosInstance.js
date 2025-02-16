import axios from "axios";

const axiosInstance = axios.create({
    baseURL: "http://localhost:8080",
    headers: {
        'Content-Type': 'application/json',
    },
    //baseURL: "http://192.168.0.139"
})

export {axiosInstance}