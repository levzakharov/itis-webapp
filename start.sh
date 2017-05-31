# start db
sudo docker run --name db --detach -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=itis-portal postgres

# install
mvn clean install

# start application
nohup mvn spring-boot:run &
echo $! > save_pid.txt