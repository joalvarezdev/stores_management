CREATE TABLE IF NOT EXISTS "movements" (
    id UUID NOT NULL,
    product_id VARCHAR(100) NOT NULL,
    warehouse_id UUID NOT NULL,
    row INT NOT NULL,
    movement_type VARCHAR(1) NOT NULL,
    quantity DOUBLE PRECISION NOT NULL,
    description VARCHAR(100),
    "date" TIMESTAMP NOT NULL,
    CONSTRAINT "pk_movements" PRIMARY KEY ("id", "product_id", "warehouse_id", "row"),
    CONSTRAINT "fk_movements_products" FOREIGN KEY ("product_id") REFERENCES products("code"),
    CONSTRAINT "fk_movements_stores" FOREIGN KEY ("warehouse_id") REFERENCES stores("id")
);
