# IMAGE

```bash
# create image

docker build -t my-app-image .

# show danh sách image
docker image list

docker image remove [IMAGE_NAME/ID]
```
# CONTAINER
```bash
# create container
docker run --name my-app-container -d -p 3000:300 my-app-image

# show list container
docker container list
docker ps = process status

docker container start [CONTAINER_NAME/ID]
docker container stop [CONTAINER_NAME/ID]
```