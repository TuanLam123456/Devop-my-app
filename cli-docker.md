# DOCKER Other
```bash
docker login
# cần web để đăng nhập

docker login -u <username>
# dùng khi đăng nhập trên server LINUX, cmd
```


# IMAGE

```bash
# create image

docker build -t my-app-image .

# show danh sách image
docker image list

docker image remove [IMAGE_NAME/ID]

docker image tag [old_name] [new_name]

# export lên hub
docker push [tên_đầy_đủ_image/ID]

# export ra file
docker save -o [đường_dẫn/tên_file.tar] [tên_iamge/id]

# import từ hub
docker pull [tên_đầy_đủ_image]

# import từ file
docker load -i [đường_dẫn/tên_file.tar]
```
# CONTAINER
```bash
# create container
docker run --name my-app-container -d -p 3000:3000 lam141000/my-app-image
# -p: publish

# show list container
docker container list
docker ps = process status

docker container start [CONTAINER_NAME/ID]
docker container stop [CONTAINER_NAME/ID]

# Tab losgs docker desktop
docker container logs [CONTAINER_NAME/ID]
docker logs [CONTAINER_NAME/ID]

# Tab inspect docker desktop
docker inspect [CONTAINER_NAME/ID]

# Tab stats docker desktop
docker stats
```

# NETWORK
- bridge:
    - network mặc định cho container
    - mỗi container sẽ có IP riêng
    - IP <=> (CONTAINER_NAME giống domain)
- host:
    - Dùng IP của server
- none: 
    - container bị cô lập => tăng bảo mật
    - job / bot

```bash
docker network create [NETWORK_NAME]
docker network remove [NETWORK_NAME/ID]

docker network connect [NETWORK_NAME/ID] [CONTAINER_NAME/ID]
docker run --network [NETWORK_NAME/ID] --name CONTAINER_NAME -d -p 3000:3000 ten_image
docker network disconnect [NETWORK_NAME/ID] [CONTAINER_NAME/ID]
```

# VOLUME

