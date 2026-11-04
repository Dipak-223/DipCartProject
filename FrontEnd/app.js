let cartCount = 0;

function addToCart() {
    cartCount++;

    document.getElementById("cartCount").innerText = cartCount;

    console.log("Cart count: " + cartCount);
}

// Product data
let products = [
    { id: 1, name: "Wireless Headphones", price: 999 },
    { id: 2, name: "Smart Watch", price: 1499 },
    { id: 3, name: "Keyboard", price: 799 },
    { id: 4, name: "Computer Mouse", price: 499 }
];

// Display products
let productList = document.getElementById("productList");

products.forEach(function(product) {

    productList.innerHTML += `
        <div class="product">
            <h3>${product.name}</h3>
            <p>Price: ₹${product.price}</p>
            <button onclick="addToCart()">
                Add to Cart
            </button>
        </div>
    `;

});