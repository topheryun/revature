CREATE TABLE test.projects (
	orderid int NOT NULL,
	ordernumber int NOT NULL,
	id int NOT NULL,
	CONSTRAINT projects_pk PRIMARY KEY (orderid),
	CONSTRAINT projects_fk FOREIGN KEY (id) REFERENCES test.employee(id)
);