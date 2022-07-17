sudo docker run -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=supersecret" --env="MYSQL_PASSWORD=supersecret" --env="MYSQL_DATABASE=food_app" mysql
sudo docker build -f DockerFile -t food .
sudo docker run -t --name food --link docker-mysql:mysql -p 8080:8080 food