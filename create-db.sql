CREATE TABLE users (
	id SERIAL,
	email VARCHAR(50),
	phone VARCHAR(50),
	full_name VARCHAR(255),
	password VARCHAR(100),
	group_id INT
);

CREATE TABLE roles (
	id SERIAL,
	name VARCHAR(30)
);

CREATE TABLE roles_users (
	user_id INT,
	role_id INT
);

CREATE TABLE events (
	id SERIAL,
	name VARCHAR(255),
	description TEXT,
	date TIMESTAMP,
	place VARCHAR(255)
);

CREATE TABLE events_users (
	event_id INT,
	user_id INT
);

CREATE TABLE requests (
	id SERIAL NOT NULL,
	theme VARCHAR(255),
	text TEXT,
	date TIMESTAMP,
	user_id INT
);

CREATE TABLE groups ( 
	id SERIAL, 
	number VARCHAR(12), 
	start_year DATE 
); 

CREATE TABLE posts ( 
	id SERIAL, 
	title VARCHAR(255), 
	text TEXT, 
	date TIMESTAMP, 
	user_id INT 
); 

CREATE TABLE documents ( 
	id SERIAL, 
	user_id INT, 
	name VARCHAR(255), 
	path VARCHAR(255) 
); 

CREATE TABLE notifications ( 
	id SERIAL, 
	user_id INT, 
	theme VARCHAR(255), 
	text TEXT, 
	date TIMESTAMP 
); 

CREATE TABLE destinations ( 
	id SERIAL, 
	notification_id INT 
); 

CREATE TABLE documents_posts ( 
	document_id INT, 
	post_id INT 
); 

CREATE TABLE users_destinations ( 
	user_id INT, 
	destination_id INT 
); 

-- ADD primary keys 
ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY (id);
ALTER TABLE roles ADD CONSTRAINT roles_pk PRIMARY KEY (id);
ALTER TABLE roles_users ADD CONSTRAINT roles_users_pk PRIMARY KEY (user_id, role_id);
ALTER TABLE events ADD CONSTRAINT events_pk PRIMARY KEY (id);
ALTER TABLE events_users ADD CONSTRAINT events_users_pk PRIMARY KEY (event_id, user_id);
ALTER TABLE requests ADD CONSTRAINT requests_pk PRIMARY KEY (id);
ALTER TABLE groups ADD CONSTRAINT groups_pk PRIMARY KEY(id); 
ALTER TABLE posts ADD CONSTRAINT posts_pk PRIMARY KEY(id); 
ALTER TABLE documents ADD CONSTRAINT documents_pk PRIMARY KEY(id); 
ALTER TABLE notifications ADD CONSTRAINT notifications_pk PRIMARY KEY(id); 
ALTER TABLE destinations ADD CONSTRAINT destinations_pk PRIMARY KEY(id); 
ALTER TABLE documents_posts ADD CONSTRAINT documents_posts_pk PRIMARY KEY (document_id, post_id);
ALTER TABLE users_destinations ADD CONSTRAINT users_destinations_pk PRIMARY KEY (user_id, destination_id);

-- ADD foreign keys for "many-to-many"
ALTER TABLE documents_posts ADD CONSTRAINT documents_posts_document_fk FOREIGN KEY (document_id) REFERENCES documents (id); 
ALTER TABLE documents_posts ADD CONSTRAINT documents_posts_post_fk FOREIGN KEY (post_id) REFERENCES posts (id); 
ALTER TABLE users_destinations ADD CONSTRAINT users_destinations_user_fk FOREIGN KEY (user_id) REFERENCES users (id); 
ALTER TABLE users_destinations ADD CONSTRAINT users_destinations_destination_fk FOREIGN KEY (destination_id) REFERENCES destinations (id); 
ALTER TABLE events_users ADD CONSTRAINT events_users_events_fk FOREIGN KEY (event_id) REFERENCES events (id);
ALTER TABLE events_users ADD CONSTRAINT events_users_users_fk FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE roles_users ADD CONSTRAINT roles_users_users_fk FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE roles_users ADD CONSTRAINT roles_users_roles_fk FOREIGN KEY (role_id) REFERENCES roles (id);

-- ADD foreign keys for "one-to-many / many-to-one"
ALTER TABLE users ADD CONSTRAINT users_groups_fk FOREIGN KEY (group_id) REFERENCES groups (id);
ALTER TABLE posts ADD CONSTRAINT posts_users_fk FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE documents ADD CONSTRAINT documents_users_fk FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE notifications ADD CONSTRAINT notifications_users_fk FOREIGN KEY (user_id) REFERENCES users (id); 
ALTER TABLE destinations ADD CONSTRAINT destinations_notifications_fk FOREIGN KEY (notification_id) REFERENCES notifications (id);
ALTER TABLE requests ADD CONSTRAINT requests_users_fk FOREIGN KEY (user_id) REFERENCES users (id);
