
# Java Spring Boot Food App

### Project Tasks
```
- [x] Login
- [x] create user
- [x] update user
- [x] get user info
- [x] delete user
- [x] create shop
- [x] update shop
- [x] get all shop
- [x] get shop detail by id 
- [x] create category
- [x] update category
- [x] get all categries
- [x] get one category by id
- [x] delete category
- [x] create food menu
- [x] udpate menu
- [x] get all menu (with pagination and search)
- [x] get menu detail
- [x] get menu by shop
- [x] delete menu
- [x] add menu to cart
- [x] get all cart items
- [x] update cart
- [x] delete item from cart
- [x] chcekout
- [x] get order list for shop
- [ ] get order list for customer
- [x] confirm delivery
- [x] confirm payment
- [x] create review
- [x] update review
- [x] get all review for menu
- [x] delete review
- [x] throttle api request when too many search (in menu)
- [ ] increase price when order same menu for 3 days
- [ ] make unit test cases 
- [ ] Dockerize project
```

### First you may need to install
<ul> 
<li>docker</li>
<li>docker-compose</li>
<li>maven cli</li>
<li>jdk 1.8</li>  
</ul>

### Run project 

```console
mvn clean install
docker-compose up -d //start mongodb server
mvn spring-boot:run
```
	  or just use intellij/eclipse
	  server run on port 8080

## APi document

 All requests are post request  (Everything else except login and signup required Bearer token)

#### Login

method: POST

path
```
 /api/login
```
body
```json
{
	"email": "admin",
	"password": "password"
}
```
#### create user

method: POST


path
```
  /user/create
```
body
```json
{
    "fullname": "dom",
    "phone": "092131324",
    "password": "123456",
    "role": "ROLE_CUSTOMER", // ROLE_OWNER ROLE_DELIVERY 
		"email": "dom@qmail.com",
		"address": "phnom penh"
}
```

#### update user 

method: PUT

path
```
 /api/auth/check-2fa-status
```
body
```json
{
    "phone": "01244556",
    "userId": 2
    //limited to only phone for now
}
```
#### Get user info 

method: GET

path
```
 /user/{userId}
```
#### delete user

method: DELETE


path
```
 /user/{userId}
```

#### create shop

method: POST

path
```
 /shop/create
```
body
```json
{
    "name": "dom shop",
    "address": "pp",
    "phone": "092123123",
    "userId": 2,
		"email": "dom@gmail.com"
}
```
#### update shop

method: PUT

path
```
 /shop
```
body
```json
{
    "shopId" : 1,
    "phone": "09123213"
}
```

#### get all shop

method: GET

path
```
 /shop
```

#### get shop by id

method: GET

path
```
 /shop/{shopId}
```

#### delete shop

method: GET

path
```
 /shop/{shopId}
```

#### create category

method: POST

path
```
 /category/create
```
body
```json
{
    "categoryName": "spicy",
    "detail": ""
}
```
#### update category

method: PUT

path
```
 /category
```
body
```json
{
    "categoryName": "cold",
    "categoryId": "1"
}
```
#### get  all categories

method: GET

path
```
 /category
```

#### get category

method: GET

path
```
 /category/{categoryId}
```

#### delete category

method: DELETE

path
```
 /category/{categoryId}
```

#### create menu

method: POST

path
```
 /category/create
```
body
```json
{
    "name": "hot nugget",
    "image": "",
    "shopId": 2,
    "categoryId": 1,
    "price": 1.1
}
```

#### update menu

method: PUT

path
```
 /category
```
body
```json
{
	"name": "cold nugget",
	"categoryId": 1,
	"image": "",
	"price": 111,
	"menuId": 3,
	"shopId": 1
}
```

#### get menu

method: GET

path
```
 /menu
```
	 * param
		 - page = page number
		 - perPage = display per page
		 - name = search for menu name
		 exaple
		 /menu?name=nugget&page=2&perPage=2

#### get menu by id

method: GET

path
```
 /menu/{menuId}
```

#### get menu by shop id

method: GET

path
```
 /menu/shop/{shopId}
```

#### delete menu

method: DELETE

path
```
 /menu/{menuId}
```

#### add to cart

method: POST

path
```
 /order/cart
```
```json
{
	"userId" : 2,
	"menuId" : 3,
	"quantity": 2
}
```
#### get all items in cart

method: GET

path
```
 /order/cart/{userId}
```

#### update cart

method: PUT

path
```
 /order/cart
```
body
```json
{
	"userId" : 1,
	"cartItemId": 1,
	"quantity": 20
}
```

#### remove from cart

method: DELETE

path
```
 /order/cart
```
body
```json
{
	"userId" : 1,
	"cartItemId": 1
}
```

#### checkout

method: PUT

path
```
 /order/cart/checkout
```
body
```json
{
	"customerId" : 2,
	"deliveryAddress" : "phnom penh"
}
```
#### get order list by shop

method: GET

path
```
 /order/{shopId}
```

#### confirm delivered

method: POST

role: ROLE_DELIVERY

path
```
 /order/confirm-delivered/{oderId}
```

#### Confirm payment

method: POST

role: ROLE_OWNER

path
```
 /order/confirm-payment
```
body
```json
{
	"amount": 1111,
	"paidBy": 1,
	"processedBy": 1, //userId
	"orderId": 8
}
```
#### create review

method: POST

path
```
 /review/create
```
body
```json
{
	"comment": "sadadasd",
	"rating": 4,
	"menuId": 2,
	"customerId": 1 // userId
}
```
#### update review

method: put

path
```
 /review
```
body
```json
{
	"comment": "so hot i'm crying",
	"rating": 4,
	"menuId": 2,
	"customerId": 1,
	"reviewId": 6
}
```
#### get all review for menu

method: GET

role: ROLE_DELIVERY

path
```
 /review/{menuId}
```

#### delete review

method: DELETE

role: ROLE_DELIVERY

path
```
 /review
```
body
``` json
    {
        "reviewId": 2,
        "customerId": 1
    }
```

