# stop application
kill -9 `cat save_pid.txt`
rm save_pid.txt

# stop db
sudo docker stop db
sudo docker rm db