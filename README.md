### product-reviews

* Push image to quay

./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t quay.io/globex-sentiment-analysis/persist-reviews:latest .
docker push quay.io/globex-sentiment-analysis/persist-reviews:latest