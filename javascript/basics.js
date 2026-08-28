
/**
 * to execute this file type 
 * 
 * `node basics.js`
 * 
 * Declaring variables
 * let, var, const
 * 
 * Datatypes
 * string, number, boolean, undefined = declared but no values has been assigned
 */

let x = "Ashish"

console.log(x)
console.log(typeof x)

x = 10
console.log(typeof x)

x = true
console.log(typeof x)

x = null
console.log(typeof x)

x = undefined
console.log(typeof x)

x = new Date()
console.log(typeof x)

/**
 * let vs var
 * - let is block scoped, var is function scoped, var will ignore the {}
 * - let cannot be redeclared, var can be redeclared
 * - var is hoisted into global scope
 * 
 * use const by default, only if needed change it or use let, never use var
 */

console.log(leak) // prints undefined

if (true) { // if block starts
    let safe = "safely declared inside if scope"
    // let safe = 10 // Error, cannot redeclare let 

    var leak = "can escape outside if scope"

    var leak = 20 // Possible in var
}// if block ends

var leak = true // Still possible

console.log(leak)
//console.log(safe) // Ignore this line, Compilation error, runtime error


// Functions in JS
function sayHello() { //start 

} //end

const greeting = function () {

}

// Arrow Functions
const welcome = () => {

}

const sum = (a, b) => {
    return a + b
}

const sum2 = (a, b) => a + b

/**
 * loose equals:    ==
 * - can use type coercion
 * 
 * strict equals:   ===
 */

if (5 == "5") {
    console.log("== working")
}

if (5 === "5") {
    console.log("=== working")
} else {
    console.log("=== not working")
}
// ?
if (5 === +"5") {
    console.log("=== working")
} else {
    console.log("=== not working")
}

// predict the output
console.log(+"")        // 0     
console.log(+true)      // 1 
console.log(+false)     // 0
console.log(+null)      // 0


// ... Rest operator
const sumAll = (...numbers) => {
    let sum = 0
    for (let num of numbers) {
        sum += num
    }
    console.log(`Sum of ${numbers} is ${sum}`)
}

sumAll(1, 2, 3)
sumAll(1, 2, 3, 4)
sumAll(1, 2, 3, 4, 5, 6, 7)

const fruits = ["Apple", "orange", "Grapes", "Pineapple"]
const fruitsCopy = [...fruits, "gauva"] // Shallow copy
console.log(fruitsCopy)

const even = [2, 4, 6, 8]
const odd = [3, 5, 7, 9]
const combined = [...even, ...odd]
console.log(combined)

// Objects
// Unordered collection collection of key value pairs
// used to store structured data
// data can be accessed using the . operator aka object.propertyname, know as dot notation
// example: user.name
// bracket notation
// object['propertyName'] example: user["id"]
const user = {
    id: 1,
    name: "Ashish",
    email: "ashish@gmail.com",
    skills: ["HTML", "CSS", "JS"]
}
console.log(user)

// adding property to an object
user.isActive = true
console.log(user)

// modify a property
user["name"] = "Ashish S"
console.log(user)

// remove a property
// delete user.isActive
// console.log(user)

// check if a property exists in the object
console.log(Object.hasOwn(user, "name"))

// Get all properties or keys from an object
console.log(Object.keys(user))

// Get all values from an object
console.log(Object.values(user))

// Get data in key-value pairs
console.log(Object.entries(user))

// Objects can have functions inside it, and when you use the this keyword,
// it refers to the actual object
const counter = {
    count: 0,
    increment() {
        this.count += 1
        return this.count
    },
    decrement() {
        this.count -= 1
        return this.count
    }
}
console.log(counter.increment())
console.log(counter.increment())

console.log(counter.decrement())

console.log(counter.increment())


const systemUser = {
    username: "system",
    role: "ADMIN"
}

// Spread operation in objects
// When two objects share the same property key, the last property defined is accepted
const normalUser = { ...systemUser, role: "USER" }
console.log(normalUser)

// Shallow copy
const original = { name: "Ashish", scores: [80, 88] }
const shallowCopy = { ...original }

shallowCopy.scores.push(79)

console.log(original)
console.log(shallowCopy)

console.log()

// Deep copy, use structuredClone method
const deepCopy = structuredClone(original)
deepCopy.scores.push(100)
console.log(original)
console.log(deepCopy)

// Object destructuring
const profile = {
    userid: 101,
    theme: "dark",
    region: "IN"
}

// const userid = profile.userid;
const { userid, region } = profile
console.log(`User: ${userid}, Region: ${region}`)

// renaming the varaibles
const { userid: loggedInUser, region: loggedInRegion } = profile
console.log(`User: ${userid}, Region: ${region}`)

// Array desstructuring
const rgb = [255, 255, 255]

const [red, green, blue] = rgb

// Skip elements, grab the first and last, skip the second
const [r, , b] = rgb