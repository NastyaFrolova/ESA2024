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

CREATE TABLE change_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    change_type TEXT,
    entity_type TEXT,
    entity_id BIGINT,
    changed_data TEXT,
);

CREATE TABLE email_notifications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email TEXT NOT NULL,
    condition_info TEXT,
    entity_type TEXT,
    entity_attribute TEXT,
    condition_value TEXT
);
