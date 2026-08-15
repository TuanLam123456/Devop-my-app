create image

docker build -t my-app-image .

show danh sách
docker image list

docker image remove [IMAGE_NAME/ID]


create container
docker run --name my-app-container -d -p 3000:300 my-app-image

docker container list
docker ps = process status

docker container start [CONTAINER_NAME/ID]
docker container stop [CONTAINER_NAME/ID]