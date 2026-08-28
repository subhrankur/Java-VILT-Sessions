/**
 * Callback is a function that is passed as an argument to another function.
 */

const greet = (name, callback) => {
    // 1. Perform this operation
    console.log(`Hello ${name}`)

    // 2. once complete execute callback
    callback()
}

greet("Ashish", function () {
    console.log(" Welcome!")
})


/**
 * 1. Get the user details
 * 2. get the user's orders
 * 3. get the details of the first order
 * 4. print that order
 */

// get user details
const getUser = (userId, callback) => {
    setTimeout(() => {

        if (userId !== 1) {
            callback(new Error("Incorrect user id detected"), null)
            return
        }

        // execute this for 1000 ms
        const user = {
            id: userId,
            name: "Ashish",
            email: "ashish@gmail.com"
        }
        // Got the userdetails, now execute the callback
        callback(null, user)  // Success, no error was detected
    }, 1000)
}
// Get the user's orders
const getUserOrder = (userId, callback) => {
    setTimeout(() => {

        if (userId !== 1) {
            callback(new Error("No orders for this userId"), null)
            return
        }
        const orders = [
            {
                id: 101, product: "Mobile", price: 50000
            },
            {
                id: 107, product: "Laptop", price: 75000
            }
        ]

        callback(null, orders) // Success, no error was detected
    }, 1000)
}

// Gte the order details
const getOrderDetails = (orderId, callback) => {
    setTimeout(() => {

        if (orderId !== 1) {
            callback(new Error("No order found for this userId"), null)
            return
        }
        const order = {
            id: orderId,
            product: "Laptop",
            price: 75000,
            status: "Delivered",
            payment: "Credit Card"
        }

        callback(null, order) // Success, no error was detected
    }, 1000)
}

// Call this
getUser(1, function (error, user) {
    // console.log("user: " + JSON.stringify(user))

    getUserOrder(user.id, function (error, orders) {
        // console.log("User Orders: " + JSON.stringify(orders))

        getOrderDetails(orders[0].id, function (error, order) {
            // console.log("Order Details: " + JSON.stringify(order))

            console.log(
                JSON.stringify(user),
                JSON.stringify(orders),
                JSON.stringify(order)
            )
        })
    })
})

/**
 * getUser          -> Success
 * getUserOrder     -> Success
 * getOrderDetails  -> Error
 * 
 * callback(error, result)
 */

getUser(1, function (error, user) {
    // console.log("user: " + JSON.stringify(user))
    if (error) {
        console.error(error)
        return
    }

    getUserOrder(user.id, function (error, orders) {
        // console.log("User Orders: " + JSON.stringify(orders))
        if (error) {
            console.error(error)
            return
        }

        getOrderDetails(orders[0].id, function (error, order) {
            // console.log("Order Details: " + JSON.stringify(order))
            if (error) {
                console.error(error)
                return
            }

            console.log(
                JSON.stringify(user),
                JSON.stringify(orders),
                JSON.stringify(order)
            )
        })
    })
})

// Callback Hell or Pyramid of Doom
// getUser(1, function(user) {

//     getOrders(user.id, function(orders) {

//         getOrderDetails(orders[0].id, function(order) {

//             getProduct(order.productId, function(product) {

//                 getSeller(product.sellerId, function(seller) {

//                     getReviews(seller.id, function(reviews) {

//                         getPayment(order.id, function(payment) {

//                             getShipping(order.id, function(shipping) {

//                                 console.log(
//                                     user,
//                                     order,
//                                     product,
//                                     seller,
//                                     reviews,
//                                     payment,
//                                     shipping
//                                 );
//                             });
//                         });
//                     });
//                 });
//             });
//         });
//     });

// });