FROM mysql/mysql-server:5.5

ENV MYSQL_ROOT_PASSWORD 1234

ENV MYSQL_DATABASE user

COPY initDatabase.sql /docker-entrypoint-initdb.d/initDatabase.sql

EXPOSE 3306

# RUN /etc/init.d/mysql start && \
#     mysql -u root -e "CREATE DATABASE UserDatabase" && \
#     mysql -u root UserDatabase < initDatabase.sql
