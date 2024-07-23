-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    nameu VARCHAR(255),
    email VARCHAR(100),
    roleu VARCHAR(50),
    PRIMARY KEY (id),
    UNIQUE (username)
    );

-- Create device table
CREATE TABLE IF NOT EXISTS device (
    id SERIAL,
    named VARCHAR(100) NOT NULL,
    stated BOOLEAN NOT NULL,
    ontime VARCHAR(5) NOT NULL,
    offtime VARCHAR(5) NOT NULL,
    PRIMARY KEY (id)
    );

-- Create record table
CREATE TABLE IF NOT EXISTS records (
    id SERIAL,
    device_id INTEGER REFERENCES device(id) ON DELETE CASCADE,
    times TIMESTAMP NOT NULL,
    timevalues DOUBLE PRECISION NOT NULL,
    PRIMARY KEY (id)
    );
