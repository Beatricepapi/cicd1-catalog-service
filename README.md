# CICD1 Catalog Service

## SQL and Normalisation Lab

Final db<>fiddle session: https://dbfiddle.uk/yK5IIHNs

The fiddle contains the completed SQL queries and the written answers as SQL comments.

## Lab 5 - JPQL Queries and JPA Relationships

This lab adds JPQL queries and a Product-to-Category JPA relationship to the Catalog Service.

### JPQL GET Endpoints

**Get products by minimum price:**

`GET http://localhost:8081/products/min-price?price=100`

Returns products costing at least 100.

**Get products by category:**

`GET http://localhost:8081/products/by-category?name=Computers`

Returns products belonging to the specified category.

### Create a Product with a Category

**Endpoint:** `POST http://localhost:8081/products`

Example JSON request:

```json
{
  "name": "Keyboard",
  "price": 79.99,
  "categoryId": 2
}
```

The `categoryId` must refer to an existing category in the H2 database. An invalid or missing `categoryId` returns HTTP 400.

### Testing

- Tested the minimum-price JPQL query.
- Verified Product and Category relationships in H2.
- Tested creating a product with an existing category.
- Tested the category-based JPQL JOIN query.