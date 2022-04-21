FROM gradle:6.8.2-jdk15
WORKDIR /app
COPY . /app
EXPOSE 8091
CMD gradle clean bootRun