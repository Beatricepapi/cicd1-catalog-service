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

### Result

The Catalog Service runs successfully in Docker, and the H2 database retains product data across container restarts using a Docker named volume.