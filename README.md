# spring-webApplication-mvc

# Docker build app image:
docker build --tag roscha/web-app-image .

# Docker run app container:
docker run --name roscha-web-app-container -p 8091:8091 roscha/web-app-image:latest

# Docker remove all containers:
docker rm $(docker ps --filter status=exited -q)

# Execute shell command inside the container:
docker exec -it roscha-web-app-container sh
