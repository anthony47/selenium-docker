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
                sh "docker build -t=anthony47/seleniumdocker47 ."
            }
        }
        stage('Push Image'){
            environment{
                DOCKER_HUB = credentials('dockerCred')
            }
            steps{
                sh 'echo $DOCKER_HUB_PSW | docker login -u $DOCKER_HUB_USR --password-stdin'
                sh "docker push anthony47/seleniumdocker47"
            }
        }
    }
    post{
        always {
            sh "docker logout"
        }
    }
}