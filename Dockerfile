# Dockerfile

# 기반 이미지 설정
FROM eclipse-temurin:17.0.3_7-jre-jammy

# 작업 디렉토리 설정
WORKDIR /app

# 스프링 부트 JAR 파일을 컨테이너 내부로 복사
COPY build/libs/NOP.jar /app/NOP.jar

# 스프링 부트 JAR 파일 실행
CMD ["java", "-jar", "/app/NOP.jar"]