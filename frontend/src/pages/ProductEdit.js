import React from "react"
import { useParams } from "react-router"

const ProductEdit = () => {

   const {id} = useParams();
   return (
      <div>
         ProductEdit {id}
      </div>
   )
}

export default ProductEdit