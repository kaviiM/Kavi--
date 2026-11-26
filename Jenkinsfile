// PIPELINE - V1 -> V2 Upgrade ku itha thaan use pannanum
// Code maathi GitHub la Push panna -> Jenkins Build Now -> Puthu Version varum
pipeline {
    agent any
    stages {
        stage('1 - Checkout') { steps { checkout scm } }
        stage('2 - Build JAR') { steps { bat 'set "PATH=%PATH%;C:\\Program Files\\Maven\\apache-maven-3.9.15\\bin;C:\\Windows\\System32" && mvn clean install -DskipTests=true' } }
        stage('3 - Docker Build') { steps { bat 'set "PATH=%PATH%;C:\\Program Files\\Docker\\Docker\\resources\\bin" && docker build --no-cache -t san2-calcus .' } }
        stage('4 - Docker Run - V2') { steps { bat 'set "PATH=%PATH%;C:\\Program Files\\Docker\\Docker\\resources\\bin" && docker rm -f con2-san-calcus || echo "No old container" && docker run -d -p 8097:8090 --name=con2-san-calcus san2-calcus && docker ps && docker logs con2-san-calcus' } }
    }
}
