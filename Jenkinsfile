pipeline {
  environment {
    registry = "psibang19/sns-sapient"
    registryCredential = 'psidocker'
    dockerImage = ''
  }
  agent any
  stages {
	stage('Unit Test') {
	   steps {
	       sh label: '', script: 'mvn test'
       }
   	}
  stage('Jacoco Coverage Report') {
        steps{
            jacoco()
        }
  }
 	/*stage('SonarQube'){
       steps{
           bat label: '', script: '''mvn sonar:sonar \
		 -Dsonar.host.url=http://localhost:9000 \
 		-Dsonar.login=718cd9fb3b6528536826305e194a0411b11e7e94'''
       }
   }*/
	stage('Maven Build'){
		steps{
				sh label: '', script: 'mvn clean install -DskipTests=True'
		}
	}
  stage('Docker Image Build') {
    steps{
	    // sh label: '', script: 'docker build -t cloudconfigservice:latest .'
      script {
        dockerImage = docker.build registry + ":userprofile-service"
      }
    }
  }

  stage('Push Image to DockerHub'){
    steps{
      // sh label: '', script: '''docker tag cloudconfigservice:latest psibang19/cloudconfigservice:latest
      //                         docker push psibang19/cloudconfigservice:latest
      //                       '''
      script {
        docker.withRegistry( '', registryCredential ) {
          dockerImage.push()
        }
      }
    }
  }

  stage('Remove Unused docker image') {
    steps{
      sh "docker rmi $registry:userprofile-service"
    }
  }    
}
}