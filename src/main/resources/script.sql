CREATE TABLE departments
(
    dept_id   int         NOT NULL
        PRIMARY KEY,
    dept_name varchar(30) NULL,
    CONSTRAINT dept_id
        UNIQUE (dept_id)
);

CREATE TABLE employees
(
    id          int AUTO_INCREMENT
        PRIMARY KEY,
    employee_id int         NOT NULL,
    first_name  varchar(30) NOT NULL,
    last_name   varchar(30) NOT NULL,
    dept_id     int         NOT NULL,
    CONSTRAINT employee_id
        UNIQUE (employee_id),
    CONSTRAINT employees_ibfk_1
        FOREIGN KEY (dept_id) REFERENCES departments (dept_id)
);

CREATE INDEX dept_id
    ON employees (dept_id);


