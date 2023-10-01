CREATE TABLE IF NOT EXISTS "stores" (
    id UUID NOT NULL,
    name VARCHAR(100) NOT NULL,
	description VARCHAR(100) NOT NULL,
    CONSTRAINT "pk_stores" PRIMARY KEY ("id")
);
