pipeline {
  agent any
  environment {
   	AWS_BIN = '/home/ec2-user/.local/bin/aws'
  }

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
	
	  withCredentials([[
            $class: 'AmazonWebServicesCredentialsBinding',
            credentialsId: 'AWS-ECR-Credentials',
            accessKeyVariable: 'AWS_ACCESS_KEY_ID',
            secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
        ]]){
		    sh "docker tag sns-userprofile:latest 994589964344.dkr.ecr.us-east-2.amazonaws.com/sns-userprofile:latest"
			sh "docker push 994589964344.dkr.ecr.us-east-2.amazonaws.com/sns-userprofile:latest"
		}
	} 
	    

  	//sh "docker tag sns-userprofile:latest 994589964344.dkr.ecr.us-east-2.amazonaws.com/sns-userprofile:latest"
	//sh "docker push 994589964344.dkr.ecr.us-east-2.amazonaws.com/sns-userprofile:latest"		
  	}
 
  stage('Remove Unused docker image') {
    steps{
      sh "docker rmi $registry:sns-userprofile:latest"
    }
  }    
}
}