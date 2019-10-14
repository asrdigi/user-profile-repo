pipeline {
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
         sh "docker build -t sns-userprofile:latest ."
      }
    }

    stage('Push Image to ECR'){
      steps{
      withAWS(credentials:'aws-ecr-credential') {
       script {
	       //def login = ecrLogin()
		   //sh "${login}"
		    sh "docker tag sns-userprofile:latest 994589964344.dkr.ecr.us-east-2.amazonaws.com/sns-userprofile:latest"
        	//docker.withRegistry('https://994589964344.dkr.ecr.us-east-2.amazonaws.com/sns-userprofile:latest', 'ecr:us-east-2:AWS-ECR-Credentials')
        	sh "docker push 994589964344.dkr.ecr.us-east-2.amazonaws.com/sns-userprofile:latest"
        
	   		}
       }
      	//sh "\$(aws ecr get-login)"
      	
     	//withCredentials([usernamePassword(credentialsId: 'hello-kb', passwordVariable: 'pass', usernameVariable: 'user')]) {
    		// the code in here can access $pass and $user
		//}
      	
       
        }
      }
 
  stage('Remove Unused docker image') {
    steps{
      sh "docker rmi $registry:sns-userprofile:latest"
    }
  }    
}
}