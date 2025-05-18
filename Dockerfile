FROM bellsoft/liberica-openjdk-alpine:17.0.15
LABEL authors="anthony"

RUN apk add curl jq

WORKDIR /home/selenium-docker

ADD target/docker-resources .
ADD runner.sh runner.sh

#ENTRYPOINT exec java -Dselenium.grid.enabled=true \
#            -Dselenium.grid.hubHost=${HUB_HOST} \
#            -Dbrowser=${BROWSER} -cp 'libs/*' \
#            org.testng.TestNG \
#            -threadcount ${THREAD_COUNT} \
#            test-suites/${TEST_SUITE}

ENTRYPOINT exec sh runner.sh
#ENTRYPOINT ["top", "-b"]