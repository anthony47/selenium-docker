pipeline{
    agent any
    stages{
        stage('Build Jar'){
            steps{
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image'){
            steps{
                sh "docker build -t=anthony47/dockerize ."
            }
        }
        stage('Push Image'){
            steps{
                sh "docker push anthony47/dockerize"
            }
        }
    }
}