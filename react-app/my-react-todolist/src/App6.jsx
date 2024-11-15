import { useState } from 'react';
import './App.css';

function App() {
  
  const [name, setName] = useState('布丁');
  const [price, setPrice] = useState('15');

  const [product, setProduct] = useState([
    {id: 1, name: '麵包', price: '15'},
    {id: 2, name: '水果', price: '50'},
    {id: 3, name: '牛奶', price: '100'},
  ]);

  const showName = (e) => {
    setName(e.target.value);
  };

  const showPrice = (e) => {
    setPrice(e.target.value);
  };

  const totalAmount = product.reduce((total, product) => {
    return total + parseInt(product.price);
  }, 0);

  const handleClick = (e) => {
    if(!name || !price) return;
    
    const newId = product.length > 0 ? Math.max(...product.map((t) => t.id)) + 1 : 1;

    const newProduct = {
      id: newId, name: name, price: price
    };

    setProduct([...product, newProduct]);
    setName('');
    setPrice('');
  };

  const handleDelete = (id) => {
    // 過濾掉 id 匹配的商品
    setProduct(product.filter((p) => p.id !== id));
  };

  return (
    <>
      <h1>Shopping Cart</h1>

      <div>
        <input type="text" onChange={showName} value={name} />
        <input type="text" onChange={showPrice} value={price} />
        <button onClick={handleClick}>新增商品</button>
      </div>

      <ul>
        {
          product.map((product, index) => {
            return (
              <li key={product.id}>
                商品名稱: {product.name} 價格: {product.price}
                <button onClick={() => handleDelete(product.id)}>刪除商品</button>
              </li>
            );
          })
        }
      </ul>

      <div>
        總金額 = {totalAmount}
      </div>
    

    </>
  );
}

export default App;