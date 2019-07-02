

node{
	def config = new OSBCIConfig().getConfig();
	try {
	properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')), parameters([string(defaultValue: '', description: '', name: 'branchName', trim: false)]), pipelineTriggers([pollSCM('* * 1 1 *')])])
	stage('checkout'){
	checkoutCode();
	}
	stage('upload'){
	uploadCode();
	}
	echo "this is a string ${params.branchName}";
	}catch (Exception e){
			 echo "Failure occured at some stage in pipeline with ${params.branchName}";
			//sendEmailNotification(config: config,statusJob: statusJob)
			throw e;
		}
	
	
}
def checkoutCode() {
	echo "checking out with ::::::::"
    checkout([$class: 'GitSCM', 
             branches: [[name: params.branchName]], 
			 doGenerateSubmoduleConfigurations: false, 
			 extensions: [], 
			 submoduleCfg: [],
			 userRemoteConfigs: [[url: 'https://github.com/manidhar1986/jenkins-test']]])
	
}

def uploadCode() {
	def server = Artifactory.newServer url: 'https://myjfrogtest.jfrog.io/myjfrogtest/', username: 'venkat', password: 'Test@123'
	def uploadSpec = """{
      "files": [
        {
          "pattern": "vars/*",
	  "target": "jenkins-integration"
        }
     ]
    }"""	
		server.upload spec: uploadSpec
}
