cd authserver
./gradlew clean build
cd -

cd enroll-service
./gradlew clean build
cd -

cd api-gateway 
./gradlew clean build
cd -