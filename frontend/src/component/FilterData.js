import { useEffect, useState } from 'react';
import { axiosInstance } from '../axiosInstance';

function FilterData() {
  const [allCategory, setAllCategory] = useState([]);
  const [discountProduct, setDiscountProduct] = useState([]);
  const [allActiveProducts, setAllActiveProducts] = useState([]);
  const [allProducts, setAllProducts] = useState([]);
  const [allSubCategory, setAllSubCategory] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const resData = (await axiosInstance.get('/products/all')).data;
        console.log(resData);
        

        setAllCategory(resData);

        // Extract subcategories
        const childCategories = resData.flatMap(category => category.childCategory || []);

        // Extract products
        const allProductsArray = resData.flatMap(category => [
          ...(category.product || []),
          ...childCategories.flatMap(subcategory => subcategory.products || [])
        ]);

        // Filter products
        const discountProducts = allProductsArray.filter(x => x.discount !== null && x.status === "ACTIVE");
        const activeProducts = allProductsArray.filter(x => x.status === "ACTIVE");

        // Set state
        setAllSubCategory(childCategories);
        setDiscountProduct(discountProducts);
        setAllActiveProducts(activeProducts);
        setAllProducts(allProductsArray);

      } catch (error) {
        console.error("Error fetching data", error);
      }
    };

    fetchData();
  }, []);

  return { allCategory, allSubCategory, discountProduct, allActiveProducts, allProducts };
}

export { FilterData };
