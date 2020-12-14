docker_up:
	sudo docker-compose -f ./ops-tools/docker/docker-compose.yaml up

connect_to_psql:
	sudo docker exec -it mikael_db psql ycps_db2 -U ycps_user
