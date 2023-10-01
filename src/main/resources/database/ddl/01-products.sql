CREATE TABLE IF NOT EXISTS "products" (
    code VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
	price DOUBLE PRECISION NOT NULL,
    CONSTRAINT "pk_products" PRIMARY KEY ("code"),
    CONSTRAINT "unique_name" UNIQUE("name")
);