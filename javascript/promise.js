/**
 * Refer to the callback.js
 * 
 * Problem 1: Nesting
 * getUser
 * -----> getUserOrder
 * --------> getOrderDetails
 * 
 * Problem 2: repeated Error handling
 * 
 * We want to have a mechanism that can do
 * execute getUser -> execute getUserOrder -> execute getOrderDetails
 */

/**
 * Promise: An object that represents eventual result of an async operation
 * A promise can be in one of three states
 * PENDING: Operation is still executing, 
 * FULLFILLED: Successfull execution, 
 * REJECTED: Failed execution
 */

const promise1 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve("Promise1 executed successfully.") // resolve = success & reject = failure
    }, 3000)
})
promise1.then(result => {
    console.log(result)
})


const promise2 = new Promise((resolve, reject) => {
    setTimeout(() => {
        reject("Promise2 failed.") // resolve = success & reject = failure
    }, 3000)
})
promise2.then(result => {
    console.log(result)
}).catch(err => {
    console.error(err)
})


const getUserPromise = (userId) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {

            if (userId !== 1) {
                reject(new Error("Incorrect user id detected"))
                return
            }

            // execute this for 1000 ms
            const user = {
                id: userId,
                name: "Ashish",
                email: "ashish@gmail.com"
            }
            resolve(user)  // Success, no error was detected
        }, 1000)
    })
}

const getUserOrderPromise = (userId) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {

            if (userId !== 1) {
                reject(new Error("No orders for this userId"))
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

            resolve(orders) // Success, no error was detected
        }, 1000)
    })
}

const getOrderDetailsPromise = (orderId) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {

            if (orderId !== 1) {
                reject(new Error("No order found for this userId"))
                return
            }
            const order = {
                id: orderId,
                product: "Laptop",
                price: 75000,
                status: "Delivered",
                payment: "Credit Card"
            }

            resolve(order) // Success, no error was detected
        }, 1000)
    })
}

getUserPromise(1).then(user => {
    return getUserOrderPromise(user.id)
}).then(orders => {
    return getOrderDetailsPromise(orders[0].id)
}).then(order => {
    console.log(JSON.stringify(order, null, 2))
}).catch(err => {
    console.error(err.message)
}).finally(() => {
    console.log("Order fetching completed")
})