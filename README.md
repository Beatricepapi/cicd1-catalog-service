## Lab 7 - Docker and Data Persistence

I containerised the Catalog Service using a Dockerfile based on Eclipse Temurin Java 21. The Docker image was built as `cicd1-catalog-service:lab7`.

I created a `compose.yaml` file to run the Catalog Service on port 8081 and configured a named Docker volume, `catalog_data`, to store the H2 database files.

### Testing

1. **Docker image:** Successfully built `cicd1-catalog-service:lab7`.
2. **Docker Compose:** Successfully started the Catalog Service on port 8081.
3. **H2 database:** Created a Computers category with ID 1.
4. **POST /products:** Created a Laptop product with price 750 and category ID 1. Received HTTP 200 OK.
5. **H2 verification:** `SELECT * FROM PRODUCTS;` confirmed the Laptop was stored with category ID 1.
6. **Persistence test:** Restarted the Docker container using `docker compose restart`. After restarting, `GET /products` returned HTTP 200 OK and the Laptop product was still present.
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

### Result

The Catalog Service runs successfully in Docker, and the H2 database retains product data across container restarts using a Docker named volume.