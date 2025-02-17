import { useEffect, useState } from 'react';
import { axiosInstance } from '../axiosInstance';

function FilterData() {
  const [allCategory, setAllCategory] = useState([]);
  const [discountProduct, setDiscountProduct] = useState([]);
  const [allActiveProducts, setAllActiveProducts] = useState([]);
  const [allInactiveProducts, setAllInactiveProducts] = useState([]);
  const [allProducts, setAllProducts] = useState([]);
  const [allSubCategory, setAllSubCategory] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const resData = (await axiosInstance.get('/products/all')).data;
        
        

        setAllCategory(resData);

        const childCategories = resData.flatMap(category => category.childCategory);
        

        const allProductsArray = [
          ...childCategories.flatMap(subcategory => subcategory.products)
        ]

        const discountProducts = allProductsArray.filter(x => x.discount !== null && x.status === "ACTIVE");
        const activeProducts = allProductsArray.filter(x => x.status === "ACTIVE");
        const inActiveProducts = allProductsArray.filter(x => x.status === "INACTIVE");

        setAllSubCategory(childCategories);
        setDiscountProduct(discountProducts);
        setAllActiveProducts(activeProducts);
        setAllInactiveProducts(inActiveProducts)
        setAllProducts(allProductsArray);

      } catch (error) {
        console.error("Error fetching data", error);
      }
    };

    fetchData();
  }, []);

  

  return { allCategory, allSubCategory, discountProduct, allActiveProducts, allProducts, allInactiveProducts };
}

export { FilterData };
