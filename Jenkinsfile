pipeline {
  environment {
    registry = "gustavoapolinario/docker-test"
    registryCredential = 'docker-hub'
    dockerImage = ''
  }
  agent any

  stages {
    stage('Cloning Git') {
      steps {

        git([
                url: "https://github.com/AjayKhetan297/springboot-dockerdemo-master.git",
                poll: true
            ])
     }
    }
    

	stage('shell executions') {
   		steps{
   			script{
        	   sh 'echo $BUILD_NUMBER'
    		  }
    		}
    		
}

    stage('Gradle Build') {
   		steps{
   			script{
        	  bat 'gradlew.bat clean build'
    		  }
    		}
    		
}
    stage('Building image') {
      steps{
        script {
          dockerImage =  docker.build("ajayk333/samedaydelivery")
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }

  }

}