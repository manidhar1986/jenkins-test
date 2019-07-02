

node{

	def config = new OSBCIConfig().getConfig();
	properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')), parameters([string(defaultValue: '', description: '', name: 'branchName', trim: false)]), pipelineTriggers([pollSCM('* * 1 1 *')])])
	stage('checkout'){
	checkoutCode();
	}
	stage('upload'){
	uploadArti();	
	}
	echo "this is a string ${params.branchName}";
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

def uploadArti(){
def server = Artifactory.newServer url: 'https://myjfrogtest.jfrog.io/myjfrogtest/webapp/', username: 'venkat', password: 'Test@123'
def uploadSpec = """{
      "files": [
        {
          "pattern": "**/var*/*",
          "target": "jenkins-integration"
        }
     ]
    }"""
serverArtifactory.upload(uploadSpec)
}
