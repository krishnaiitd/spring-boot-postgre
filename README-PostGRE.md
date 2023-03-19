# Installation of postgre

## On mac
> brew install postgresql@14

After install start it through service 
> brew services start postgresql@14

### Check that this is running or not
> ps aux | grep postgre

#### For more details: https://www.postgresql.org/docs/14/app-initdb.html

### To connect on local machine 
>psql postgres
>
> #List of users
> 
> '\du'
> 
#### Create a username and password for connection through Spring boot Application

> CREATE ROLE dev WITH LOGIN PASSWORD 'dev12345';
> ALTER ROLE dev CREATEDB;
> \du
> postgres=# \du

List of roles
Role name |                         Attributes                         | Member of
-----------+------------------------------------------------------------+-----------
dev       | Create DB                                                  | {}
krishna   | Superuser, Create role, Create DB, Replication, Bypass RLS | {}


> createuser dev
> createuser dev --createdb
#### Quit PostGre terminal
>\q
#### Login with dev user 
>psql postgres -U dev
> create database test;
> # List all databases
> postgres=# \l
List of databases
Name    |  Owner  | Encoding | Collate | Ctype |  Access privileges  
-----------+---------+----------+---------+-------+---------------------
postgres  | krishna | UTF8     | C       | C     |
template0 | krishna | UTF8     | C       | C     | =c/krishna         +
|         |          |         |       | krishna=CTc/krishna
template1 | krishna | UTF8     | C       | C     | =c/krishna         +
|         |          |         |       | krishna=CTc/krishna
test      | dev     | UTF8     | C       | C     |
(4 rows)
> \list
#### Grant all access to dev user for the database we have created above
> GRANT ALL PRIVILEGES ON DATABASE test TO dev;
> \list
>postgres=> \list
List of databases
Name    |  Owner  | Encoding | Collate | Ctype |  Access privileges  
-----------+---------+----------+---------+-------+---------------------
postgres  | krishna | UTF8     | C       | C     |
template0 | krishna | UTF8     | C       | C     | =c/krishna         +
|         |          |         |       | krishna=CTc/krishna
template1 | krishna | UTF8     | C       | C     | =c/krishna         +
|         |          |         |       | krishna=CTc/krishna
test      | dev     | UTF8     | C       | C     | =Tc/dev            +
|         |          |         |       | dev=CTc/dev
(4 rows)
> 

#### Connect to some database (show databases)
> \c test
You are now connected to database "test" as user "dev".
### List down all tables in the db (show tables)
>\dt
List of relations
Schema | Name | Type  | Owner
--------+------+-------+-------
public | test | table | dev
(1 row)

### To know the details of table created from JPA:
>
test=> \d test
Table "public.test"
Column    |          Type          | Collation | Nullable | Default
-------------+------------------------+-----------+----------+---------
id          | bigint                 |           | not null |
description | character varying(255) |           |          |
name        | character varying(255) |           |          |
Indexes:
"test_pkey" PRIMARY KEY, btree (id)

>insert into test (id, name, description) values (1, 'krishna', 'first name');

test=> select * from test;
id | description |  name   
----+-------------+---------
1 | first name  | krishna
(1 row)

