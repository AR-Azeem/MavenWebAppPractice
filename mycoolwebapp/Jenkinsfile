pipeline{
    agent any
    stages{
        stage('Build application'){
            steps{
                sh 'mvn -f mycoolwebapp/pom.xml clean package'
            }
            post{
                success{
                    echo "successfully archieving"
                    archiveArtifacts artifacts : "**/*.war"
                }
            }
        }
        stage('deploy in development'){
            steps{
                build job: 'Deploy'
            }
        }
        stage('Production Stage'){
            steps{
                timeout(time:5,unit:'DAYS'){
                    input message :'Approve Production Deployment!!?'
                }
                build job:'Pipeline to Production Environment'

            }
            
            
        }
    }      
}