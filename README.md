Hi All!
I am Rostik
I am automation QE engineer 
I like Java, History, Video Games

# spring-webApplication-mvc

# Docker build app image:
docker build -f Dockerfile.dev --tag rostikcha/spring-mvc .

# Docker run app container:
docker run --name roscha-web-app-container -p 8091:8091 rostikcha/spring-mvc:latest

# Docker remove all containers:
docker rm $(docker ps --filter status=exited -q)

# Execute shell command inside the container:
docker exec -it roscha-web-app-container sh

#Docker-compose commands:
docker-compose up --build
docker-compose down
