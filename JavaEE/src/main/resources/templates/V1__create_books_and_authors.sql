CREATE TABLE Authors (
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	birth_date DATE
);

CREATE TABLE Books (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    publish_date DATE,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES Authors(id)
);
