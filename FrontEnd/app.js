
let cart = [];
let products = [];

// Add product to cart
function addToCart(productId) {

    let selectedProduct = products.find(function(product) {
        return product.productId === productId;
    });

    if (selectedProduct) {
        cart.push(selectedProduct);
    }

    displayCart();
}

// Display cart items
function displayCart() {

    let cartItems = document.getElementById("cartItems");
    let cartTotal = 0;

    cartItems.innerHTML = "";

    cart.forEach(function(product, index) {

        cartItems.innerHTML += `
            <div>
                <p>${product.productName} - ₹${product.price}</p>

                <button onclick="removeFromCart(${index})">
                    Remove
                </button>
            </div>
        `;

        cartTotal += product.price;
    });

    document.getElementById("cartCount").innerText = cart.length;

    document.getElementById("cartTotal").innerText = cartTotal;

    if (cart.length === 0) {
        cartItems.innerText = "Your cart is empty.";
    }
}

// Remove product from cart
function removeFromCart(index) {

    cart.splice(index, 1);

    displayCart();
}

// Fetch products from Java backend
fetch("http://localhost:8086/DipCartWeb/products")
    .then(response => response.json())
    .then(data => {

        products = data;

        let productList = document.getElementById("productList");

        products.forEach(function(product) {

            productList.innerHTML += `
                <div class="product">
                    <h3>${product.productName}</h3>
                    <p>Price: ₹${product.price}</p>
                    <p>Stock: ${product.stock}</p>

                    <button onclick="addToCart(${product.productId})">
                        Add to Cart
                    </button>
                </div>
            `;
        });

    })
    .catch(error => {
        console.error("Error fetching products:", error);
    });
