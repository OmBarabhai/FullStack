# JavaScript Classes

---

# Class

- Class ---> (Entity) ORM ----> Business Requirement
- Class ---> (Model) ---------> Data

---

# ORM (Object Relational Mapping)

ORM = Object Relational Mapping

- ORM maps a Class (Object) to a Relational Database Table.
- It acts as a bridge between Programming Language Objects and Database Tables.

Flow:

```text
Class (Object)
      ↓
     ORM
      ↓
Database Table
```

Example:

```text
Product Class
      ↓
     ORM
      ↓
products Table
```

---

# Class is Known As

- Blue Print
- Model
- Entity

---

# Definition

- Technically Class is a Program Template.
- Program Template provides a set of values and methods which you can implement and customize according to requirements.

---

# Class Behaviours

A Class can act as:

- Blue Print
- Model
- Entity

---

# Entity

- Class is defined as **Entity** when it maps to Business Requirements.

Example:

```text
Employee
Customer
Student
Product
```

---

# Model

- Class is defined as **Model** when it maps to Data Requirements.

Example:

```text
Database
     ↓
 Product Model
```

---

# JavaScript Class Comprises Of

- Constructor
- Properties
- Accessors
- Methods

---

# Constructor

- Constructor is used for Instantiation.

Meaning:

```text
Create Object
```

---

# Property

- Property stores the data.

Example:

```javascript
class Product{
    Name = "TV";
}
```

---

# Accessor

Accessor provides fine-grained control over properties.

It can configure restrictions for:

- Reading value
- Assigning value

Accessor Types:

- Getter
- Setter

---

# Method

- Method defines the actions to perform.

Example:

```javascript
class Product{
    Display(){
        console.log("Product");
    }
}
```

---

# FAQ

## Can We Declare Variable In Class?

No.

```html
<script>
class Product{
    var Name = "TV";
}
</script>
```

Output

```text
Unexpected token.
A constructor, method, accessor, or property was expected.
```

---

## Why Can't We Declare Variable In Class?

Variable is Immutable.

Class can't contain Immutable Members.

---

## How Data Is Stored In Class?

Using Property.

Example

```javascript
class Product{
    Name = "TV";
}
```

---

## Can We Define Function In Class?

No.

You can have only Methods.

```html
<script>
class Product{
    function f(){

    }
}
</script>
```

Output

```text
Unexpected token.
A constructor, method, accessor, or property was expected.
```

---

## Note

You can define Variables inside Methods.

Example

```javascript
class Product{
    Display(){

        var x = 10;

    }
}
```

---

# Class, Property, Method, Variable, Function

```html
<script>

var Name = "TV";

class Product{

    Property = "Data";

    Method(){

        var x = 10;

        function f(){

        }

    }

}

</script>
```

---

# Accessors (Getter & Setter)

Authentication Example

```html
<script>

var userName = prompt("Enter Your User Name");
var Designation = prompt("Enter Your Designation");
var productName = prompt("Enter Your Product Name");

class Product{

    _productName;

    get productName(){
        return this._productName;
    }

    set productName(newName){

        if(Designation=="admin"){

            this._productName = newName;

        }
        else{

            document.write(
                `Unauthorized :
                 Hello ${userName}
                 You are not authorized user`
            );

        }

    }

}

let obj = new Product();

obj.productName = productName;

if(obj.productName){

    document.write(
        "Product Name : " + obj.productName
    );

}

</script>
```

---

# Flow

```text
User Input
      ↓
Setter Called
      ↓
Authentication
      ↓
Assign Value
      ↓
Getter
      ↓
Display Product Name
```

---

# Summary

```text
Class
│
├── Constructor
├── Property
├── Accessor
│      ├── Getter
│      └── Setter
└── Method

Entity
      ↓
     ORM
      ↓
Database Table
```