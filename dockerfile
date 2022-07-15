FROM amazoncorretto:11
COPY ./out/production/tg-currence-exchange/ /tmp
WORKDIR tmp
ENTRYPOINT ["java", "Starter"]