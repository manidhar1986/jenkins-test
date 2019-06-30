

node{

	def config = new OSBCIConfig().getConfig();
	//properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')), parameters([string(defaultValue: '', description: '', name: 'branchName', trim: false)]), pipelineTriggers([pollSCM('* * 1 1 *')])])
	stage('checkout'){
	checkoutCode();
	}
	echo "this is a string ${params.branchName}";

def checkoutCode(config) {
	echo "checking out with ::::::::"
    checkout([$class: 'GitSCM', 
             branches: [[name: params.branchName]], 
			 doGenerateSubmoduleConfigurations: false, 
			 extensions: [], 
			 submoduleCfg: [],
			 userRemoteConfigs: [[url: 'https://github.com/manidhar1986/jenkins-test']]])
	
}
}
